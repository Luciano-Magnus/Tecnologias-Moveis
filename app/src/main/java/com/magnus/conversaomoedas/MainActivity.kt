package com.magnus.conversaomoedas

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    lateinit var conversao: EditText
    var real: Float? = null
    var dolar: Float? = null
    var euro: Float? = null
    var bitcoin: Float?= null
    var i: Int? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getSupportActionBar()?.hide()
        this.conversao = findViewById(R.id.nome)
        val spinner = findViewById<Spinner>(R.id.dropDown)
        converter.setOnClickListener {
            val dec = DecimalFormat("0.00")
        val btc = DecimalFormat("0.000000")
            if (i==0) {
                /*dolar = 5.03.toFloat() * conversao.toString().toFloat()*/
                val srtconversao = conversao.text
                dolar=  srtconversao.toString().toFloat()/ 5.03.toFloat()
                euro=  srtconversao.toString().toFloat() / 5.42.toFloat()
                bitcoin=  srtconversao.toString().toFloat() / 29745.12.toFloat()
                resultado.text = "Dolar= US$ ${dec.format(dolar)}\n" +
                        "Euro= € ${dec.format(euro)}\n" +
                    "Bitcoin= BTC ${btc.format(bitcoin)}"
            }

            if (i==1) {
                /*dolar = 5.03.toFloat() * conversao.toString().toFloat()*/
                val srtconversao = conversao.text
                real= srtconversao.toString().toFloat() * 5.42.toFloat()
                dolar=  srtconversao.toString().toFloat() * 1.08.toFloat()
                bitcoin=  srtconversao.toString().toFloat() / 5841.65.toFloat()
                resultado.text = "Real= R$ ${dec.format(real)}\n" +
                        "Dolar= US$ ${dec.format(dolar)}\n" +
                        "Bitcoin= BTC ${btc.format(bitcoin)}"
            }

            if (i==2) {
                /*dolar = 5.03.toFloat() * conversao.toString().toFloat()*/
                val srtconversao = conversao.text
                real= srtconversao.toString().toFloat() * 5.03.toFloat()
                euro=  srtconversao.toString().toFloat() / 1.08.toFloat()
                bitcoin=  srtconversao.toString().toFloat() / 6249.32.toFloat()
                resultado.text = "Real= R$ ${dec.format(real)}\n" +
                        "Euro= € ${dec.format(euro)}\n" +
                        "Bitcoin= BTC ${btc.format(bitcoin)}"
            }

        }
        var listaDeItens = arrayOf("Real", "Euro", "Dolar")
        spinner!!.setOnItemSelectedListener(this)
        val escolha = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaDeItens)
        escolha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(escolha)
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, posicao: Int, id: Long) {
        if (posicao == 0) {
            i = 0
            moedas.text="Real"
        }
        if (posicao == 1) {
            i = 1
            moedas.text="Euro"

        }
        if (posicao == 2) {
            i = 2
            moedas.text="Dolar"
        }
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }

    override fun onClick(v: View?) {
    }
}

