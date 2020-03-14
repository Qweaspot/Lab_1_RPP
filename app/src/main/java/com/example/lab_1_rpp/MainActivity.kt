package com.example.lab_1_rpp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab_1_rpp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondActivity = Intent (this, SecondActivity::class.java)
        val handler = android.os.Handler()

        handler.postDelayed({}, 2000) //specify the number of milliseconds
        android.os.Handler().postDelayed({
            startActivity(secondActivity)
        }, 2000)
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }
}

