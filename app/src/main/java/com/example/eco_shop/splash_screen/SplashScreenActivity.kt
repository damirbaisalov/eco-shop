package com.example.eco_shop.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eco_shop.MainActivity
import com.example.eco_shop.R
import com.example.eco_shop.sign_in.LoginActivity

private const val SPLASH_SCREEN_DELAY = 2000
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(SPLASH_SCREEN_DELAY.toLong())
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}