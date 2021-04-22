package com.capgemini.androidtesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    lateinit var dispT : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        dispT = findViewById(R.id.dispT)

        dispT.text = intent.getStringExtra("name")
    }
}