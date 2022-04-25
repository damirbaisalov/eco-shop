package com.example.eco_shop.sign_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.eco_shop.MainActivity
import com.example.eco_shop.R
import com.example.eco_shop.sign_in.LoginActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()

        signUpButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        signInTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun init() {
        signUpButton = findViewById(R.id.activity_registration_sign_up_button)
        signInTextView = findViewById(R.id.activity_registration_sign_in_text_view)
    }
}