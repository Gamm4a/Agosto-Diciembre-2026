package com.example.examen1_sotogammael

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = intent.getIntExtra("resultado", 0)

        val txtResultado = findViewById<TextView>(R.id.txt_resultado)
        txtResultado.text = "$resultado%"

        val txtDescripcion = findViewById<TextView>(R.id.descripcion)


        val layaut= findViewById<ConstraintLayout>(R.id.main)


        if (resultado>70){
            layaut.setBackgroundColor(R.color.orange)
            txtDescripcion.text =getString(R.string.ROJO)
        }


        //----- el psh boton
        val btn_volver = findViewById<Button>(R.id.btn_regresar)

        btn_volver.setOnClickListener {
            finish()
        }






    }
}