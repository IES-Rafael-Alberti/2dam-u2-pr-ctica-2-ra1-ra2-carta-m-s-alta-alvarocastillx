package com.acasloa946.cartamsalta.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acasloa946.cartamsalta.R
import kotlin.random.Random

@Composable
fun Inicio() {
    Column(
       modifier = Modifier
           .fillMaxSize()
           .background(Color(0xfffffffe)
           ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val generarNumero = Random.nextInt(1,12)

        CrearImagen(generarNumero)
    }
}
@Composable
fun CrearImagen(IndexImage:Int) {
    val listaDeResources = mutableListOf<Int>(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13,
        R.drawable.c14,
        R.drawable.c15,
        R.drawable.c16,
        R.drawable.c17,
        R.drawable.c18,
        R.drawable.c19,
        R.drawable.c20,
        R.drawable.c21,
        R.drawable.c22,
        R.drawable.c23,
        R.drawable.c24,


    )
    Image(painter = painterResource(
        id = listaDeResources[IndexImage]),
        contentDescription = null,
        modifier = Modifier
            .size(350.dp))

}