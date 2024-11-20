package com.bootcamp.ejerciciodiezkotlin.viewmodel

import androidx.lifecycle.ViewModel

import androidx.compose.runtime.mutableStateOf

import com.bootcamp.ejerciciodiezkotlin.state.IMCState


class CalcularViewModel: ViewModel() {

        var state = mutableStateOf(IMCState())
            private set

        fun onGeneroSelected(genero: String) {
            state.value = state.value.copy(genero = genero)
        }

        fun onEdadChanged(edad: String) {
            state.value = state.value.copy(edad = edad)
        }

        fun onPesoChanged(peso: String) {
            state.value = state.value.copy(peso = peso)
        }

        fun onAlturaChanged(altura: String) {
            state.value = state.value.copy(altura = altura)
        }

        fun calcularIMC() {
            val pesoNum = state.value.peso.toFloatOrNull()
            val alturaNum = state.value.altura.toFloatOrNull()?.div(100) // Convertimos cm a m

            val resultado = if (pesoNum != null && alturaNum != null && alturaNum > 0) {
                val imc = pesoNum / (alturaNum * alturaNum)
                "%.1f".format(imc) // Formatear a un decimal
            } else {
                "Error: Datos inválidos"
            }

            state.value = state.value.copy(resultadoIMC = resultado)
        }
    }


