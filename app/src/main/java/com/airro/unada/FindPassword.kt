package com.airro.unada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FindPassword : AppCompatActivity() {
    private val TAG = "FindPassword"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)

        val restpwbtn = findViewById<Button>(R.id.resetpwbutton)

        restpwbtn.setOnClickListener {
            val id = findViewById<EditText>(R.id.userid)
            val emailAddress = id.text.toString()
            if (emailAddress == null || emailAddress == "") {
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Firebase.auth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                            Toast.makeText(this, "비밀번호 재설정 이메일이 발송되었습니다.", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
            val backbtn = findViewById<ImageView>(R.id.backbutton)
            backbtn.setOnClickListener {
                finish()
            }


    }
}