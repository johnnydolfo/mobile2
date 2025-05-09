package com.example.ex2

import android.R.attr.text
import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val generos = listOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSexo.adapter = adapter

        binding.botao.setOnClickListener {
            val idadeTexto = binding.textoidade.text.toString()
            val generoSelecionado = binding.spinnerSexo.selectedItem.toString()

            if (idadeTexto.isNotEmpty()) {
                val idade = idadeTexto.toInt()
                val resultado = when (generoSelecionado) {
                    "Masculino" -> 65 - idade
                    "Feminino" -> 62 - idade
                    else -> 0
                }

                val mensagem = if (resultado <= 0) {
                    "Você já pode fazer sua aposentadoria."
                } else {
                    "Restam $resultado anos até que você possa fazer sua aposentadoria."
                }

                binding.tvResultado.text = mensagem
            } else {
                binding.tvResultado.text = "Por favor, insira sua idade."
            }
        }
    }
}