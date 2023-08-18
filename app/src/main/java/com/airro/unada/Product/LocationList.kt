package com.airro.unada.Product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class LocationList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_list)

        val articlelist = findViewById<RecyclerView>(R.id.ListRecyclerView)
        val title = findViewById<TextView>(R.id.title)
        val locationtext = intent.getStringExtra("location")
        title.text = locationtext
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
                    article.location!!.contains(locationtext!!, ignoreCase = true)
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


    }
}