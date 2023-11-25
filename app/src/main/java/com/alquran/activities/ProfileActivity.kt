package com.alquran.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alquran.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Set profile data
        ivProfilePicture.setImageResource(R.drawable.ic_quran)
        tvName.text = "Moh. Syahrul Maajid Saputra"
        tvNIM.text = "21120121140127"
        tvAddress.text = "Semarang"
        tvPhoneNumber.text = "085329983009"

        // Setup Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            // Handle back arrow click
            onBackPressed()
        }
    }
}