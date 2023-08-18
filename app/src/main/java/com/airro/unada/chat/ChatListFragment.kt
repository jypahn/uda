package com.airro.unada.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airro.unada.R
import com.airro.unada.chat.ChatKey.Companion.DB_URL
import com.airro.unada.chatdetail.ChatActivity
import com.airro.unada.databinding.FragmentChatlistBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatListFragment : Fragment(R.layout.fragment_chatlist) {

    private lateinit var binding: FragmentChatlistBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatlistBinding.bind(view)

        val nochat = binding.nochat


        val chatListAdapter = ChatListAdapter{ChatRoomItem ->
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra(ChatActivity.EXTRA_SEND_USER_ID, ChatRoomItem.sendUserName)
            intent.putExtra(ChatActivity.EXTRA_CHAT_ROOM_ID, ChatRoomItem.chatRoomId)
            intent.putExtra(ChatActivity.value, ChatRoomItem.value)

            startActivity(intent)
        }

        binding.chatListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatListAdapter
        }




        val currentUserId = Firebase.auth.currentUser?.uid ?: return
        val chatRoomsDB = Firebase.database(DB_URL).reference.child(ChatKey.DB_CHAT_ROOMS).child(currentUserId)
        chatRoomsDB.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val chatRoomList = snapshot.children.map {
                    it.getValue(ChatRoomItem::class.java)
                }
                chatListAdapter.submitList(chatRoomList)

                if (chatRoomList.isEmpty()) {
                    nochat.visibility = View.VISIBLE
                } else {
                    nochat.visibility = View.GONE
                }            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        loadChatList()


    }

    private fun loadChatList() {
        val chatListAdapter = ChatListAdapter { ChatRoomItem ->
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra(ChatActivity.EXTRA_SEND_USER_ID, ChatRoomItem.sendUserName)
            intent.putExtra(ChatActivity.EXTRA_CHAT_ROOM_ID, ChatRoomItem.chatRoomId)

            intent.putExtra(ChatActivity.value, ChatRoomItem.value)

            startActivity(intent)
        }

        binding.chatListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatListAdapter
        }

        val currentUserId = Firebase.auth.currentUser?.uid ?: return
        val chatRoomsDB = Firebase.database(DB_URL).reference.child(ChatKey.DB_CHAT_ROOMS).child(currentUserId)
            .orderByChild("lastDate")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val chatRoomList = snapshot.children.mapNotNull {
                        it.getValue(ChatRoomItem::class.java)
                    }.reversed()

                    chatListAdapter.submitList(chatRoomList)

                    if (chatRoomList.isEmpty()) {
                        binding.nochat.visibility = View.VISIBLE
                    } else {
                        binding.nochat.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("ChatListFragment", "Error reading chat rooms: ${error.message}")
                }
            })
    }

    override fun onResume() {
        super.onResume()
        loadChatList()
    }
}