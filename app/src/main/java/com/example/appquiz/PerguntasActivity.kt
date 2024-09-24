package com.example.appquiz

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PerguntasActivity : AppCompatActivity() {

    private lateinit var textNome : TextView
    private lateinit var textContadorPerguntas: TextView
    private lateinit var textPergunta: TextView

    private lateinit var radioGroupPerguntas: RadioGroup
    private lateinit var radioPergunta01: RadioButton
    private lateinit var radioPergunta02: RadioButton
    private lateinit var radioPergunta03: RadioButton

    private lateinit var btnConfirmar: Button

    private lateinit var listaPerguntas : Array<Pergunta>

    private var indicePerguntaAtual = 1

    private var totalRespostasCorretas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perguntas)

        inicializar()
        listaPerguntas = DadosFicticios.recuperarListaPerguntas()

        //Meus Códigos
        val bundle = intent.extras
        val nome = bundle?.getString("nome_usuario") ?: "Nome não identificado"

        //Dados mockados
        textNome.text = "Olá , $nome"

        exibirPerguntaAtual()
        btnConfirmar.setOnClickListener{

            if(validarRepostasPerguntasAtual()){ //Exibe a próxima

                verificarRespostaCerta()
                indicePerguntaAtual++

                //Verifico se já foi preenchido tudo
                val totalItensLista = listaPerguntas.size
                if(indicePerguntaAtual <= totalItensLista){

                    exibirPerguntaAtual()
                } else { //terminou as perguntas

                    val intent = Intent(this,DetalhesActivity::class.java)
                    intent.putExtra("total_respostas_corretas",totalRespostasCorretas)
                    startActivity(intent)
                    finish()
                }

                //textContadorPerguntas.text = "Contador : $indicePerguntaAtual"

            }

        }

    }

    private fun verificarRespostaCerta() {

        val pergunta  = listaPerguntas[indicePerguntaAtual -1]
        val respostaCerta = pergunta.repostaCerta

        var respostaSelecionada = if( radioPergunta01.isChecked){
             1
        } else if (radioPergunta02.isChecked){
             2
        }else if (radioPergunta03.isChecked){
             3
        }else {
            0
        }

        if(respostaSelecionada == respostaCerta){
            totalRespostasCorretas++
        }

        radioGroupPerguntas.clearCheck()

    }

    private fun validarRepostasPerguntasAtual() : Boolean {

        val resposta01 = radioPergunta01.isChecked
        val resposta02 = radioPergunta02.isChecked
        val resposta03 = radioPergunta03.isChecked

        if(resposta01 || resposta02 || resposta03){

            return true
        }

        Toast.makeText(this, "Preencha a reposta para avançar", Toast.LENGTH_SHORT).show()
        return false
        //textContadorPerguntas.text = "R01 : $resposta01 , R02: $resposta02 , R03 $resposta03"

    }

    private fun exibirPerguntaAtual() {

        val perguntaAtual = listaPerguntas[indicePerguntaAtual - 1 ]

        textPergunta.text = perguntaAtual.titulo
        radioPergunta01.text = perguntaAtual.resposta01
        radioPergunta02.text = perguntaAtual.resposta02
        radioPergunta03.text = perguntaAtual.resposta03

        val totalPerguntas = listaPerguntas.size
       // textContadorPerguntas.text = "$indicePerguntaAtual pergunta de $totalPerguntas"

        textContadorPerguntas.text = "total respostas: $totalRespostasCorretas indice: $indicePerguntaAtual"
    }

    private fun inicializar() {

        textNome = findViewById(R.id.text_nome)
        textContadorPerguntas = findViewById(R.id.text_contador_perguntas)
        textPergunta = findViewById(R.id.text_pergunta)

        radioGroupPerguntas = findViewById(R.id.radio_group_perguntas)
        radioPergunta01 = findViewById(R.id.radio_pergunta_01)
        radioPergunta02 = findViewById(R.id.radio_pergunta_02)
        radioPergunta03 = findViewById(R.id.radio_pergunta_03)

        btnConfirmar = findViewById(R.id.btn_Confirmar)


    }
}