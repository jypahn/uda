package com.airro.unada.Mypage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.airro.unada.Key
import com.airro.unada.R
import com.airro.unada.login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class DeleteId : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val firestore = FirebaseFirestore.getInstance()
    private val database = FirebaseDatabase.getInstance()
    private val storage = FirebaseStorage.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_id)

        auth = FirebaseAuth.getInstance()


        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        val deletebtn = findViewById<Button>(R.id.deleteid)

        deletebtn.setOnClickListener {
            showPopup()
        }
    }

    private fun showPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.delete_confirm, null)
        val textView: TextView = view.findViewById(R.id.confirmTextView)
        textView.text = "정말로 계정을 삭제하시겠습니까?"

        val alertDialog = AlertDialog.Builder(this)
            .create()

        val okbtn = view.findViewById<Button>(R.id.yesbtn)
        okbtn.setOnClickListener {
            val user = auth.currentUser
            val userId = user?.uid ?: ""

            auth.signOut()


            user?.delete()
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        firestore.collection("profiles").document(userId).delete()
                        Firebase.database(Key.DB_URL).reference.child("Users").child(userId).removeValue()
                        val storageRef = storage.reference.child("profile_images").child(userId + ".jpg")
                        storageRef.delete()


                        Toast.makeText(applicationContext, "계정이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, login::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(applicationContext, "계정 삭제 실패", Toast.LENGTH_SHORT).show()
                    }
                    alertDialog.dismiss()
                }

        }

        val nobtn = view.findViewById<Button>(R.id.nobtn)
        nobtn.setOnClickListener {
            Toast.makeText(applicationContext, "취소", Toast.LENGTH_SHORT).show()
            alertDialog.dismiss()
        }
        alertDialog.setView(view)
        alertDialog.show()
    }

}