package com.nnorte.duasactividades

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    companion object {
        const val MENSAGEM_EXTRA : String = "com.nnorte.duasactividades.extra.MENSAGEM"
        const val TEXT_REQUEST = 1
    }

    fun iniciarSegundaActividade(view: View){
        val mensagem = editText_enviar_mensagem.text.toString()
        var intente = Intent(this,SegundaActivity::class.java).apply {
            this.putExtra(MENSAGEM_EXTRA,mensagem)
        }

        if (intente.resolveActivity(packageManager) != null) startActivityForResult(intente,TEXT_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TEXT_REQUEST){
            if (resultCode == Activity.RESULT_OK){
                val resposta = data!!.getStringExtra(SegundaActivity.RESPOSTA_EXTRA)
                textView_cabecalho_resposta.visibility = View.VISIBLE

                textView_mensagem_resposta.text = resposta
                textView_mensagem_resposta.visibility = View.VISIBLE
            }
        }
    }
}
