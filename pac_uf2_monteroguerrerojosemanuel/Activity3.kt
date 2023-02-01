package com.example.pac_uf2_monteroguerrerojosemanuel

import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi

class Activity3 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_3)

    val botonCamara  = findViewById <Button>(R.id.Camara)
    val btnVueltaActivity1 : Button= findViewById(R.id.btnVueltaActivity1)

    btnVueltaActivity1.setOnClickListener{
        val intent = Intent(this,MainActivity :: class.java)
        startActivity(intent)
    }

    //Evento al presionar el botón
    botonCamara.setOnClickListener {
        startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }
}

//Evento que procesa el resultado de la cámara y envía la vista previa de la foto al ImageView
private val startForResult =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imageView8)
            imageView.setImageBitmap(imageBitmap)
        }
    }
}