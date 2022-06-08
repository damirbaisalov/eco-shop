package com.example.eco_shop.sign_in

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.eco_shop.MainActivity
import com.example.eco_shop.R
import com.example.eco_shop.sign_up.RegistrationActivity

const val USER_TOKEN = "user_token"
const val APPLICATION_SHARED_PREFERENCES = "application"

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var loginButton: Button
    private lateinit var continueButton: Button

    private lateinit var signUpTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        continueButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }


    private fun init() {
        loginButton = findViewById(R.id.activity_login_enter_button)
        continueButton = findViewById(R.id.activity_login_continue_button)
        emailEditText = findViewById(R.id.activity_login_mail_edit_text)
        passwordEditText = findViewById(R.id.activity_login_password_edit_text)
        signUpTextView = findViewById(R.id.activity_login_sign_up_text_view)
    }

    private fun saveUserToken(token: String){
        val sharedPreferences: SharedPreferences = getSharedPreferences(
            APPLICATION_SHARED_PREFERENCES,
            MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
}