package com.example.alcoolougasolinafour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){
        /*para recuperar um componente de tela não será necessário usar o findViewById - plugin para ser usado no kotlin onde não precisa editar o código com
        findViewById igual a este código:  val precoAlcool = findViewById(R.id.edit_preco_alcool) as EditText */
        //recupera valores digitados
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            text_resultado.setText("  Álcool!")
            text_resultado.setText("Preencha os campos primeiro!")
        }
//        calcularMelhorPreco(precoAlcool, precoGasolina) foi o erro bonita
    }

    fun validarCampos (precoAlcool: String, precoGasolina: String) : Boolean{
        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularMelhorPreco (precoAlcool: String, precoGasolina: String){
        //converter valores string para numeros
        val valorAcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /* faz cálculo (precoalcool / precoGasolina)
        se o resultado >= 0.7 melhor utilizar gasolina
        senão melhor utilizar alcool
        */

        val resultadoPreco = valorAcool / valorGasolina
        if(resultadoPreco >= 0.7){
            text_resultado.setText("Melhor utilizar Gasolina!")
        } else {
            text_resultado.setText("Melhor utilizar Álcool!")
        }
    }
}