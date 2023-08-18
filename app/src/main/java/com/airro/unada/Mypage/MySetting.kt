package com.airro.unada.Mypage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import com.airro.unada.MyFirebaseMessagingService
import com.airro.unada.Product.Declaration
import com.airro.unada.R

class MySetting : AppCompatActivity() {

    private lateinit var soundbtn: Switch
    private var notificationsEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_setting)

        soundbtn = findViewById(R.id.sound)

        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        notificationsEnabled = sharedPrefs.getBoolean("notificationsEnabled", true)
        soundbtn.isChecked = notificationsEnabled

        soundbtn.setOnCheckedChangeListener { _, isChecked ->
            notificationsEnabled = isChecked

            val editor = sharedPrefs.edit()
            editor.putBoolean("notificationsEnabled", notificationsEnabled)
            editor.apply()

            updateNotificationStatus()
        }

        updateNotificationStatus()


        val deletebtn = findViewById<Button>(R.id.deleteid)
        deletebtn.setOnClickListener {
            val intent = Intent(this, DeleteId::class.java)
            startActivity(intent)
        }


        val backbtn = findViewById<ImageView>(R.id.backbutton)
        backbtn.setOnClickListener {
            finish()
        }

        val changepw = findViewById<Button>(R.id.changepw)
        changepw.setOnClickListener {
            val intent = Intent(this, CheckPassword::class.java)
            startActivity(intent)
        }

        val version = findViewById<Button>(R.id.version)
        version.setOnClickListener {
            val intentPlayStore = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.airro.unada"))
            startActivity(intentPlayStore)
        }

        val currentversion = findViewById<Button>(R.id.currentversion)
        currentversion.text = "1.1"

        currentversion.setOnClickListener {
            val intentPlayStore = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.airro.unada"))
            startActivity(intentPlayStore)


        }
    }

    private fun updateNotificationStatus() {
        if (notificationsEnabled) {
            startService(Intent(this, MyFirebaseMessagingService::class.java))
        } else {
            stopService(Intent(this, MyFirebaseMessagingService::class.java))
        }
    }
}