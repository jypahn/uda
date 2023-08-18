package com.airro.unada


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.airro.unada.Mypage.SettingFragment
import com.airro.unada.Product.FavoriteListFragment
import com.airro.unada.Product.ListFragment
import com.airro.unada.Product.Write
import com.airro.unada.chat.ChatListFragment
import com.airro.unada.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var backKeyPressedTime : Long = 0

    private lateinit var binding: ActivityMainBinding
    private val chatFragment = ChatListFragment()
    private val mypageFragment = SettingFragment()
    private val favoriteFragment = FavoriteListFragment()

    private val listFragment = ListFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentUser = Firebase.auth.currentUser ?: ""

        if(currentUser == null || currentUser == "") {
            // 로그인이 안되어있음
            startActivity(Intent(this, login::class.java))
            finish()
        }

        askNotificationPermission()

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home ->{
                    replaceFragment(listFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.write ->{
                    return@setOnItemSelectedListener true
                }
                R.id.chatlist -> {
                    replaceFragment(chatFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.favoritelist ->{
                    replaceFragment(favoriteFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.mypage -> {
                    replaceFragment(mypageFragment)
                    return@setOnItemSelectedListener true
                }
                else ->{
                    return@setOnItemSelectedListener false
                }
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.home


        binding.bottomNavigationView.menu.findItem(R.id.write)?.let { writeItem ->
            writeItem.setOnMenuItemClickListener {
                startActivity(Intent(this, Write::class.java))
                true
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.frameLayout, fragment)
                commit()
            }

    }


    override fun onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2500) {
            Toast.makeText(this, "버튼을 한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
            backKeyPressedTime = System.currentTimeMillis() // 현재 시간으로 업데이트
        } else {
            finish()
        }
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
        } else {

        }
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {

                showPermissionRationalDialog()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun showPermissionRationalDialog() {
        AlertDialog.Builder(this)
            .setMessage("알림 권한이 없으면 알림을 받을 수 없습니다")
            .setPositiveButton("권한 허용") { _, _ ->
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }.setNegativeButton("취소"){ dialogInterface, _ -> dialogInterface.cancel()}
            .show()
    }

}
