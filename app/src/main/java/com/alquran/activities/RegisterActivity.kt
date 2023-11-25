package com.alquran.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.alquran.R

class RegisterActivity : AppCompatActivity() {
    private var etUsernameRegister: EditText? = null
    private var etPasswordRegister: EditText? = null
    private var btRegister: Button? = null
    private var btnBack: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        back()
    }

    private fun initView() {
        etUsernameRegister = findViewById<EditText>(R.id.etUsernameRegister)
        etPasswordRegister = findViewById<EditText>(R.id.etPasswordRegister)
        btRegister = findViewById<Button>(R.id.btRegister)
        btnBack = findViewById<Button>(R.id.btBack)
    }

    private fun back() {
        btnBack!!.setOnClickListener { V: View? ->
            val back = Intent(this, LoginActivity::class.java)
            startActivity(back)
            finish()
        }
    }
}