package com.example.pac_uf2_monteroguerrerojosemanuel

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonPlay : Button = findViewById(R.id.botonPlay)
        val botonPause : Button = findViewById(R.id.botonPause)
        val botonStop : Button = findViewById(R.id.botonStop)
        val botonActivity2 : Button = findViewById(R.id.botonActivity2)
        val botonActivity3 : Button = findViewById(R.id.botonActivity3)
        val botonActivity4 : Button = findViewById(R.id.botonActivity4)

        var mediaPlayer = MediaPlayer.create(this,R.raw.maro)

        botonPlay.setOnClickListener{
            mediaPlayer.start()
            Toast.makeText(this,"Reproduciendo!", Toast.LENGTH_LONG).show()
        }
        botonPause.setOnClickListener {
            mediaPlayer.pause()
            Toast.makeText(this, "Pausa!", Toast.LENGTH_LONG).show()
        }
        botonStop.setOnClickListener{
            mediaPlayer.stop()
            Toast.makeText(this,"Canción detenida", Toast.LENGTH_LONG).show()
            mediaPlayer = MediaPlayer.create(this,R.raw.maro)
        }
        botonActivity2.setOnClickListener{
            val intent = Intent(this,Activity2 :: class.java)
            startActivity(intent)
        }
        botonActivity3.setOnClickListener{
            val intent = Intent(this,Activity3 :: class.java)
            startActivity(intent)
        }
        botonActivity4.setOnClickListener{
            val intent = Intent(this,Activity4 :: class.java)
            startActivity(intent)
        }
    }
}