package com.bootcamp.ejerciciodiezkotlin.view



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme


import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel




import com.bootcamp.ejerciciodiezkotlin.components.MultiButtonSegmented
import com.bootcamp.ejerciciodiezkotlin.components.Space
import com.bootcamp.ejerciciodiezkotlin.viewmodel.CalcularViewModel





@Composable
fun HomeView(viewModel: CalcularViewModel = viewModel()) {
  val state = viewModel.state.value






    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )



        MultiButtonSegmented(
            options = listOf("Hombre", "Mujer"),
            selectedOption = state.genero,
            onOptionSelected = { viewModel.onGeneroSelected(it) }
        )

        Space()

        OutlinedTextField(
            value = state.edad,
            onValueChange = { viewModel.onEdadChanged(it) },
            label = {Text("Edad (años)")}
        )


        Space()

        OutlinedTextField(
            value = state.peso,
            onValueChange = { viewModel.onPesoChanged(it) },
            label = {Text("Peso (Kg)")}
        )

        Space()


        OutlinedTextField(
            value = state.altura,
            onValueChange = { viewModel.onAlturaChanged(it)},
            label = {Text("Altura (cm)")}
        )

        Space()



        Button(
            onClick = {
                viewModel.calcularIMC()
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Text(text = "Calcular")
        }


        Space()

        Text(text = "IMC: ${state.resultadoIMC}",
            style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(36.dp),
        fontSize = 50.sp
        )

    }

}



