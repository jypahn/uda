package com.airro.unada.Product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class FavoriteListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_favorite_list, container, false)

        val articlelist = rootView.findViewById<RecyclerView>(R.id.ListRecyclerView)

        val currentUserId = Firebase.auth.currentUser?.uid

        val nofavorite = rootView.findViewById<TextView>(R.id.nofavorite)

        if (currentUserId != null) {
            Firebase.firestore.collection("bookmark")
                .whereArrayContains("uid", currentUserId)
                .get()
                .addOnSuccessListener { bookmarksSnapshot ->
                    val bookmarkedArticleIds = bookmarksSnapshot.documents.map { it.id }

                    if (bookmarkedArticleIds.isEmpty()) {
                        nofavorite.visibility = View.VISIBLE
                        articlelist.layoutManager = LinearLayoutManager(requireContext())
                        articlelist.adapter = ArticleAdapter(emptyList())
                    } else {
                        nofavorite.visibility = View.INVISIBLE

                        Firebase.firestore.collection("articles")
                            .whereIn(FieldPath.documentId(), bookmarkedArticleIds)
                            .get()
                            .addOnSuccessListener { articlesSnapshot ->
                                val list = articlesSnapshot.map {
                                    it.toObject<ArticleModel>()
                                }
                                articlelist.layoutManager = LinearLayoutManager(requireContext())
                                articlelist.adapter = ArticleAdapter(list)
                            }
                            .addOnFailureListener { exception ->
                                exception.printStackTrace()
                            }
                    }
                }
                .addOnFailureListener { exception ->
                    exception.printStackTrace()


                    articlelist.layoutManager = LinearLayoutManager(requireContext())
                    articlelist.adapter = ArticleAdapter(emptyList())
                }
        }

        return rootView
    }
}
