package com.alquran.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.alquran.R

class SplashActivity : AppCompatActivity() {
    companion object {
        private const val SPLASH_TIME_OUT = 2000
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler();
    }

    private fun handler() {
        Handler().postDelayed({
            if (initPreference()) {
                val main = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(main)
                finish()
            } else {
                val i = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(i)
                finish()
            }
        }, SPLASH_TIME_OUT.toLong());
    }

    private fun initPreference(): Boolean {
        val preferences = getSharedPreferences("LoginPreference", MODE_PRIVATE)
        val username = preferences.getString("username", "")
        return username!!.isNotEmpty()
    }
}