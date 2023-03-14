package com.example.hotel.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.hotel.MainActivity
import com.example.hotel.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(intent)
        }, 5000)
    }
}