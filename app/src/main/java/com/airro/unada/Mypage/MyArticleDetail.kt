package com.airro.unada.Mypage

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.airro.unada.MainActivity
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.data.ArticleModel
import com.airro.unada.data.BookmarkModel
import com.airro.unada.data.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MyArticleDetail : AppCompatActivity() {

    private var currentUserId: String? = null
    private var articleId: String? = null
    private var sendUserId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_article_detail)

        val userImage = findViewById<ImageView>(R.id.userimage)
        val titleText = findViewById<TextView>(R.id.title)
        val contextText = findViewById<TextView>(R.id.context)
        val usernameText = findViewById<TextView>(R.id.username)
        val locationText = findViewById<TextView>(R.id.location)
        val dateText = findViewById<TextView>(R.id.date)
        val itemImage = findViewById<ViewPager2>(R.id.ItemImage)
        val selltypeText = findViewById<TextView>(R.id.selltype)

        currentUserId = Firebase.auth.currentUser?.uid ?: ""
        articleId = intent.getStringExtra("articleId")



        val articleRef = Firebase.firestore.collection("articles").document(articleId.toString())
        articleRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val article = document.toObject<ArticleModel>()
                    article?.let {
                        titleText.text = it.title
                        contextText.text = it.content

                        val imageUrlList = listOf(it.imageurl1, it.imageurl2, it.imageurl3)

                        itemImage.adapter = ImageSliderAdapter(imageUrlList)


                        val date = it.createdAt
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

                        dateText.text = timeText




                        val uid = it.writeId
                        sendUserId = it.writeId

                        val userRef = Firebase.firestore.collection("profiles").document(uid.toString())
                        userRef.get()
                            .addOnSuccessListener { document ->
                                if( document != null && document.exists()){
                                    val profile = document.toObject<UserModel>()
                                    profile?.let{
                                        usernameText.text = it.id

                                        if(it.profileurl == null) {
                                            userImage.setImageResource(R.drawable.profile)

                                        }else{

                                            Glide.with(this)
                                                .load(it.profileurl)
                                                .into(userImage)

                                        }
                                    }
                                }else{

                                }
                            }
                            .addOnFailureListener { exception ->

                            }



                        if(it.location == ""){
                            locationText.text = "위치 정보 없음"
                        }else{
                            locationText.text = it.location

                        }

                        selltypeText.text = it.selltype
                    }
                } else {
                    finish()
                    Toast.makeText(this@MyArticleDetail, "존재하지 않는 매물입니다.", Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener { exception ->
                finish()
                Toast.makeText(this@MyArticleDetail, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }








        val bookmarkCountText = findViewById<TextView>(R.id.bookmarkCountText)

        val bookmarkcountRef = Firebase.firestore.collection("bookmark").document(articleId.toString())
        bookmarkcountRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w(ContentValues.TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val bookmarkModel = snapshot.toObject<BookmarkModel>()
                val bookmarkedUserIds = bookmarkModel?.uid

                val bookmarkCount = bookmarkedUserIds?.size ?: 0
                bookmarkCountText.text = "$bookmarkCount"
            } else {
                bookmarkCountText.text = "0"
            }
        }


        val modifybtn = findViewById<Button>(R.id.modifybtn)


        modifybtn.setOnClickListener {

            val intent = Intent(this, ModifyArticle::class.java)
            intent.putExtra("articleId", articleId)
            startActivity(intent)
            finish()
        }


        findViewById<View>(R.id.menubtn).setOnClickListener { view ->
            val popupMenu = PopupMenu(applicationContext, view)
            menuInflater.inflate(R.menu.popup, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_menu1 -> showsellPopup()
                    R.id.action_menu2 -> showPopup()
                }
                false
            }
            popupMenu.show()
        }

        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

    }

    private fun showsellPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.delete_confirm, null)
        val textView: TextView = view.findViewById(R.id.confirmTextView)
        textView.text = "거래 상태 변경"

        val alertDialog = AlertDialog.Builder(this)
            .create()

        val okbtn = view.findViewById<Button>(R.id.yesbtn)
        okbtn.text = "거래 중"
        okbtn.setOnClickListener {
            updateSellStatus("거래 중")
            alertDialog.dismiss()
        }

        val nobtn = view.findViewById<Button>(R.id.nobtn)
        nobtn.text = "거래 완료"
        nobtn.setOnClickListener {
            updateSellStatus("거래 완료")
            alertDialog.dismiss()
        }
        alertDialog.setView(view)
        alertDialog.show()
    }

    private fun updateSellStatus(newStatus: String) {
        val articleRef = Firebase.firestore.collection("articles").document(articleId.toString())

        articleRef.update("sellStatus", newStatus)
            .addOnSuccessListener {
                Toast.makeText(this, "거래 상태가 변경되었습니다.", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "거래 상태 변경에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
    }


    private fun showPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.delete_confirm, null)
        val textView: TextView = view.findViewById(R.id.confirmTextView)
        textView.text = "삭제하시겠습니까?"

        val alertDialog = AlertDialog.Builder(this)
            .create()

        val okbtn = view.findViewById<Button>(R.id.yesbtn)
        okbtn.setOnClickListener {
            backupArticle()
            deleteArticleFromFirestore()
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }

        val nobtn = view.findViewById<Button>(R.id.nobtn)
        nobtn.setOnClickListener {
            Toast.makeText(applicationContext, "취소", Toast.LENGTH_SHORT).show()
            alertDialog.dismiss()
        }
        alertDialog.setView(view)
        alertDialog.show()
    }

    private fun backupArticle() {
        val articleRef = Firebase.firestore.collection("articles").document(articleId.toString())

        articleRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val article = documentSnapshot.toObject<ArticleModel>()
                    if (article != null) {
                        // 복사할 위치의 참조를 만듭니다. 예를 들어, "backup_articles" 컬렉션에 복사하려면:
                        val backupCollectionRef = Firebase.firestore.collection("delete_articles")
                        // 기존 문서 데이터를 가져와서 새 문서를 생성하여 복사합니다.
                        backupCollectionRef.add(article)
                            .addOnSuccessListener { _ ->
                                // 복사 성공 처리
                            }
                            .addOnFailureListener { exception ->
                                // 복사 실패 처리
                            }
                    } else {
                        // article이 null일 경우 처리
                    }
                } else {
                    // document가 존재하지 않을 경우 처리

                }
            }
            .addOnFailureListener { exception ->
                // 데이터 가져오기 실패

            }
    }


    private fun deleteArticleFromFirestore() {
        val articleRef = Firebase.firestore.collection("articles").document(articleId.toString())

        articleRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val article = documentSnapshot.toObject<ArticleModel>()
                    if (article != null) {
                        articleRef.delete()
                            .addOnSuccessListener {
                                Toast.makeText(applicationContext, "게시글이 삭제되었습니다.", Toast.LENGTH_SHORT).show()

                                finish()

                                val imageUrlList = listOf(article.imageurl1, article.imageurl2, article.imageurl3)

                                for (imageUrl in imageUrlList) {
                                    if (!imageUrl.isNullOrEmpty()) {
                                        deleteImageFromStorage(imageUrl)
                                    }
                                }
                            }
                            .addOnFailureListener { exception ->
                                Toast.makeText(applicationContext, "게시글 삭제에 실패했습니다.", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                    }
                } else {
                    finish()
                    Toast.makeText(this@MyArticleDetail, "존재하지 않는 매물입니다.", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                // 데이터 가져오기 실패
                finish()
                Toast.makeText(this@MyArticleDetail, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
    }


    private fun deleteImageFromStorage(imageUrl: String) {
        val storageReference = Firebase.storage.getReferenceFromUrl(imageUrl)
        storageReference.delete()
            .addOnSuccessListener {
                Log.d("ImageDeletion", "이전 이미지 삭제 성공.")
            }
            .addOnFailureListener { exception ->
                Log.e("ImageDeletion", "이전 이미지 삭제 실패: ${exception.message}")
            }

    }




    class ImageSliderAdapter(private val imageUrlList: List<String?>) :
        RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_slider_item, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageUrl = imageUrlList[position]
            holder.bind(imageUrl)
        }

        override fun getItemCount(): Int {
            return imageUrlList.count { !it.isNullOrEmpty() }
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val imageView: ImageView = itemView.findViewById(R.id.imageView)

            fun bind(imageUrl: String?) {
                if (!imageUrl.isNullOrEmpty()) {
                    Glide.with(itemView.context)
                        .load(imageUrl)
                        .into(imageView)
                } else {
                    imageView.setImageDrawable(null)
                }
            }
        }
    }

}