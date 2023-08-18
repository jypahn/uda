package com.airro.unada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FindId : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)


        val resetpw = findViewById<Button>(R.id.resetidwbutton)


        resetpw.setOnClickListener {

            val id = findViewById<TextView>(R.id.userid)
            val phone = findViewById<EditText>(R.id.userphone)
            val phonenum = phone.text.toString()
            if (phonenum == null || phonenum == "") {
                Toast.makeText(this, "전화번호를 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Firebase.firestore.collection("profiles")
                    .whereEqualTo("phonenum", phonenum)
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        if (!querySnapshot.isEmpty) {
                            // Phone number was found, handle the result
                            val userDocument = querySnapshot.documents[0]
                            val userEmail = userDocument.getString("email") // Fetch the email field
                            id.text = "아이디는 " + userEmail + " 입니다."
                        } else {
                            Toast.makeText(this, "해당 전화번호로 등록된 계정이 없습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(this, "오류 발생: ${exception.message}", Toast.LENGTH_SHORT).show()
                    }
            }




        }



        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }


        val findpwbtn = findViewById<TextView>(R.id.findpw)

        findpwbtn.setOnClickListener {
            val intent = Intent(this, FindPassword::class.java)
            startActivity(intent)
        }
    }
}