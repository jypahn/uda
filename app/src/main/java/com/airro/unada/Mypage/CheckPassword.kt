package com.airro.unada.Mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.airro.unada.R
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class CheckPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_password)

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        val pw = findViewById<EditText>(R.id.password)

        val checkpwbutton = findViewById<Button>(R.id.checkpwbutton)

        checkpwbutton.setOnClickListener {
            val enteredPassword = pw.text.toString()

            val currentUser = FirebaseAuth.getInstance().currentUser

            if (enteredPassword == null || enteredPassword == "") {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT)

            }else{
                if (currentUser != null) {
                    val userEmail = currentUser.email


                    val credential =
                        userEmail?.let { EmailAuthProvider.getCredential(it, enteredPassword) }
                    if (credential != null) {
                        currentUser.reauthenticate(credential)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val intent = Intent(this, ChangePassword::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        this,
                                        "비밀번호가 일치하지 않습니다",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    } else {
                        Toast.makeText(this, "잠시 후 재시도 해주세요", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        this, "로그인 오류 " +
                                "로그아웃 후 재시도해주세요", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
