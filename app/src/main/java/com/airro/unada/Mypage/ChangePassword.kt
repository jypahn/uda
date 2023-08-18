package com.airro.unada.Mypage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.airro.unada.MainActivity
import com.airro.unada.R
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class ChangePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val password = findViewById<EditText>(R.id.password)
        val checkpassword = findViewById<EditText>(R.id.password2)

        val pw_confirm = findViewById<TextView>(R.id.pw_confirm)
        val pw_confirm2 = findViewById<TextView>(R.id.pw_confirm2)

        val changepwbtn = findViewById<Button>(R.id.changepwbutton)


        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        checkpassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(password.getText().toString().equals(checkpassword.getText().toString())){
                    pw_confirm2.setText("비밀번호가 일치합니다.")
                    pw_confirm2.setTextColor(Color.BLACK)
                }
                else{
                    pw_confirm2.setText("비밀번호가 일치하지 않습니다.")
                    pw_confirm2.setTextColor(Color.RED)
                }


            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(password.getText().toString().equals(checkpassword.getText().toString())){
                    pw_confirm2.setText("비밀번호가 일치합니다.")
                    pw_confirm2.setTextColor(Color.BLACK)
                }
                else{
                    pw_confirm2.setText("비밀번호가 일치하지 않습니다.")
                    pw_confirm2.setTextColor(Color.RED)
                }


            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$",
                        password.getText().toString()
                    )){
                    pw_confirm.setText("영문/숫자/특수문자를 입력해주세요 (8~20자)")
                    pw_confirm.setTextColor(Color.RED)
                }else{
                    pw_confirm.setText("안전한 비밀번호입니다")
                    pw_confirm.setTextColor(Color.BLACK)
                }


            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$",
                        password.getText().toString()
                    )){
                    pw_confirm.setText("영문/숫자/특수문자를 입력해주세요 (8~20자)")
                    pw_confirm.setTextColor(Color.RED)
                }else{
                    pw_confirm.setText("안전한 비밀번호입니다.")
                    pw_confirm.setTextColor(Color.BLACK)
                }
            }
        })



        changepwbtn.setOnClickListener {
            val pw = password.text.toString()
            if (pw.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val currentUser = FirebaseAuth.getInstance().currentUser

                if (currentUser != null) {
                    currentUser.updatePassword(pw)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "비밀번호가 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "사용자가 로그인되어 있지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}