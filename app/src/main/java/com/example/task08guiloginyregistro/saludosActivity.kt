package com.example.task08guiloginyregistro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class saludosActivity : AppCompatActivity(){

    private lateinit var receivedEmail: String
    private lateinit var btnVolver: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludos)

        btnVolver = findViewById(R.id.botonVolver)

        val intent = intent
        if (intent.hasExtra("email")) {
            receivedEmail = intent.getStringExtra("email")!!


            // Acceder al TextView y establecer el texto
            val textView = findViewById<TextView>(R.id.texto)
            textView.text = "Hola, $receivedEmail"


        } else {

        }
        btnVolver.setOnClickListener{
            val intent = Intent(this@saludosActivity, singInActivity::class.java)
            startActivity(intent)

        }



    }
}