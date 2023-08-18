package com.airro.unada.Product

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
class ListFragment : Fragment() {

    private lateinit var articlelist: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private var isScrolling = false

    private lateinit var nolist: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articlelist = view.findViewById(R.id.ListRecyclerView)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)

        setupRecyclerView()

        val searchbtn = view.findViewById<ImageView>(R.id.searchbtn)

        searchbtn.setOnClickListener {
            startActivity(Intent(requireActivity(), search::class.java))
        }

        val locationhbtn = view.findViewById<ImageView>(R.id.locationbtn)

        locationhbtn.setOnClickListener {
            startActivity(Intent(requireActivity(), SelectCategory::class.java))

        }

        nolist = view.findViewById<TextView>(R.id.nolist)


        // Set scroll listener for RecyclerView
        articlelist.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                isScrolling = newState != RecyclerView.SCROLL_STATE_IDLE

                // Check if scrolling has stopped and refresh if needed
                if (!isScrolling && swipeRefreshLayout.isRefreshing) {
                    fetchDataAndRefreshList()
                }
            }
        })

        fetchDataAndRefreshList()
    }

    private fun setupRecyclerView() {
        articlelist.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun fetchDataAndRefreshList() {
        swipeRefreshLayout.isRefreshing = true

        Firebase.firestore.collection("articles")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                val list = result.map {
                    it.toObject<ArticleModel>()
                }

                if(list.isEmpty()){
                    nolist.visibility=View.VISIBLE
                    nolist.text="목록이 비었습니다."
                }else {
                    articlelist.adapter = ArticleAdapter(list)
                    swipeRefreshLayout.isRefreshing = false
                    nolist.visibility=View.INVISIBLE

                }
            }
            .addOnFailureListener { exception ->
                swipeRefreshLayout.isRefreshing = false
            }
    }
}



