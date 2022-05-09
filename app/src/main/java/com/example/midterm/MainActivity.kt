package com.example.midterm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var arrowLeft:ImageView
    private lateinit var yourName:TextView
    lateinit var preferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        arrowLeft = findViewById(R.id.arrowLeft)
        yourName = findViewById(R.id.yourName)

        val name = preferences.getString("NAME", "")
        yourName.text = name


        arrowLeft.setOnClickListener{
            val intent = Intent(this@MainActivity, Login::class.java)
            finish()
            startActivity(intent)
        }
    }
}