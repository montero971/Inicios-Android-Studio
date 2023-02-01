package com.example.pac_uf2_monteroguerrerojosemanuel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val botonVolverActivity1 : Button= findViewById(R.id.botonVolverActivity1)

        botonVolverActivity1.setOnClickListener{
            val intent = Intent(this,MainActivity :: class.java)
            startActivity(intent)
        }
    }
}