package com.airro.unada.Mypage

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
import com.bumptech.glide.Glide
import com.airro.unada.Product.selectlocation
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.airro.unada.login
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.UUID

class ModifyArticle : AppCompatActivity() {

    private val REQUEST_CODE_SELECT_LOCATION = 101


    private var locationText: String? = null


    private var articleId: String? = null

    private lateinit var address: EditText

    private var selltype : String? =null
    private var uri1 : String? =null
    private var uri2 : String? =null
    private var uri3 : String? =null

    private var existingUri1: String? = null
    private var existingUri2: String? = null
    private var existingUri3: String? = null

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
        setContentView(R.layout.activity_modify_article)

        articleId = intent.getStringExtra("articleId")


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


        if (articleId != null) {
            val articleRef = Firebase.firestore.collection("articles").document(articleId!!)
            articleRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val articleModel = documentSnapshot.toObject(ArticleModel::class.java)
                        articleModel?.let {
                            title.setText(it.title)
                            content.setText(it.content)
                            location.text = it.location

                            existingUri1 = it.imageurl1
                            existingUri2 = it.imageurl2
                            existingUri3 = it.imageurl3
                            if (it.selltype == free.text.toString()) {
                                free.visibility = View.VISIBLE
                                nofree.visibility = View.INVISIBLE
                                exchange.visibility = View.INVISIBLE
                                noexchange.visibility = View.VISIBLE
                                selltype = "나눔"
                            } else {
                                exchange.visibility = View.VISIBLE
                                noexchange.visibility = View.INVISIBLE
                                free.visibility = View.INVISIBLE
                                nofree.visibility = View.VISIBLE
                                selltype = "교환"

                            }
                            // Load and display images using the existing image URLs
                            Glide.with(this).load(it.imageurl1).into(photo1)
                            if(it.imageurl2 == null || it.imageurl2 == "") {
                                photo2.setImageResource(R.drawable.baseline_add_a_photo_24)
                            }else {
                                Glide.with(this).load(it.imageurl2).into(photo2)
                            }
                            if(it.imageurl3 == null || it.imageurl3 == ""){
                                photo3.setImageResource(R.drawable.baseline_add_a_photo_24)
                            }else {
                                Glide.with(this).load(it.imageurl3).into(photo3)
                            }
                            uri1 = it.imageurl1
                            uri2 = it.imageurl2
                            uri3 = it.imageurl3

                        }
                    } else {
                        Toast.makeText(this, "Article not found", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Failed to fetch article", Toast.LENGTH_SHORT).show()
                    Log.e("ModifyArticle", "Error fetching article", exception)
                }
        } else {
            Toast.makeText(this, "Invalid articleId", Toast.LENGTH_SHORT).show()
        }


        location.setOnClickListener{
            someFunction()
        }

        val writebtn = findViewById<Button>(R.id.writebtn)
        writebtn.setOnClickListener {
            val articleId = articleId.toString()
            val title = title.text.toString()
            val content = content.text.toString()
            val location = location.text.toString()

            val totalImageUpdates = mutableListOf<Pair<Uri?, Int>>() // Store image updates and their indices

            if (selectedUri1 != null) totalImageUpdates.add(Pair(selectedUri1!!, 1))
            if (selectedUri2 != null) totalImageUpdates.add(Pair(selectedUri2!!, 2))
            if (selectedUri3 != null) totalImageUpdates.add(Pair(selectedUri3!!, 3))

            if (totalImageUpdates.isNotEmpty()) {
                uploadImagesAndUpdateArticle(articleId, content, totalImageUpdates, location, currentUserId, title, selltype.toString())
            } else {
                updateArticle(articleId, content, uri1, uri2, uri3, location, currentUserId, title, selltype.toString())
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
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

    private fun uploadImagesAndUpdateArticle(
        articleId: String,
        content: String,
        totalImageUpdates: List<Pair<Uri?, Int>>,
        location: String,
        writeId: String,
        title: String,
        selltype: String
    ) {
        val imageUpdate = totalImageUpdates.first()
        val uri = imageUpdate.first
        val imageIndex = imageUpdate.second

        val filename = "Article/${UUID.randomUUID()}.png"
        val storageReference = Firebase.storage.reference.child("articles/photo/$filename")

        storageReference.putFile(uri!!)
            .addOnSuccessListener { _ ->
                storageReference.downloadUrl
                    .addOnSuccessListener { downloadUri ->
                        when (imageIndex) {
                            1 -> uri1 = downloadUri.toString()
                            2 -> uri2 = downloadUri.toString()
                            3 -> uri3 = downloadUri.toString()
                        }

                        val remainingUpdates = totalImageUpdates.drop(1)

                        if (remainingUpdates.isNotEmpty()) {
                            uploadImagesAndUpdateArticle(articleId, content, remainingUpdates, location, writeId, title, selltype)
                        } else {
                            updateArticle(articleId, content, uri1, uri2, uri3, location, writeId, title, selltype)
                            finish()
                        }
                    }
            }
            .addOnFailureListener {
            }
    }



    private fun someFunction() {
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




    private fun updateArticle(
        articleId: String,
        content: String,
        photoUri1: String?,
        photoUri2: String?,
        photoUri3: String?,
        location: String,
        writeId: String,
        title: String,
        selltype: String
    ) {
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

                finish()

            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this@ModifyArticle, "글 수정에 실패했습니다", Toast.LENGTH_SHORT).show()
            }
    }

}