package com.alquran.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alquran.R

class LoginActivity : AppCompatActivity() {
    private var etUsernameLogin: EditText? = null
    private var etPasswdLogin: EditText? = null
    private var btnSignUpLogin: Button? = null
    private var btnSignInLogin: Button? = null
    var username: String? = null
    var password: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        login()
        register()
    }

    private fun initView() {
        etUsernameLogin = findViewById<EditText>(R.id.etUsernameLogin)
        etPasswdLogin = findViewById<EditText>(R.id.etPasswdLogin)
        btnSignInLogin = findViewById<Button>(R.id.btnSignInLogin)
        btnSignUpLogin = findViewById<Button>(R.id.btnSignUpLogin)
    }

    private fun register() {
        btnSignUpLogin!!.setOnClickListener { V: View? ->
            val reg = Intent(this, RegisterActivity::class.java)
            startActivity(reg)
            finish()
        }
    }

    private fun validation(): Boolean {
        username = etUsernameLogin!!.text.toString()
        password = etPasswdLogin!!.text.toString()
        if (username!!.isEmpty()) {
            Toast.makeText(this, "Isikan username", Toast.LENGTH_SHORT).show()
            Log.e("Validation", "false")
            return false
        }
        if (password!!.isEmpty()) {
            Toast.makeText(this, "Isikan Password", Toast.LENGTH_SHORT).show()
            Log.e("Validation", "false")
            return false
        }
        Log.e("Validation", "true")
        return true
    }

    private fun login() {
        btnSignInLogin!!.setOnClickListener { v: View? -> actLogin() }
    }

    private fun actLogin() {
        if (validation()) {
            if (loginData()) {
                Log.e("actLogin", "true")
                val main = Intent(this, MainActivity::class.java)
                startActivity(main)
                finish()
            } else {
                Log.e("actLogin", "false")
                Toast.makeText(this, "Login gagal", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loginData(): Boolean {
        username = "syahrul"
        return if (password == "msms") {
            Log.e("loginData", "true")
            true
        } else {
            Log.e("loginData", "false")
            false
        }
    }
}