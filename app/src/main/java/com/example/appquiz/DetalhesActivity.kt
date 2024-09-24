package com.example.appquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    private lateinit var textTotalRespostas : TextView
    private lateinit var btnReiniciar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)

        textTotalRespostas = findViewById(R.id.text_total_respostas)
        btnReiniciar = findViewById(R.id.btn_reiniciar)


        //Pegar as respostas certas
        val bundle = intent.extras
        val respostasCertas = bundle?.getInt("total_respostas_corretas") ?: 0

        textTotalRespostas.text = "Respostas corretas $respostasCertas"


        btnReiniciar.setOnClickListener{
            finish()
        }

    }
}