package com.airro.unada

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
import com.airro.unada.data.UserModel
import com.airro.unada.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern



class register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityRegisterBinding
        var validate = false

        var phone = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finalsignup.setOnClickListener {

            val auth = FirebaseAuth.getInstance()

            val email = binding.signid.text.toString()
            val pw = binding.signpassword.text.toString()
            val checkpassword = binding.signcheckpassword.text.toString()

            val id = binding.signid2.text.toString()

            val phonenum = binding.phonenum.text.toString()

            val checkphone = binding.checkphone.text.toString()


            if (email.isEmpty()) {
                Toast.makeText(this,"이메일을 입력하세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(!email.contains("@") || !email.contains(".co")) {
                Toast.makeText(this, "이메일에 @ 및 .co을 포함시키세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (pw.isEmpty() || checkpassword.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$",pw)){
                Toast.makeText(this, "비밀번호 형식을 지켜주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(validate == false){
                Toast.makeText(this, "이메일 중복 체크를 해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(id.contains("admin") || id.contains("uda") || id.contains("관리자") || id.contains("우다") || id.contains("운영자")) {
                Toast.makeText(this, "사용할 수 없는 아이디입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(id.isEmpty()) {
                Toast.makeText(this,"아이디를 입력하세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(phone == false){
                Toast.makeText(this, "휴대전화 인증을 해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                auth.createUserWithEmailAndPassword(email, pw)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                            val user: FirebaseUser? = auth.currentUser

                            val currentUser = Firebase.auth.currentUser
                            val userid = currentUser!!.uid

                            registerid(userid, id, phonenum, email)
                            val userId = currentUser?.uid ?: ""

                            Firebase.messaging.token.addOnCompleteListener {
                                val token = it.result
                                val user = mutableMapOf<String, Any>()
                                user["userId"] = userId
                                user["username"] = email
                                user["phonenum"] = phonenum
                                user["fcmToken"] = token

                                Firebase.database(Key.DB_URL).reference.child(Key.DB_USERS).child(userId)
                                    .updateChildren(user)

                            }

                            finish()
                        } else {
                            Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        val id = findViewById<EditText>(R.id.signid)
        val checkbutton = findViewById<Button>(R.id.checkidabutton)
        checkbutton.setOnClickListener {
            val auth = FirebaseAuth.getInstance()

            val email = binding.signid.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val signInMethods = task.result?.signInMethods
                        if (signInMethods != null && signInMethods.isNotEmpty()) {
                            // 이미 등록된 이메일이 있음
                            Toast.makeText(this, "이미 등록된 이메일입니다.", Toast.LENGTH_SHORT).show()
                        } else {
                            // 등록 가능한 이메일
                            Toast.makeText(this, "사용 가능한 이메일입니다.", Toast.LENGTH_SHORT).show()
                            id.setEnabled(false)
                            validate = true
                            binding.checkidabutton.text = "확인"
                        }
                    } else {
                        // 중복 확인 실패
                        Toast.makeText(this, "이메일 형식으로 입력하세요.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        val phonenum = findViewById<EditText>(R.id.phonenum)
        val checkphone = findViewById<EditText>(R.id.checkphone)
        val sendphonebtn = findViewById<Button>(R.id.sendphone)
        val checkphonebtn = findViewById<Button>(R.id.checkphonebtn)

        var verificationId: String? = null

        sendphonebtn.setOnClickListener {

            val phone = binding.phonenum.text.toString()
            val phoneNumber = "+82" + binding.phonenum.text.toString()

            if (phoneNumber.isEmpty()) {
                Toast.makeText(this, "휴대폰 번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Firebase.firestore.collection("profiles")
                .whereEqualTo("phonenum", phone)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    if (!querySnapshot.isEmpty) {
                        Toast.makeText(this, "이미 등록된 휴대폰 번호입니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        val options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                            .setPhoneNumber(phoneNumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this)
                            .setCallbacks(object :
                                PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                                    val smsCode = credential.smsCode
                                    binding.checkphone.setText(smsCode)
                                }

                                override fun onVerificationFailed(e: FirebaseException) {
                                    Toast.makeText(
                                        this@register,
                                        "오류 발생 잠시후 다시 이용해주세요." +
                                                ": ${e.message}" ,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                override fun onCodeSent(
                                    vId: String,
                                    token: PhoneAuthProvider.ForceResendingToken
                                ) {
                                    super.onCodeSent(vId, token)
                                    verificationId = vId
                                    Toast.makeText(
                                        this@register,
                                        "인증 코드가 전송되었습니다.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                            .build()

                        PhoneAuthProvider.verifyPhoneNumber(options)
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "오류 발생: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
        }

        checkphonebtn.setOnClickListener {
            val smsCode = binding.checkphone.text.toString()

            if (smsCode.isEmpty()) {
                Toast.makeText(this, "인증 코드를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val credential = PhoneAuthProvider.getCredential(verificationId ?: "", smsCode)
            val auth = FirebaseAuth.getInstance()

            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        auth.currentUser?.delete()
                        binding.phonenum.isEnabled = false
                        binding.checkphone.isEnabled = false
                        sendphonebtn.isEnabled = false
                        checkphonebtn.isEnabled = false
                        phone = true
                        Toast.makeText(this, "휴대폰 번호 인증이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "휴대폰 번호 인증에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
        }



        val signpassword = findViewById<EditText>(R.id.signpassword)
        val checkpassword = findViewById<EditText>(R.id.signcheckpassword)
        val pw_confirm = findViewById<TextView>(R.id.pw_confirm)
        val pw_confirm2 = findViewById<TextView>(R.id.pw_confirm2)


        checkpassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(signpassword.getText().toString().equals(checkpassword.getText().toString())){
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
                if(signpassword.getText().toString().equals(checkpassword.getText().toString())){
                    pw_confirm2.setText("비밀번호가 일치합니다.")
                    pw_confirm2.setTextColor(Color.BLACK)
                }
                else{
                    pw_confirm2.setText("비밀번호가 일치하지 않습니다.")
                    pw_confirm2.setTextColor(Color.RED)
                }


            }
        })

        signpassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$",
                        signpassword.getText().toString()
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
                        signpassword.getText().toString()
                    )){
                    pw_confirm.setText("영문/숫자/특수문자를 입력해주세요 (8~20자)")
                    pw_confirm.setTextColor(Color.RED)
                }else{
                    pw_confirm.setText("안전한 비밀번호입니다.")
                    pw_confirm.setTextColor(Color.BLACK)
                }
            }
        })


        val uid = findViewById<EditText>(R.id.signid)
        val email_confirm = findViewById<TextView>(R.id.id_confirm)

        uid.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                        uid.getText().toString()
                    )){
                    email_confirm.setText("이메일 형식으로 입력해주세요")
                    email_confirm.setTextColor(Color.RED)
                }else{
                    email_confirm.setText("")
                }


            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
                        uid.getText().toString()
                    )){
                    email_confirm.setText("이메일 형식으로 입력해주세요")
                    email_confirm.setTextColor(Color.RED)
                }else{
                    email_confirm.setText("")
                }


            }
        })

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun registerid(userid: String, id: String, phonenum: String, email: String) {

        val userModel = UserModel(
            uid = userid,
            id = id,
            phonenum = phonenum,
            email = email,
            profileurl = null
        )

        Firebase.firestore.collection("profiles").document(userid)
            .set(userModel)
            .addOnSuccessListener {

            }.addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this@register,"회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()
            }

    }
}