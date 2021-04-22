package com.capgemini.androidtesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tv: TextView
    lateinit var nameE : EditText
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameE = findViewById(R.id.nameE)
        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.button)
    }

    fun btnClick(view: View) {
        val name = nameE.text.toString()

//        while (true){
//            Log.d("MainActivity", "Infinite loop running")
//        }

        if (name.isNotEmpty()) {

//            tv.text = "Hello $name"
//            nameE.setText("")
//            btn.isEnabled = false
//            btn.text = "Done"
            val i = Intent(this, DisplayActivity::class.java)
            i.putExtra("name", name)
            startActivity(i)
        }
        else {
            Toast.makeText(this, "Pls enter name",
                    Toast.LENGTH_LONG).show()
        }

    }
}