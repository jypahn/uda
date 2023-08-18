package com.airro.unada.chatdetail

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.data.UserModel
import com.airro.unada.databinding.ItemChatBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.Date


class ChatAdapter : ListAdapter<ChatItem, ChatAdapter.ViewHolder>(differ) {

    var sendUserId : String? = null

    private val DATE_VIEW_TYPE = 0
    private val CHAT_VIEW_TYPE = 1

    inner class ViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {




        fun bind(item: ChatItem) {

            val previousMessageIndex = adapterPosition - 1

            if (previousMessageIndex >= 0) {
                val previousItem = currentList[previousMessageIndex]
                if (!areSameDate(item.date!!, previousItem.date!!)) {
                    binding.dateTextView.visibility = View.VISIBLE
                    binding.dateTextView.text = formatDate(item.date!!)
                } else {
                    binding.dateTextView.visibility = View.GONE
                }
            } else {
                binding.dateTextView.visibility = View.VISIBLE
                binding.dateTextView.text = formatDate(item.date!!)
            }

            if(item.userId == sendUserId ) {

                binding.read.visibility = View.GONE


                val userRef = Firebase.firestore.collection("profiles").document(sendUserId.toString())
                userRef.get()
                    .addOnSuccessListener { document ->
                        if( document != null && document.exists()){
                            val profile = document.toObject<UserModel>()
                            profile?.let{
                                binding.username.text = it.id.toString()

                            }
                        }else{

                        }
                    }
                    .addOnFailureListener { exception ->

                    }

                binding.username.isVisible = true
                binding.message.text = item.message
                binding.message.gravity = Gravity.START
                binding.sendtime.isVisible = false
                binding.receivetime.isVisible = true

                val itemDateMillis: Long = item.date!!

                val itemDate = Date(itemDateMillis)

                val dateFormat = SimpleDateFormat("HH:mm")
                val formattedDate = dateFormat.format(itemDate)

                val hours = itemDate.hours
                val timePrefix = if (hours < 12) "오전" else "오후"

                val finalFormattedDate = "$timePrefix $formattedDate"

                binding.receivetime.text = finalFormattedDate



                binding.cardView.layoutParams = (binding.cardView.layoutParams as ConstraintLayout.LayoutParams).apply {
                    endToEnd = ConstraintLayout.LayoutParams.UNSET
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                }

            }else{
                binding.username.isVisible = false
                binding.message.text =item.message
                binding.message.gravity = Gravity.END
                binding.receivetime.isVisible = false
                binding.sendtime.isVisible = true


                if (item.read == true) {
                    binding.read.visibility = View.VISIBLE
                    binding.read.text = "읽음"
                } else {
                    binding.read.visibility = View.VISIBLE
                    binding.read.text = "읽지 않음"
                }


                val itemDateMillis: Long = item.date!!

                val itemDate = Date(itemDateMillis)

                val dateFormat = SimpleDateFormat("HH:mm")
                val formattedDate = dateFormat.format(itemDate)

                val hours = itemDate.hours
                val timePrefix = if (hours < 12) "오전" else "오후"

                val finalFormattedDate = "$timePrefix $formattedDate"

                binding.sendtime.text = finalFormattedDate

                binding.cardView.layoutParams = (binding.cardView.layoutParams as ConstraintLayout.LayoutParams).apply {
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    startToStart = ConstraintLayout.LayoutParams.UNSET
                }


            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }



    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return DATE_VIEW_TYPE
        }
        val currentItem = currentList[position]
        val previousItem = currentList[position - 1]
        return if (!areSameDate(currentItem.date!!, previousItem.date!!)) {
            DATE_VIEW_TYPE
        } else CHAT_VIEW_TYPE
    }

    private fun formatDate(dateMillis: Long): String {
        val itemDate = Date(dateMillis)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(itemDate)
    }

    private fun areSameDate(dateMillis1: Long, dateMillis2: Long): Boolean {
        val date1 = formatDate(dateMillis1)
        val date2 = formatDate(dateMillis2)
        return date1 == date2
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<ChatItem>() {
            override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem.chatId == newItem.chatId
            }

            override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}
