package com.airro.unada.chatdetail

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.UserItem
import com.airro.unada.chat.ChatKey
import com.airro.unada.chat.ChatKey.Companion.DB_URL
import com.airro.unada.chat.ChatRoomItem
import com.airro.unada.data.UserModel
import com.airro.unada.databinding.ActivityChatdetailBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class ChatActivity: AppCompatActivity() {

    private lateinit var binding: ActivityChatdetailBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatReference: DatabaseReference

    private var chatRoomId : String = ""
    private var sendUserId: String = ""
    private var otherUserFcmToken: String = ""
    private var myId : String = ""


    private var inChatRoom = false


    private val chatItemList = mutableListOf<ChatItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatdetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chatAdapter = ChatAdapter()
        linearLayoutManager = LinearLayoutManager(applicationContext)


        myId = Firebase.auth.currentUser?.uid ?: return

        chatRoomId = intent.getStringExtra(EXTRA_CHAT_ROOM_ID) ?: return
        sendUserId = intent.getStringExtra(EXTRA_SEND_USER_ID) ?: return


        var value = intent.getStringExtra(value) ?: return

        if(value == "no"){

            binding.sendbtn.isEnabled = false
            binding.sendbtn.setBackgroundColor(Color.GRAY)
            binding.message.isFocusable = false
            binding.message.setText("상대방이 채팅방을 나갔습니다.")
        }else{
            binding.sendbtn.isEnabled = true

        }


        chatAdapter.sendUserId = sendUserId

        getOtherUserData()

        inChatRoom = true

        val userRef = Firebase.firestore.collection("profiles").document(sendUserId)
        userRef.get()
            .addOnSuccessListener { document ->
                if( document != null && document.exists()){
                    val profile = document.toObject<UserModel>()
                    profile?.let{
                        binding.text.text = it.id

                    }
                }else{

                }
            }
            .addOnFailureListener { exception ->

            }




        Firebase.database(DB_URL).reference.child(ChatKey.DB_CHATS).child(chatRoomId).addChildEventListener( object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val chatItem = snapshot.getValue(ChatItem::class.java)
                chatItem ?: return


                if (chatItem.userId != myId && inChatRoom) {
                    Firebase.database(DB_URL).reference.child(ChatKey.DB_CHATS)
                        .child(chatRoomId).child(snapshot.key ?: "").child("read")
                        .setValue(true)

                }

                chatItemList.add(chatItem)



                chatAdapter.submitList(chatItemList.toMutableList())
                binding.chatRecyclerView.scrollToPosition(chatItemList.size - 1)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onChildRemoved(snapshot: DataSnapshot) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        )


        binding.chatRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = chatAdapter
        }


        chatAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)

                linearLayoutManager.smoothScrollToPosition(
                    binding.chatRecyclerView,
                    null,
                    chatAdapter.itemCount
                )
            }
        })

        binding.sendbtn.setOnClickListener {
            val message = binding.message.text.toString()

            if(message.isEmpty()){
                Toast.makeText(applicationContext, "메시지를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newChatItem = ChatItem(
                message = message,
                userId = myId,
                date = System.currentTimeMillis()
            )

            Firebase.database(DB_URL).reference.child(ChatKey.DB_CHATS).child(chatRoomId).push().apply {
                newChatItem.chatId = key
                setValue(newChatItem)
            }

            var lastDate = System.currentTimeMillis()


            val updates: MutableMap<String, Any> = hashMapOf(
                "${ChatKey.DB_CHAT_ROOMS}/$myId/$sendUserId/lastMessage" to message,
                "${ChatKey.DB_CHAT_ROOMS}/$sendUserId/$myId/lastMessage" to message,
                "${ChatKey.DB_CHAT_ROOMS}/$myId/$sendUserId/chatRoomId" to chatRoomId,
                "${ChatKey.DB_CHAT_ROOMS}/$sendUserId/$myId/chatRoomId" to chatRoomId,
                "${ChatKey.DB_CHAT_ROOMS}/$myId/$sendUserId/sendUserName" to sendUserId,
                "${ChatKey.DB_CHAT_ROOMS}/$sendUserId/$myId/sendUserName" to myId,
                "${ChatKey.DB_CHAT_ROOMS}/$myId/$sendUserId/lastDate" to lastDate,
                "${ChatKey.DB_CHAT_ROOMS}/$sendUserId/$myId/lastDate" to lastDate,
                "${ChatKey.DB_CHAT_ROOMS}/$myId/$sendUserId/value" to "yes",
                "${ChatKey.DB_CHAT_ROOMS}/$sendUserId/$myId/value" to "yes",
                )
            Firebase.database(DB_URL).reference.updateChildren(updates)

            sendNotification(message, myId)


            binding.message.text.clear()
            }


        chatReference = Firebase.database(DB_URL).reference.child(ChatKey.DB_CHATS).child(chatRoomId)

        chatReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                chatItemList.clear()
                for (childSnapshot in snapshot.children) {
                    val chatItem = childSnapshot.getValue(ChatItem::class.java)
                    chatItem ?: continue
                    chatItemList.add(chatItem)
                }
                chatAdapter.submitList(chatItemList.toMutableList())
                binding.chatRecyclerView.scrollToPosition(chatItemList.size - 1)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ChatActivity", "Error reading chat messages: ${error.message}")
            }
        })
        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun getOtherUserData() {
        Firebase.database(DB_URL).reference.child(ChatKey.DB_USERS).child(sendUserId).get()
            .addOnSuccessListener { snapshot ->
                val otherUserItem = snapshot.getValue(UserItem::class.java)
                otherUserFcmToken = otherUserItem?.fcmToken.toString()
            }
            .addOnFailureListener { exception ->
                Log.e("ChatActivity", "Failed to get other user data: ${exception.message}")
            }
    }

    private fun sendNotification(message: String, myId: String) {
        if (otherUserFcmToken.isNullOrEmpty()) {
            Log.e("ChatActivity", "Other user FCM token is null or empty.")
            return
        }

        val client = OkHttpClient()

        val root = JSONObject()
        val notification = JSONObject()

        val userRef = Firebase.firestore.collection("profiles").document(myId)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val profile = document.toObject<UserModel>()
                    profile?.let {
                        val sendUserName = it.id!!
                        notification.put("title", sendUserName)
                        notification.put("body", message)

                        root.put("to", otherUserFcmToken)
                        root.put("priority", "high")
                        root.put("notification", notification)

                        val requestBody =
                            root.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
                        val request =
                            Request.Builder().post(requestBody)
                                .url("https://fcm.googleapis.com/fcm/send")
                                .header("Authorization", "key=${getString(R.string.fcm_server_key)}")
                                .build()

                        client.newCall(request).enqueue(object : Callback {
                            override fun onFailure(call: Call, e: IOException) {
                                e.stackTraceToString()
                            }

                            override fun onResponse(call: Call, response: Response) {
                                // ignore onResponse
                                Log.e("Chat", response.toString())
                            }
                        })
                    }
                } else {
                }
            }
            .addOnFailureListener { exception ->
            }
    }


    override fun onPause() {
        super.onPause()

        inChatRoom = false

    }




    companion object{
        const val EXTRA_CHAT_ROOM_ID = "chatRoomId"
        const val EXTRA_SEND_USER_ID = "sendUserId"
        const val value = "value"

    }

}