package com.airro.unada.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.chat.ChatKey.Companion.DB_URL
import com.airro.unada.chatdetail.ChatItem
import com.airro.unada.data.UserModel
import com.airro.unada.databinding.ItemChatlistBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import me.leolin.shortcutbadger.ShortcutBadger
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class ChatListAdapter(private val onClick: (ChatRoomItem) -> Unit,) : ListAdapter<ChatRoomItem, ChatListAdapter.ViewHolder>(differ) {

    inner class ViewHolder(private val binding: ItemChatlistBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {





        fun bind(item: ChatRoomItem, kFunction0: () -> Unit) {
            var sendname = item.sendUserName ?: ""

            val userRef = Firebase.firestore.collection("profiles").document(sendname)
            userRef.get()
                .addOnSuccessListener { document ->
                    if( document != null && document.exists()){
                        val profile = document.toObject<UserModel>()
                        profile?.let{
                            binding.username.text = it.id

                            if(it.profileurl == null) {
                                binding.userimage.setImageResource(R.drawable.profile)

                            }else{

                                Glide.with(context)
                                    .load(it.profileurl)
                                    .into(binding.userimage)

                            }
                        }
                    }else{

                    }
                }
                .addOnFailureListener { exception ->

                }





            binding.lastmessage.text = item.lastMessage

            calculateUnreadMessageCount(item) { unreadCount ->

                updateUnreadMessageCount(unreadCount)
            }





            val lastDateInMillis = item.lastDate ?: 0
            val now = System.currentTimeMillis()

            val diffInMillis = now - lastDateInMillis
            val diffInMinutes = diffInMillis / (60 * 1000)
            val diffInHours = diffInMillis / (60 * 60 * 1000)
            val diffInDays = diffInMillis / (24 * 60 * 60 * 1000)

            val dateFormatter: SimpleDateFormat
            val lastDate = Date(lastDateInMillis)


            val dateString = when {
                diffInMinutes < 60 -> "${diffInMinutes}분 전"
                diffInHours < 24 -> "${diffInHours}시간 전"
                diffInDays < 10 -> "${diffInDays}일 전"
                else -> {
                    // If the year is the same as the current year, show only the date
                    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                    val lastYear = Calendar.getInstance().apply { time = lastDate }.get(Calendar.YEAR)

                    dateFormatter = if (currentYear == lastYear) {
                        SimpleDateFormat("M월 d일", Locale.KOREA)
                    } else {
                        SimpleDateFormat("yyyy년 M월 d일", Locale.KOREA)
                    }

                    dateFormatter.format(lastDate)
                }
            }

            binding.lastdate.text = dateString


            binding.root.setOnClickListener{
                onClick(item)

            }

            binding.root.setOnLongClickListener {
                showLongPressConfirmationDialog(item)
                true
            }



        }

        private fun showLongPressConfirmationDialog(item: ChatRoomItem) {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.delete_confirm, null)
            val textView: TextView = view.findViewById(R.id.confirmTextView)
            textView.text = "채팅방을 나가시겠습니까?"

            val alertDialog = androidx.appcompat.app.AlertDialog.Builder(context)
                .create()

            val okbtn = view.findViewById<Button>(R.id.yesbtn)
            okbtn.text = "나가기"
            okbtn.setOnClickListener {
                leaveChatRoom(item)
                alertDialog.dismiss()

            }

            val nobtn = view.findViewById<Button>(R.id.nobtn)
            nobtn.text = "취소"
            nobtn.setOnClickListener {
                alertDialog.dismiss()
            }
            alertDialog.setView(view)
            alertDialog.show()
        }


        private fun leaveChatRoom(item: ChatRoomItem) {
            val currentUserId = Firebase.auth.currentUser?.uid ?: return
            val chatRoomId = item.chatRoomId ?: return
            var sendname = item.sendUserName ?: ""
            val value = "no"

            val chatRoomReference = Firebase.database(DB_URL).reference.child("ChatRooms").child(currentUserId).child(sendname)
            chatRoomReference.removeValue()

            val valueReference = Firebase.database(DB_URL).reference.child("ChatRooms").child(sendname).child(currentUserId)
            valueReference.child("value").setValue(value)

            val updatedList = currentList.toMutableList()
            updatedList.remove(item)

            // 변경 사항을 알림
            submitList(updatedList)

                 }



        private fun updateUnreadMessageCount(unreadCount: Int) {
            if (unreadCount > 0) {
                binding.unreadCountTextView.visibility = View.VISIBLE
                binding.unreadCountTextView.text = unreadCount.toString()

                setBadge(context, unreadCount)
            } else {
                binding.unreadCountTextView.visibility = View.GONE

                removeBadge(context)
            }
        }


        private fun calculateUnreadMessageCount(item: ChatRoomItem, callback: (Int) -> Unit) {
            val currentUserId = Firebase.auth.currentUser?.uid ?: return
            val chatRoomId = item.chatRoomId ?: return

            val chatRoomReference = Firebase.database(DB_URL).reference.child("Chats").child(chatRoomId)

            var unreadCount = 0

            chatRoomReference.addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val ChatItem = snapshot.getValue(ChatItem::class.java) ?: return

                    if (ChatItem.userId != currentUserId && !ChatItem.read) {
                        unreadCount++
                    }

                    callback(unreadCount)
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

                }

                override fun onChildRemoved(snapshot: DataSnapshot) {

                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })



        }

        private fun setBadge(context: Context, count: Int) {
            val shortcutBadger = ShortcutBadger.applyCount(context, count)
            if (!shortcutBadger) {
            }
        }

        private fun removeBadge(context: Context) {
            val shortcutBadger = ShortcutBadger.removeCount(context)
            if (!shortcutBadger) {
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChatlistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context

        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], this::notifyDataSetChanged)
    }


    companion object {
        val differ = object : DiffUtil.ItemCallback<ChatRoomItem>() {
            override fun areItemsTheSame(oldItem: ChatRoomItem, newItem: ChatRoomItem): Boolean {
                return oldItem.chatRoomId == newItem.chatRoomId
            }

            override fun areContentsTheSame(oldItem: ChatRoomItem, newItem: ChatRoomItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}
