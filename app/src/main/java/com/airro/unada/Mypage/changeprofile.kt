package com.airro.unada.Mypage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.airro.unada.MainActivity
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.data.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.UUID

class changeprofile : AppCompatActivity() {

    lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changeprofile)

        auth = FirebaseAuth.getInstance()


        val profileimage = findViewById<ImageView>(R.id.userImage)

        val userid = findViewById<EditText>(R.id.modifyid2)

        val modiftbtn = findViewById<Button>(R.id.modifybtn)

        val currentUserId = Firebase.auth.currentUser?.uid ?: ""


        val userRef = Firebase.firestore.collection("profiles").document(currentUserId)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val profile = document.toObject<UserModel>()
                    profile?.let {

                        userid.setText(it.id)

                        if (it.profileurl == null) {
                            profileimage.setImageResource(R.drawable.profile)
                        } else {
                            Glide.with(this)
                                .load(it.profileurl)
                                .into(profileimage)
                        }
                    }
                } else {
                    // Handle document not found case.
                }
            }
            .addOnFailureListener { exception ->
                // Handle failure case.
            }


        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

            if (uri != null) {
                uploadImageToFirebaseStorage(uri)
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

        val prfileImage = findViewById<ImageView>(R.id.userImage)
        prfileImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }


        modiftbtn.setOnClickListener {
            val userIdText = userid.text.toString() // EditText에서 텍스트를 가져옵니다.

            if(userIdText.contains("admin") || userIdText.contains("uda") || userIdText.contains("관리자") || userIdText.contains("우다") || userIdText.contains("운영자")) {
                Toast.makeText(this, "사용할 수 없는 아이디입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                modifyid()
            }
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun modifyid() {
        val currentUserId = auth.currentUser?.uid ?: ""
        val modifyid = findViewById<EditText>(R.id.modifyid2).text.toString() // Get the modified ID text

        val userRef = Firebase.firestore.collection("profiles").document(currentUserId)
        userRef.update("id", modifyid)
            .addOnSuccessListener {
                Log.d("FirestoreUpdate", "프로필 아이디 업데이트 성공.")

                Toast.makeText(this, "프로필이 수정되었습니다.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreUpdate", "프로필 아이디 업데이트 실패: ${exception.message}")
                Toast.makeText(this, "오류가 발생했습니다. \n잠시후 시도해주세요", Toast.LENGTH_SHORT).show()

            }
    }



    private fun uploadImageToFirebaseStorage(imageUrl: Uri) {
        val currentUserId = auth.currentUser?.uid ?: ""

        val filename = "Profile/$currentUserId.png"
        val storageReference = Firebase.storage.reference.child("profiles/photo/$filename")
        storageReference.putFile(imageUrl)
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    storageReference.downloadUrl
                        .addOnSuccessListener { uri ->
                            Log.e("profileimage", uri.toString())
                            updateProfileImageUriToFirestore(uri.toString())
                        }
                }else{
                    Log.e("profileimage", "프로필 이미지 업로드 실패")
                }

            }
        deletePreviousProfileImage()


    }

    private fun deletePreviousProfileImage() {
        // 현재 유저의 ID를 가져옵니다.
        val currentUserId = auth.currentUser?.uid ?: ""

        // Firestore에서 현재 유저의 프로필 정보를 가져옵니다.
        val userRef = Firebase.firestore.collection("profiles").document(currentUserId)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    // 이전 프로필 이미지 URL을 가져옵니다.
                    val previousProfileUrl = document.getString("profileurl")
                    // 이전 프로필 이미지가 존재하면 삭제합니다.
                    if (!previousProfileUrl.isNullOrEmpty()) {
                        deleteImageFromFirebaseStorage(previousProfileUrl)
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreRead", "이전 프로필 이미지 조회 실패: ${exception.message}")
            }
    }

    private fun deleteImageFromFirebaseStorage(imageUrl: String) {
        val storageReference = Firebase.storage.getReferenceFromUrl(imageUrl)
        storageReference.delete()
            .addOnSuccessListener {
                Log.d("ImageDeletion", "이전 프로필 이미지 삭제 성공.")
            }
            .addOnFailureListener { exception ->
                Log.e("ImageDeletion", "이전 프로필 이미지 삭제 실패: ${exception.message}")
            }
    }

    private fun updateProfileImageUriToFirestore(photouri: String) {
        val currentUserId = auth.currentUser?.uid ?: ""
        val profileimage = findViewById<ImageView>(R.id.userImage)

        val userRef = Firebase.firestore.collection("profiles").document(currentUserId)
        userRef.update("profileurl", photouri)
            .addOnSuccessListener {
                Log.d("FirestoreUpdate", "프로필 이미지 업데이트 성공.")

                Glide.with(this)
                    .load(photouri)
                    .into(profileimage)

                Toast.makeText(this, "이미지가 변경되었습니다.", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreUpdate", "프로필 이미지 업데이트 실패: ${exception.message}")
            }
    }

}