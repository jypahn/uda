package com.airro.unada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.airro.unada.Key.Companion.DB_URL
import com.airro.unada.Key.Companion.DB_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class login : AppCompatActivity() {


    lateinit var auth: FirebaseAuth

    var backKeyPressedTime : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.email)
        val pw = findViewById<EditText>(R.id.pw)
        val loginbtn = findViewById<Button>(R.id.login)

        loginbtn.setOnClickListener{
            val email = email.text.toString()
            val pw = pw. text.toString()
            Login(email,pw)
        }


        val registerbutton = findViewById<Button>(R.id.register)
        registerbutton.setOnClickListener{
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        val findpwbtn = findViewById<Button>(R.id.Find)
        findpwbtn.setOnClickListener {
            val intent = Intent(this, FindId::class.java)
            startActivity(intent)
        }

    }
    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    override fun onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2500) {
            Toast.makeText(this, "버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
            backKeyPressedTime = System.currentTimeMillis()
        } else {
            finishAffinity()
        }
    }

    private fun Login(email: String, pw: String) {
        auth.signInWithEmailAndPassword(email,pw)
            .addOnCompleteListener { result ->
                val currentUser = Firebase.auth.currentUser
                if (result.isSuccessful) {
                    val userId = currentUser?.uid ?: ""

                    Firebase.messaging.token.addOnCompleteListener {
                        val token = it.result
                        val user = mutableMapOf<String, Any>()
                        user["userId"] = userId
                        user["username"] = email
                        user["fcmToken"] = token

                        Firebase.database(DB_URL).reference.child(DB_USERS).child(userId)
                            .updateChildren(user)

                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }


                }
                else{
                    Toast.makeText(this, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }
    }
}