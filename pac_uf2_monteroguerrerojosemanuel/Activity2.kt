package com.example.pac_uf2_monteroguerrerojosemanuel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ContentValues
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        Toast.makeText(this, "Usted se encuentra en la Activity2", Toast.LENGTH_SHORT).show()

        val edtNombreProducto = findViewById<EditText>(R.id.edtNombreProducto)
        val editTextPrecio = findViewById<EditText>(R.id.editTextPrecio)
        val edtCantidad = findViewById<EditText>(R.id.edtCantidad)
        val btnCrearTabla = findViewById<Button>(R.id.btnCrearTabla)
        val btnInsertarDatos = findViewById<Button>(R.id.btnInsertarDatos)
        val btnConsultarDatosCantidad = findViewById<Button>(R.id.btnConsultarDatosCantidad)
        val btnConsultarDatosPrecio = findViewById<Button>(R.id.btnConsultarDatosPrecio)
        val btnBackAct1 = findViewById<Button>(R.id.btnBackAct1)

        btnInsertarDatos.setOnClickListener {
            val admin = ManejadorSQLite(this,"stock", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", edtNombreProducto.getText().toString())
            registro.put("cantidad", edtCantidad.getText().toString())
            registro.put("precio", editTextPrecio.getText().toString())
            bd.insert("stock", null, registro)
            bd.close()
            edtNombreProducto.setText("")
            edtCantidad.setText("")
            editTextPrecio.setText("")
            Toast.makeText(this, "Datos insertados correctamente",  Toast.LENGTH_SHORT).show()
            bd.close()
        }
        btnCrearTabla.setOnClickListener(){
            val admin = ManejadorSQLite(this, "stock", null, 1)
            val bd = admin.writableDatabase
            val sql = bd.rawQuery("CREATE TABLE IF NOT EXISTS stock (\n" +
                    "            nombre_producto TEXT PRIMARY KEY,\n" +
                    "            cantidad INTEGER NOT NULL,\n" +
                    "            precio DOUBLE NOT NULL)",null)
            Toast.makeText(this, "La tabla se ha creado correctamente",  Toast.LENGTH_SHORT).show()
            bd.close()
        }
        btnConsultarDatosCantidad.setOnClickListener {
            val admin = ManejadorSQLite(this, "stock", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,precio from stock where cantidad=${edtCantidad.text.toString()}", null)
            if (fila.moveToFirst()) {
                edtCantidad.setText(fila.getString(0))
                editTextPrecio.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo por esa cantidad",  Toast.LENGTH_SHORT).show()
            bd.close()
        }
        btnConsultarDatosPrecio.setOnClickListener {
            val admin = ManejadorSQLite(this, "stock", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,cantidad from stock where precio=${editTextPrecio.text.toString()}", null)
            if (fila.moveToFirst()) {
                edtNombreProducto.setText(fila.getString(0))
                editTextPrecio.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo por ese precio",  Toast.LENGTH_SHORT).show()
            bd.close()

        btnBackAct1.setOnClickListener(){
            val intent = Intent(this,MainActivity :: class.java)
            startActivity(intent)
        }
    }
}
}