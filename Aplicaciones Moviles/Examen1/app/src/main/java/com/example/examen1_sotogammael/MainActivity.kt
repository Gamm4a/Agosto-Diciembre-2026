package com.example.examen1_sotogammael

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTuNombre= findViewById<EditText>(R.id.edit_nombre)
        val editCrush = findViewById<EditText>(R.id.edit_crush)

        val btnResultado = findViewById<Button>(R.id.btn_calcular)
        btnResultado.setOnClickListener {
            val nombre = editTuNombre.text.toString()
            val crush = editCrush.text.toString()

            if (nombre.isNotEmpty() && crush.isNotEmpty()) {
                val totalTamano: Int = nombre.length + crush.length
                val buscar = listOf('a', 'e', 'i', 'o', 'u', 'n', 's', 'r')

                val totalNombre: Int = nombre.lowercase().count { it in buscar }
                val totalCrush: Int = crush.lowercase().count { it in buscar }

                val totalResultado: Int = totalCrush + totalNombre
                val resultado: Int = (totalResultado * 100) / totalTamano

                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("resultado", resultado)
                startActivity(intent)
            }
        }









    }
}