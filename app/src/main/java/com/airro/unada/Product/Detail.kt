package com.airro.unada.Product

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.chat.ChatKey.Companion.DB_CHAT_ROOMS
import com.airro.unada.chat.ChatKey.Companion.DB_URL
import com.airro.unada.chat.ChatRoomItem
import com.airro.unada.chatdetail.ChatActivity
import com.airro.unada.data.ArticleModel
import com.airro.unada.data.BookmarkModel
import com.airro.unada.data.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import kotlin.collections.List

class Detail : AppCompatActivity() {

    private lateinit var heart: ImageView
    private lateinit var emptyheart: ImageView
    private var currentUserId: String? = null
    private var articleId: String? = null
    private var sendUserId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val userImage = findViewById<ImageView>(R.id.userimage)
        val titleText = findViewById<TextView>(R.id.title)
        val contextText = findViewById<TextView>(R.id.context)
        val usernameText = findViewById<TextView>(R.id.username)
        val locationText = findViewById<TextView>(R.id.location)
        val dateText = findViewById<TextView>(R.id.date)
        val itemImage = findViewById<ViewPager2>(R.id.ItemImage)
        val selltypeText = findViewById<TextView>(R.id.selltype)

        currentUserId = Firebase.auth.currentUser?.uid ?: ""
        articleId = intent.getStringExtra("articleId")

        heart = findViewById<View>(R.id.Heart) as ImageView
        emptyheart = findViewById<View>(R.id.EmptyHeart) as ImageView


        val articleRef = Firebase.firestore.collection("articles").document(articleId.toString())
        articleRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val article = document.toObject<ArticleModel>()
                    article?.let {
                        titleText.text = it.title
                        contextText.text = it.content


                        val imageUrlList = listOf(it.imageurl1, it.imageurl2, it.imageurl3)

                        itemImage.adapter = ImageSliderAdapter(imageUrlList)


                        val date = it.createdAt
                        val now = System.currentTimeMillis()
                        val time = (now - date!!) / 1000

                        val timeText = when {
                            time < 60 -> "${time}초 전"
                            time < 3600 -> "${time / 60}분 전"
                            time < 86400 -> "${time / 3600}시간 전"
                            time < 2592000 -> "${time / 86400}일 전"
                            else -> {
                                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                                val dateStr = sdf.format(Date(date))
                                dateStr
                            }
                        }

                        dateText.text = timeText




                        val uid = it.writeId
                        sendUserId = it.writeId

                        val userRef = Firebase.firestore.collection("profiles").document(uid.toString())
                        userRef.get()
                            .addOnSuccessListener { document ->
                                if( document != null && document.exists()){
                                    val profile = document.toObject<UserModel>()
                                    profile?.let{
                                        usernameText.text = it.id

                                        if(it.profileurl == null) {
                                            userImage.setImageResource(R.drawable.profile)

                                        }else{

                                            Glide.with(this)
                                                .load(it.profileurl)
                                                .into(userImage)

                                        }
                                    }
                                }else{

                                }
                            }
                            .addOnFailureListener { exception ->

                            }


                        if(it.location == ""){
                            locationText.text = "위치 정보 없음"
                        }else{
                            locationText.text = it.location

                        }

                        selltypeText.text = it.selltype
                    }
                } else {
                    finish()
                    Toast.makeText(this@Detail, "존재하지 않는 매물입니다.", Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener { exception ->
                finish()
                Toast.makeText(this@Detail, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }





        emptyheart.setOnClickListener {

            setBookmark(currentUserId!!)

        }

        heart.setOnClickListener {
            deleteBookmark(currentUserId!!)
        }


        val bookmarkRef = Firebase.firestore.collection("bookmark").document(articleId.toString())
        bookmarkRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val bookmarkModel = snapshot.toObject<BookmarkModel>()
                val bookmarkedUserIds = bookmarkModel?.uid

                if (bookmarkedUserIds?.contains(currentUserId) == true) {
                    emptyheart.visibility = View.INVISIBLE
                    heart.visibility = View.VISIBLE
                } else {
                    emptyheart.visibility = View.VISIBLE
                    heart.visibility = View.INVISIBLE
                }
            } else {
                emptyheart.visibility = View.VISIBLE
                heart.visibility = View.INVISIBLE
            }
        }

        val bookmarkCountText = findViewById<TextView>(R.id.bookmarkCountText)

        val bookmarkcountRef = Firebase.firestore.collection("bookmark").document(articleId.toString())
        bookmarkcountRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val bookmarkModel = snapshot.toObject<BookmarkModel>()
                val bookmarkedUserIds = bookmarkModel?.uid

                val bookmarkCount = bookmarkedUserIds?.size ?: 0
                bookmarkCountText.text = "$bookmarkCount"
            } else {
                bookmarkCountText.text = "0"
            }
        }


        val chatbtn = findViewById<Button>(R.id.chatbtn)


        chatbtn.setOnClickListener {
            val myId = Firebase.auth.currentUser?.uid ?: ""

            if(myId != sendUserId){
            val chatRoomDB = Firebase.database(DB_URL).reference.child(DB_CHAT_ROOMS).child(myId).child(
                sendUserId.toString()
            )

            chatRoomDB.get().addOnSuccessListener {

                var chatRoomId = ""
                if (it.value != null) {
                    val chatRoom = it.getValue(ChatRoomItem::class.java)
                    chatRoomId = chatRoom?.chatRoomId ?: ""
                } else {

                    chatRoomId = UUID.randomUUID().toString()
                    val newChatRoom = ChatRoomItem(
                        chatRoomId = chatRoomId,
                        sendUserName = sendUserId,
                        value = "yes"
                    )
                    chatRoomDB.setValue(newChatRoom)
                }

                val intent = Intent(this, ChatActivity::class.java)
                intent.putExtra(ChatActivity.EXTRA_SEND_USER_ID, sendUserId)
                intent.putExtra(ChatActivity.EXTRA_CHAT_ROOM_ID, chatRoomId)
                intent.putExtra(ChatActivity.value, "yes")

                startActivity(intent)
            }
            }else{
                Toast.makeText(this, "내가 작성한 글에서는 사용이 불가능합니다.", Toast.LENGTH_SHORT).show()
            }
        }

        val declarationbtn = findViewById<TextView>(R.id.declaration)

        declarationbtn.setOnClickListener {
            val intent = Intent(this, Declaration::class.java)
            intent.putExtra("articleId", articleId)
            startActivity(intent)
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun deleteBookmark(currentUserId: String) {
        val bookmarkRef = Firebase.firestore.collection("bookmark").document(articleId.toString())

        bookmarkRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val bookmarkModel = documentSnapshot.toObject<BookmarkModel>()

                    val uidList = bookmarkModel?.uid?.toMutableList() ?: mutableListOf()
                    if (uidList.contains(currentUserId)) {
                        uidList.remove(currentUserId)
                    }

                    bookmarkRef.set(BookmarkModel(uidList))
                        .addOnSuccessListener {
                            emptyheart.visibility = View.VISIBLE
                            heart.visibility = View.INVISIBLE
                        }
                        .addOnFailureListener {
                            it.printStackTrace()
                        }
                }
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }


    private fun setBookmark(currentUserId: String) {
        val bookmarkRef = Firebase.firestore.collection("bookmark").document(articleId.toString())

        bookmarkRef.get()
            .addOnSuccessListener { documentSnapshot ->
                val bookmarkModel = if (documentSnapshot.exists()) {
                    documentSnapshot.toObject<BookmarkModel>()
                } else {
                    BookmarkModel()
                }

                val uidList = bookmarkModel?.uid?.toMutableList() ?: mutableListOf()
                if (!uidList.contains(currentUserId)) {
                    uidList.add(currentUserId)
                }

                bookmarkRef.set(BookmarkModel(uidList))
                    .addOnSuccessListener {
                        emptyheart.visibility = View.INVISIBLE
                        heart.visibility = View.VISIBLE
                    }
                    .addOnFailureListener {
                        it.printStackTrace()
                    }
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }

    class ImageSliderAdapter(private val imageUrlList: List<String?>) :
        RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_slider_item, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageUrl = imageUrlList[position]
            holder.bind(imageUrl)
        }

        override fun getItemCount(): Int {
            return imageUrlList.count { !it.isNullOrEmpty() }
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val imageView: ImageView = itemView.findViewById(R.id.imageView)

            fun bind(imageUrl: String?) {
                if (!imageUrl.isNullOrEmpty()) {
                    Glide.with(itemView.context)
                        .load(imageUrl)
                        .into(imageView)
                } else {
                    imageView.setImageDrawable(null)
                }
            }
        }
    }

}