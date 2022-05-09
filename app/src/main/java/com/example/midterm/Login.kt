package com.example.midterm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class Login : AppCompatActivity(){
        private lateinit var btnLogin: ImageView
        private lateinit var enterName: TextView
        private lateinit var arrow: ImageView
        lateinit var sharedPreferences: SharedPreferences

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            supportActionBar?.hide()
            sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

            enterName = findViewById(R.id.enterName)

            btnLogin.setOnClickListener{

                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)

            }

            arrow.setOnClickListener{

                val name = enterName.text.toString()

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("NAME", name)
                editor.apply()
                Toast.makeText(this, "information saved", Toast.LENGTH_LONG).show()

                val intent = Intent(this@Login, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
