package com.example.eco_shop.user_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.eco_shop.R

class UserPageActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)
        init()

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun init() {

        backButton = findViewById(R.id.activity_user_page_back_button_toolbar)

    }
}