package com.airro.unada.Product

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.collections.List

class ArticleAdapter(private val articleList: List<ArticleModel>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articleList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val imageView: ImageView = itemView.findViewById(R.id.thumbnailImageView)
        private val locationView: TextView = itemView.findViewById(R.id.location)
        private val dateView: TextView = itemView.findViewById(R.id.date)
        private val typeView: TextView = itemView.findViewById(R.id.type)
        private val sellstatusView: TextView = itemView.findViewById(R.id.sellstatus)

        fun bind(article: ArticleModel) {
            titleTextView.text = article.title

            if(article.location == ""){
                locationView.text = "위치 정보 없음"
            }else{
                locationView.text = article.location

            }

            typeView.text = article.selltype

            if(article.sellStatus == "거래 완료"){
                sellstatusView.visibility = View.VISIBLE
                sellstatusView.text = article.sellStatus
            }else{
                sellstatusView.visibility = View.GONE
                sellstatusView.text = article.sellStatus
            }


            Glide.with(itemView.context)
                .load(article.imageurl1)
                .into(imageView)

            val date = article.createdAt
            val now = System.currentTimeMillis()
            val time = (now - date!!) / 1000

            val timeText = when {
                time < 60 -> "${time}초 전"
                time < 3600 -> "${time / 60}분 전"
                time < 86400 -> "${time / 3600}시간 전"
                time < 2592000 -> "${time / 86400}일 전"
                else -> {
                    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    val dateStr = sdf.format(Date(date))
                    dateStr
                }
            }

            dateView.text = timeText


            itemView.setOnClickListener {
                val intent = Intent(itemView.context, Detail::class.java)
                intent.putExtra("articleId", article.articleId)
                itemView.context.startActivity(intent)
            }
        }
    }
}
