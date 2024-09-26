package com.example.churraspar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtHomens: EditText
    private lateinit var edtMulheres: EditText
    private lateinit var edtCriancas: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: Button
    private lateinit var tvResultados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtHomens = findViewById(R.id.edtHomens)
        edtMulheres = findViewById(R.id.edtMulheres)
        edtCriancas = findViewById(R.id.edtCriancas)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)
        tvResultados = findViewById(R.id.tvResultados)

        btnCalcular.setOnClickListener { calcular() }
        btnLimpar.setOnClickListener { limpar() }
    }

    @SuppressLint("SetTextI18n")
    private fun calcular() {
        val homens = edtHomens.text.toString().toIntOrNull() ?: 0
        val mulheres = edtMulheres.text.toString().toIntOrNull() ?: 0
        val criancas = edtCriancas.text.toString().toIntOrNull() ?: 0

        val carneHomens = homens * 400
        val carneMulheres = mulheres * 300
        val carneCriancas = criancas * 200
        val totalCarne = carneHomens + carneMulheres + carneCriancas
        val carneComMargem = totalCarne + (totalCarne * 0.10).toInt()

        val aperitivosHomens = homens * 150
        val aperitivosMulheres = mulheres * 100
        val aperitivosCriancas = criancas * 50
        val totalAperitivos = aperitivosHomens + aperitivosMulheres + aperitivosCriancas
        val aperitivosComMargem = totalAperitivos + (totalAperitivos * 0.10).toInt()

        val bebidaHomens = homens * 4
        val bebidaMulheres = mulheres * 2
        val totalBebida = bebidaHomens + bebidaMulheres
        val bebidaComMargem = totalBebida + (totalBebida * 0.10).toInt()

        val agua = (mulheres + criancas) * 2
        val refrigerante = (mulheres + criancas) * 1.5
        val aguaComMargem = agua + (agua * 0.10).toInt()
        val refrigeranteComMargem = refrigerante + (refrigerante * 0.10).toInt()

        tvResultados.text = """
            Total de Carne: ${carneComMargem}g
            Total de Aperitivos: ${aperitivosComMargem}g
            Total de Bebida Alcoólica: ${bebidaComMargem}L
            Total de Água: ${aguaComMargem}L
            Total de Refrigerante: ${refrigeranteComMargem}L
        """.trimIndent()
    }

    @SuppressLint("SetTextI18n")
    private fun limpar() {
        edtHomens.text.clear()
        edtMulheres.text.clear()
        edtCriancas.text.clear()
        tvResultados.text = "Resultados aparecerão aqui"
    }
}
