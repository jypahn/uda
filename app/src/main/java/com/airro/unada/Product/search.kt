package com.airro.unada.Product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.airro.unada.R

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val search = findViewById<EditText>(R.id.searchtext)
        val searchbtn = findViewById<ImageView>(R.id.searchbtn)

        searchbtn.setOnClickListener {
            val searchtext = search.text.toString()
            if(searchtext == ""){
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SearchList::class.java)
                intent.putExtra("searchtext", searchtext)
                startActivity(intent)
            }
        }
        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }
    }
}