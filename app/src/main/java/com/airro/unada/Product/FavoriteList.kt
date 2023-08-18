package com.airro.unada.Product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class FavoriteList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_list)


        val articlelist = findViewById<RecyclerView>(R.id.ListRecyclerView)

        val currentUserId = Firebase.auth.currentUser?.uid

        if (currentUserId != null) {
            Firebase.firestore.collection("bookmark")
                .whereArrayContains("uid", currentUserId)
                .get()
                .addOnSuccessListener { bookmarksSnapshot ->
                    val bookmarkedArticleIds = bookmarksSnapshot.documents.map { it.id }

                    if (bookmarkedArticleIds.isEmpty()) {
                        articlelist.layoutManager = LinearLayoutManager(this)
                        articlelist.adapter = ArticleAdapter(emptyList())
                    } else {
                        Firebase.firestore.collection("articles")
                            .whereIn(FieldPath.documentId(), bookmarkedArticleIds)
                            .get()
                            .addOnSuccessListener { articlesSnapshot ->
                                val list = articlesSnapshot.map {
                                    it.toObject<ArticleModel>()
                                }
                                articlelist.layoutManager = LinearLayoutManager(this)
                                articlelist.adapter = ArticleAdapter(list)
                            }
                            .addOnFailureListener { exception ->
                                exception.printStackTrace()
                            }
                    }
                }
                .addOnFailureListener { exception ->
                    exception.printStackTrace()


                    articlelist.layoutManager = LinearLayoutManager(this)
                    articlelist.adapter = ArticleAdapter(emptyList())
                }
        }
    }
}
