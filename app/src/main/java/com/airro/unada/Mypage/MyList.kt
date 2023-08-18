package com.airro.unada.Mypage

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MyList<T> : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myarticlelist)

        val mylist = findViewById<TextView>(R.id.noarticle)

        auth = FirebaseAuth.getInstance()

        val currentUserId =Firebase.auth.currentUser?.uid ?: ""


        val articlelist = findViewById<RecyclerView>(R.id.ListRecyclerView)

        Firebase.firestore.collection("articles")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .whereEqualTo("writeId", currentUserId)
            .get()
            .addOnSuccessListener { result ->
                val list = result.map{
                    it.toObject<ArticleModel>()
                }
                if(list.isEmpty()){
                    mylist.visibility = View.VISIBLE
                    mylist.text = "작성한 글이 없습니다."
                }else {
                    mylist.visibility = View.INVISIBLE

                    articlelist.layoutManager = LinearLayoutManager(this)
                    articlelist.adapter = MyArticleAdapter(list)
                }
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreError", "Error fetching data: ${e.message}")
            }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }
    }
}