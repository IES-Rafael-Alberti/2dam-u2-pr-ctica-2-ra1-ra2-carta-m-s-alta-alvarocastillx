package com.acasloa946.cartamsalta.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.acasloa946.cartamsalta.Baraja
import com.acasloa946.cartamsalta.Carta
import com.acasloa946.cartamsalta.R
import kotlin.random.Random
class UIControl {

    val listaDeResources = mutableListOf<Int>(
        R.drawable.as1,
        R.drawable.as2,
        R.drawable.as3,
        R.drawable.as4,
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
        R.drawable.c25,
        R.drawable.c26,
        R.drawable.c28,
        R.drawable.c29,
        R.drawable.c30,
        R.drawable.c31,
        R.drawable.c32,
        R.drawable.c33,
        R.drawable.c34,
        R.drawable.c35,
        R.drawable.c36,
        R.drawable.c37,
        R.drawable.c38,
        R.drawable.c39,
        R.drawable.c41,
        R.drawable.c42,
        R.drawable.c43,
        R.drawable.c44,
        R.drawable.c45,
        R.drawable.c46,
        R.drawable.c47,
        R.drawable.c48,
        R.drawable.c49,
        R.drawable.c50,
        R.drawable.c51,
        R.drawable.c52,


        )

    var imagenID : Int = R.drawable.facedown



    @Composable
    fun Inicio() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(0xfffffffe)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Crea la baraja el iniciarse el programa
            Baraja.crearBaraja()
            Baraja.barajar()
            CrearImagen()
            Row (
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Botones()
            }

        }
    }

    @Composable
    fun CrearImagen() {
        Image(
            painter = painterResource(id = imagenID),
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
        )

    }
    @Composable
    fun Botones() {
        Button(onClick = {
            val cartaNueva = Baraja.dameCarta()
            imagenID = cartaNueva.IdDrawable
        },
            modifier = Modifier.padding(end = 5.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Dame carta",
                color = Color.Black)
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Reiniciar",
                color = Color.Black)
        }
    }
}