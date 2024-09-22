package com.example.appquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editNome : EditText
    private lateinit var btnIniciar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editNome = findViewById(R.id.edit_nome)
        btnIniciar = findViewById(R.id.btn_iniciar)

        btnIniciar.setOnClickListener{

            val nome = editNome.text.toString()

            val intent = Intent(this,PerguntasActivity::class.java)

            intent.putExtra("nome_usuario",nome)

            startActivity(intent)

        }

    }
}