package com.acasloa946.cartamsalta.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acasloa946.cartamsalta.Baraja
import com.acasloa946.cartamsalta.R

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


    @Composable
    fun Inicio() {
        val context = LocalContext.current
        var imagenID by rememberSaveable { mutableStateOf(R.drawable.facedown) }

        Column(
            Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.mat),
                    contentScale = ContentScale.FillHeight
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (imagenID!=R.drawable.facedown) {
                ImagenBaraja(Baraja.listaCartas.size)
            }
            CrearImagen(imagenID)
            Row(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                Botones(
                    onClickDameCarta = {
                        if (imagenID == R.drawable.facedown) {
                            imagenID = Baraja.listaCartas.last().IdDrawable
                        } else if (Baraja.ultimaCarta) {
                            Baraja.ultimaCarta = false
                            Toast.makeText(context, "Última carta", Toast.LENGTH_SHORT).show()
                        } else {
                            val cartaNueva = Baraja.dameCarta()
                            imagenID = cartaNueva.IdDrawable
                        }

                    },
                    onClickReiniciar = {
                        Baraja.borrarBaraja()
                        Baraja.crearBaraja()
                        Baraja.barajar()
                        imagenID = R.drawable.facedown
                    }
                )
            }

        }
    }

    @Composable
    fun ImagenBaraja(numb : Int) {
        Box (
        contentAlignment = Alignment.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.facedown),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
            Text(text = "${numb}",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.background(Color.Black)
            )
        }
    }

    @Composable
    fun CrearImagen(imagenID: Int) {
        if (imagenID == R.drawable.as1) {
            Image(
                painter = painterResource(id = imagenID),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
            )
        } else {
            Image(
                painter = painterResource(id = imagenID),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
            )
        }
    }

    @Composable
    fun Botones(
        onClickDameCarta: () -> Unit,
        onClickReiniciar: () -> Unit
    ) {
        Button(
            onClick = {
                if (Baraja.listaCartas.size == 1 || Baraja.listaCartas.isEmpty()) {
                    Baraja.crearBaraja()
                    Baraja.barajar()
                }
                onClickDameCarta()
            },
            modifier = Modifier.padding(end = 5.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(
                text = "Dame carta",
                color = Color.Black
            )
        }
        Button(
            onClick = { onClickReiniciar() },
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(
                text = "Reiniciar",
                color = Color.Black
            )
        }
    }
}