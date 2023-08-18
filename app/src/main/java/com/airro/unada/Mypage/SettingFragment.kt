package com.airro.unada.Mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.airro.unada.R
import com.airro.unada.data.UserModel
import com.airro.unada.login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class SettingFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_setting, container, false)
        auth = FirebaseAuth.getInstance()

        val logoutbtn = rootView.findViewById<Button>(R.id.logout)
        logoutbtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(activity, login::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val profilename = rootView.findViewById<TextView>(R.id.username)
        val profileimage = rootView.findViewById<ImageView>(R.id.userImage)

        val currentUserId = Firebase.auth.currentUser?.uid ?: ""

        val userRef = Firebase.firestore.collection("profiles").document(currentUserId)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val profile = document.toObject<UserModel>()
                    profile?.let {
                        profilename.text = it.id

                        if (it.profileurl == null) {
                            profileimage.setImageResource(R.drawable.profile)
                        } else {
                            Glide.with(this)
                                .load(it.profileurl)
                                .into(profileimage)
                        }
                    }
                } else {
                }
            }
            .addOnFailureListener { exception ->
            }




        return rootView


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cahangeprofile = view.findViewById<Button>(R.id.infobutton)
        cahangeprofile.setOnClickListener{
            startActivity(Intent(requireActivity(), changeprofile::class.java))

        }


        val findmyarticlebtn = view.findViewById<Button>(R.id.findmyarticle)
        findmyarticlebtn.setOnClickListener {
            startActivity(Intent(requireContext(),MyList::class.java))
        }


        val inquirybtn = view.findViewById<TextView>(R.id.inquiry)

        inquirybtn.setOnClickListener {
            startActivity(Intent(requireContext(),inquiry::class.java))

        }

        val mySetting = view.findViewById<Button>(R.id.set)

        mySetting.setOnClickListener {
            startActivity(Intent(requireContext(),MySetting::class.java))

        }

    }



}
