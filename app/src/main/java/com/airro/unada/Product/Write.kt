package com.airro.unada.Product

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.airro.unada.MainActivity
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.UUID


class Write : AppCompatActivity() {
    private val REQUEST_CODE_SELECT_LOCATION = 101


    private var locationText: String? = null

    private var selltype : String? =null
    private var uri1 : String? =null
    private var uri2 : String? =null
    private var uri3 : String? =null

    private lateinit var photo1: ImageView
    private lateinit var photo2: ImageView
    private lateinit var photo3: ImageView
    private var selectedUri1: Uri? = null
    private var selectedUri2: Uri? = null
    private var selectedUri3: Uri? = null

    private val pickMedia1 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedUri1 = uri
            photo1.setImageURI(uri)
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }
    private val pickMedia2 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedUri2 = uri
            photo2.setImageURI(uri)
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    private val pickMedia3 = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedUri3 = uri
            photo3.setImageURI(uri)
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val currentUserId = Firebase.auth.currentUser?.uid ?: ""

        val title = findViewById<EditText>(R.id.title)
        val content = findViewById<EditText>(R.id.context)
        val free = findViewById<Button>(R.id.free)
        val exchange = findViewById<Button>(R.id.exchange)
        val location = findViewById<TextView>(R.id.clickgps)
        val noexchange = findViewById<Button>(R.id.noexchange)
        val nofree = findViewById<Button>(R.id.nofree)

        exchange.visibility = View.INVISIBLE

        free.visibility = View.INVISIBLE


        free.setOnClickListener {
            selltype = free.text.toString()
            free.visibility = View.VISIBLE
            nofree.visibility = View.INVISIBLE
            exchange.visibility = View.INVISIBLE
            noexchange.visibility = View.VISIBLE


        }

        nofree.setOnClickListener {
            selltype = free.text.toString()
            free.visibility = View.VISIBLE
            nofree.visibility = View.INVISIBLE
            exchange.visibility = View.INVISIBLE
            noexchange.visibility = View.VISIBLE


        }

        exchange.setOnClickListener {
            selltype = exchange.text.toString()
            noexchange.visibility = View.INVISIBLE
            exchange.visibility = View.VISIBLE
            free.visibility = View.INVISIBLE
            nofree.visibility = View.VISIBLE

        }

        noexchange.setOnClickListener {
            selltype = exchange.text.toString()
            noexchange.visibility = View.INVISIBLE
            exchange.visibility = View.VISIBLE
            free.visibility = View.INVISIBLE
            nofree.visibility = View.VISIBLE

        }

        photo1 = findViewById(R.id.camera1)
        photo2 = findViewById(R.id.camera2)
        photo3 = findViewById(R.id.camera3)

        photo1.setOnClickListener {
            pickMedia1.launch("image/*")
        }
        photo2.setOnClickListener {
            pickMedia2.launch("image/*")
        }
        photo3.setOnClickListener {
            pickMedia3.launch("image/*")
        }


        location.setOnClickListener{
            someFunction()

        }

        val writebtn = findViewById<Button>(R.id.writebtn)
        writebtn.setOnClickListener {
            val title = title.text.toString()
            val content = content.text.toString()
            val location = location.text.toString()
            if(title == null || content == null || selltype == null || content == "") {
                Toast.makeText(this@Write,"항목을 입력해주세요", Toast.LENGTH_SHORT).show()

            }else{
                if (selectedUri1 != null) {
                    val photoUri1 = selectedUri1!!

                    val filename = "Article/${UUID.randomUUID()}.png"
                    val storageReference =
                        Firebase.storage.reference.child("articles/photo/$filename")
                    storageReference.putFile(photoUri1)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                storageReference.downloadUrl
                                    .addOnSuccessListener { uri ->
                                        Log.e("aa", uri.toString())
                                        uri1 = uri.toString()

                                        if (selectedUri2 != null) {
                                            val photoUri2 = selectedUri2!!

                                            val filename = "${UUID.randomUUID()}.png"
                                            val storageReference =
                                                Firebase.storage.reference.child("articles/photo/$filename")
                                            storageReference.putFile(photoUri2)
                                                .addOnCompleteListener { task ->
                                                    if (task.isSuccessful) {
                                                        storageReference.downloadUrl
                                                            .addOnSuccessListener { uri ->
                                                                Log.e("bb", uri.toString())
                                                                uri2 = uri.toString()

                                                                if (selectedUri3 != null) {
                                                                    val photoUri3 = selectedUri3!!

                                                                    val filename =
                                                                        "${UUID.randomUUID()}.png"
                                                                    val storageReference =
                                                                        Firebase.storage.reference.child(
                                                                            "articles/photo/$filename"
                                                                        )
                                                                    storageReference.putFile(
                                                                        photoUri3
                                                                    )
                                                                        .addOnCompleteListener { task ->
                                                                            if (task.isSuccessful) {
                                                                                storageReference.downloadUrl
                                                                                    .addOnSuccessListener { uri ->
                                                                                        Log.e(
                                                                                            "cc",
                                                                                            uri.toString()
                                                                                        )
                                                                                        uri3 =
                                                                                            uri.toString()

                                                                                        selltype?.let { selltype ->
                                                                                            uploadArticle(
                                                                                                content,
                                                                                                uri1,
                                                                                                uri2,
                                                                                                uri3,
                                                                                                location,
                                                                                                currentUserId,
                                                                                                title,
                                                                                                selltype
                                                                                            )
                                                                                        }

                                                                                        val intent =
                                                                                            Intent(
                                                                                                this,
                                                                                                MainActivity::class.java
                                                                                            )
                                                                                        startActivity(
                                                                                            intent
                                                                                        )
                                                                                    }
                                                                            } else {
                                                                                // 파일 업로드 실패
                                                                            }
                                                                        }
                                                                } else {
                                                                    selltype?.let { selltype ->
                                                                        uploadArticle(
                                                                            content,
                                                                            uri1,
                                                                            uri2,
                                                                            uri3,
                                                                            location,
                                                                            currentUserId,
                                                                            title,
                                                                            selltype
                                                                        )
                                                                    }

                                                                    val intent = Intent(
                                                                        this,
                                                                        MainActivity::class.java
                                                                    )
                                                                    startActivity(intent)
                                                                }
                                                            }
                                                    } else {
                                                        // 파일 업로드 실패
                                                    }
                                                }
                                        } else {
                                            selltype?.let { selltype ->
                                                uploadArticle(
                                                    content,
                                                    uri1,
                                                    uri2,
                                                    uri3,
                                                    location,
                                                    currentUserId,
                                                    title,
                                                    selltype
                                                )
                                            }

                                            val intent = Intent(
                                                this,
                                                MainActivity::class.java
                                            )
                                            startActivity(intent)
                                        }
                                    }
                            } else {
                                // 파일 업로드 실패
                            }
                        }
                } else {
                    Snackbar.make(
                        writebtn,
                        "사진을 선택해주세요.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        val gpsbtn = findViewById<ImageView>(R.id.gps)
        gpsbtn.setOnClickListener {
        }



    }

    fun someFunction() {
        val intent = Intent(this, selectlocation::class.java)
        startActivityForResult(intent, REQUEST_CODE_SELECT_LOCATION)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_LOCATION && resultCode == Activity.RESULT_OK) {
            val selectedLocation = data?.getStringExtra("location")
            val locationEditText = findViewById<TextView>(R.id.clickgps)
            locationText = selectedLocation
            locationEditText.setText(selectedLocation)
        }
    }

    private fun uploadArticle(
        content: String, photoUri1: String?,
        photoUri2: String?, photoUri3: String?, location: String, writeId: String, title: String, selltype: String){
        val articleId = UUID.randomUUID().toString()
        val articleModel = ArticleModel(
            articleId = articleId,
            createdAt = System.currentTimeMillis(),
            content = content,
            imageurl1 = photoUri1,
            imageurl2 = photoUri2,
            imageurl3 = photoUri3,
            location = location,
            selltype = selltype,
            writeId = writeId,
            title = title

        )

        Firebase.firestore.collection("articles").document(articleId)
            .set(articleModel)
            .addOnSuccessListener {

            }.addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this@Write,"글 작성에 실패했습니다", Toast.LENGTH_SHORT).show()
            }

    }

}