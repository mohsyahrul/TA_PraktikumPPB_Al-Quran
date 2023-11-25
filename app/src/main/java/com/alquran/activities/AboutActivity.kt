package com.alquran.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alquran.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setInitLayout()

        supportActionBar?.title = "Tentang Aplikasi"

        tvAboutTitle.text = "Tentang Aplikasi Al-Quran"
        tvAboutDescription.text = "Aplikasi Al-Quran adalah sebuah aplikasi yang bertujuan untuk memberikan kemudahan dalam membaca dan memahami Al-Quran. Aplikasi ini dilengkapi dengan fitur-fitur seperti:\n\n - Menampilkan daftar surah dan ayat-ayat Al-Quran.\n - Informasi mengenai setiap surah.\n - Pencarian ayat atau surah.\n - Tafsir Al-Quran.\n\nAplikasi ini dibuat dengan tujuan membantu pengguna dalam menjalankan ibadah dan meningkatkan pemahaman terhadap Al-Quran.\n"
        tvAboutContact.text = "Kontak Kami\n - Email: msyahrulmaajids@gmail.com\n - Whatsapp: 085329983009\n\nTerima Kasih\nWassalamu'alaikum Warohmatullohi Wabarokatuh"
    }

    private fun setInitLayout() {
        layoutHistory.setOnClickListener {
            startActivity(
                Intent(
                    this@AboutActivity,
                    HistoryActivity::class.java
                )
            )
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }

        layoutMenu.setOnClickListener {
            startActivity(
                Intent(
                    this@AboutActivity,
                    MainActivity::class.java
                )
            )
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}