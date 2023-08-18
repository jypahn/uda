package com.airro.unada.Product

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

class Declaration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_declaration)

        val currentUserId = Firebase.auth.currentUser?.uid ?: ""

        var articleId = intent.getStringExtra("articleId") ?: ""


        val content = findViewById<EditText>(R.id.context)
        val writebtn = findViewById<Button>(R.id.writebtn)
        writebtn.setOnClickListener {
            val content = content.text.toString()
            if(content == null || content == ""){
                Snackbar.make(writebtn,"내용을 입력해주세요", Snackbar.LENGTH_SHORT).show()

            }else{
                uploadDeclaration(currentUserId,content,articleId)
                finish()
            }
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun uploadDeclaration(currentUserId: String, content: String, articleId: String) {
        val DeclarationId = UUID.randomUUID().toString()
        val DeclarationModel = DeclarationModel(
            DeclarationId = DeclarationId,
            ArticleId = articleId,
            uid = currentUserId,
            content = content,
            createdAt = System.currentTimeMillis()
        )

        Firebase.firestore.collection("Declarations").document(System.currentTimeMillis().toString())
            .set(DeclarationModel)
            .addOnSuccessListener {
                Toast.makeText(this@Declaration,"신고가 접수되었습니다ㄴㄹㅇ", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this@Declaration,"글 작성에 실패했습니다", Toast.LENGTH_SHORT).show()
            }

    }
}