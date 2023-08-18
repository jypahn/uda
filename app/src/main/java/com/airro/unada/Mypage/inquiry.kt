package com.airro.unada.Mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.airro.unada.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.UUID

class inquiry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquiry)


        val currentUserId = Firebase.auth.currentUser?.uid ?: ""

        val content = findViewById<EditText>(R.id.context)
        val writebtn = findViewById<Button>(R.id.writebtn)
        writebtn.setOnClickListener {
            val content = content.text.toString()
            if(content == null || content == ""){
                Snackbar.make(writebtn,"내용을 입력해주세요", Snackbar.LENGTH_SHORT).show()

            }else{
                uploadInquiry(currentUserId,content)
                finish()
            }
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun uploadInquiry(currentUserId: String, content: String) {
        val inquiryId = UUID.randomUUID().toString()
        val inquiryModel = InquiryModel(
            inquiryId = inquiryId,
            uid = currentUserId,
            content = content,
            createdAt = System.currentTimeMillis()
            )

        Firebase.firestore.collection("inquiries").document(System.currentTimeMillis().toString())
            .set(inquiryModel)
            .addOnSuccessListener {

            }.addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this@inquiry,"글 작성에 실패했습니다", Toast.LENGTH_SHORT).show()
            }

    }
}