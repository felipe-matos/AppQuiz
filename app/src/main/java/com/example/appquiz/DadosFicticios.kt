package com.example.appquiz

class DadosFicticios {

    companion object{
        //Lista de perguntas
        /*
            Qual foi a duração do primeiro vídeo do Youtube
        Respostas: 3 minutos, 1 minuto, 18 segundos (RESPOSTA CERTA: 18 segundos)

        Em média, quantas pesquisas totalmente novas são feitas no Google todo dia?
        respostas: 450 milhões, 1 Bilhão, (RESPOSTA CERTA: 450 milhões)

        Qual foi a primeira rede social da história da internet?
        Respostas: MySpace,ClassMate, Orkut (RESPOSTA CERTA: ClassMate)

        Quantos Bits cabem em um Byte
        Respostas: 1 bit,4 bits, 8 bits (RESPOSTA CERTA: 8 bits)
         */

        fun recuperarListaPerguntas(): Array<Pergunta>{

            val pergunta1 = Pergunta(
                1,"Qual foi a duração do primeiro vídeo do Youtube?"," 3 minutos",
                "1 minuto","18 segundos", repostaCerta = 3
            )

            val pergunta2 = Pergunta(
                1,"Em média, quantas pesquisas totalmente novas são feitas no Google todo dia?",
                " 450 milhões", "1 Bilhão","10 bilhões", repostaCerta = 1
            )

            val pergunta3 = Pergunta(
                1,"Quantos Bits cabem em um Byte?",
                " MySpace", "ClassMate","Orkut", repostaCerta = 2
            )
            val pergunta4 = Pergunta(
                1,"Qual foi a primeira rede social da história da internet?",
                " 1 bit", "4 bits","8 bits", repostaCerta = 3
            )

            return arrayOf(
                pergunta1,pergunta2,pergunta3,pergunta4
            )


        }

    }

}