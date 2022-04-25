package com.example.eco_shop.sign_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.eco_shop.MainActivity
import com.example.eco_shop.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: Button
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        continueButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }


    private fun init() {
        loginButton = findViewById(R.id.activity_login_enter_button)
        continueButton = findViewById(R.id.activity_login_continue_button)
        emailEditText = findViewById(R.id.activity_login_mail_edit_text)
        passwordEditText = findViewById(R.id.activity_login_password_edit_text)
    }

}