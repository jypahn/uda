package com.airro.unada.Product

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class SearchList<T> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchlist)

        val articlelist = findViewById<RecyclerView>(R.id.ListRecyclerView)
        val title = findViewById<TextView>(R.id.title)
        val searchtext = intent.getStringExtra("searchtext")
        title.text = searchtext
        val nosearch = findViewById<TextView>(R.id.nosearch)

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        Firebase.firestore.collection("articles")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                val list = result.map {
                    it.toObject<ArticleModel>()
                }

                val filteredList = list.filter { article ->
                    article.title!!.contains(searchtext!!, ignoreCase = true) ||
                            article.content!!.contains(searchtext, ignoreCase = true)
                }

                if (filteredList.isEmpty()) {
                    articlelist.visibility = View.GONE
                    nosearch.visibility = View.VISIBLE
                } else {
                    articlelist.visibility = View.VISIBLE
                    nosearch.visibility = View.GONE
                    articlelist.layoutManager = LinearLayoutManager(this)
                    articlelist.adapter = ArticleAdapter(filteredList)
                }
            }

        val searchbtn = findViewById<ImageView>(R.id.searchbtn)

        searchbtn.setOnClickListener {
            startActivity(Intent(this, search::class.java))

        }
    }
}
