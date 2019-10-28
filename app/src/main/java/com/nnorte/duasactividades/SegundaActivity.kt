package com.nnorte.duasactividades

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        var intente = intent
        var mensagem = intente.getStringExtra(MainActivity.MENSAGEM_EXTRA)
        textView_mensagem.text = mensagem
    }

    fun retornarRespostas(view: View){

        val resposta = editText_mensagem_resposta.text.toString()
        var intenteResposta = Intent().apply {
            this.putExtra(RESPOSTA_EXTRA,resposta)
            setResult(Activity.RESULT_OK,this)
            finish()
        }
    }

    companion object {
        const val RESPOSTA_EXTRA : String = "com.nnorte.duasactividades.extra.RESPOSTA"
    }
}
