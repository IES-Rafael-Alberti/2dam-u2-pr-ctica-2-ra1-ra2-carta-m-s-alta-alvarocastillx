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
import com.acasloa946.cartamsalta.Carta
import com.acasloa946.cartamsalta.R

var cartaNueva : Carta = Carta()

/**
 * Clase UIControl -> se encarga de controlar la interfaz
 */
class UIControl {
    //lista de todas las fotos ordenadas según necesito para crear baraja (primero ases y después cada numero de todos los palos)
    val listaDeResources = mutableListOf(
        R.drawable.as1,
        R.drawable.as2,
        R.drawable.as3,
        R.drawable.as4,
        R.drawable.c2,
        R.drawable.c15,
        R.drawable.c28,
        R.drawable.c41,
        R.drawable.c3,
        R.drawable.c16,
        R.drawable.c29,
        R.drawable.c42,
        R.drawable.c4,
        R.drawable.c17,
        R.drawable.c30,
        R.drawable.c43,
        R.drawable.c5,
        R.drawable.c18,
        R.drawable.c31,
        R.drawable.c44,
        R.drawable.c6,
        R.drawable.c19,
        R.drawable.c32,
        R.drawable.c45,
        R.drawable.c7,
        R.drawable.c20,
        R.drawable.c33,
        R.drawable.c46,
        R.drawable.c8,
        R.drawable.c21,
        R.drawable.c34,
        R.drawable.c47,
        R.drawable.c9,
        R.drawable.c22,
        R.drawable.c35,
        R.drawable.c48,
        R.drawable.c10,
        R.drawable.c23,
        R.drawable.c36,
        R.drawable.c49,
        R.drawable.c11,
        R.drawable.c24,
        R.drawable.c37,
        R.drawable.c50,
        R.drawable.c12,
        R.drawable.c25,
        R.drawable.c38,
        R.drawable.c51,
        R.drawable.c13,
        R.drawable.c26,
        R.drawable.c39,
        R.drawable.c52,
        )


    /**
     * Función que se ejecuta cuando se inicializa la aplicación.
     */
    @Composable
    fun Inicio() {
        val context = LocalContext.current
        var imagenID by rememberSaveable { mutableStateOf(R.drawable.facedown) }


        //Columna principal
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
            //Imagen de la baraja con el texto de las cartas que quedan si la imagen que se esta mostrando no es la carta boca abajo.
            if (imagenID != R.drawable.facedown) {
                ImagenBaraja(Baraja.listaCartas.size)
            }
            //Inicia función crearImagen (Imagen de la carta)
            CrearImagen(imagenID,cartaNueva)
            //Row para los botones
            Row(
                modifier = Modifier.padding(top = 30.dp)
            ) {
                //Funcion para los botones
                Botones(
                    onClickDameCarta = {
                        // si la imagen que se esta mostrando es la carta boca abajo y se le da al botón damecarta se cambia la imagenID por la de la última carta
                        if (imagenID == R.drawable.facedown) {
                            imagenID = Baraja.listaCartas.last().IdDrawable
                        }
                        //si es la última carta y se pulsa el botón se muestra un toast
                        else if (Baraja.ultimaCarta) {
                            Baraja.ultimaCarta = false
                            Toast.makeText(context, "Esta es la última carta", Toast.LENGTH_SHORT)
                                .show()
                        }
                        //si no se esta mostrando la carta boca abajo ni es la última carta se accede al método dameCarta y se cambia el imagenID.
                        else {
                            cartaNueva = Baraja.dameCarta()
                            imagenID = cartaNueva.IdDrawable
                        }
                    },
                    onClickReiniciar = {
                        //borra baraja
                        Baraja.borrarBaraja()
                        //crea baraja
                        Baraja.crearBaraja()
                        //baraja
                        Baraja.barajar()
                        //se cambia el imagenIDÇ
                        imagenID = R.drawable.facedown
                    }
                )
            }

        }
    }

    /**
     * Función para mostrar una imagen de la baraja con un texto mostrando las cartas que quedan.
     * Solo se entra cuando la imagen que se está mostrando es la carta boca abajo.
     */
    @Composable
    fun ImagenBaraja(numb: Int) {
        Box(
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.facedown),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
            Text(
                text = "$numb",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.background(Color.Black)
            )
        }

    }

    /**
     * Función que crea la imagen de la carta
     * @param imagenID -> id de la imagen para representarla en el painterResource
     * @param Carta -> carta actual para el texto que muestra su nombre y palo
     */
    @Composable
    fun CrearImagen(imagenID: Int, Carta:Carta) {
        if (imagenID!=R.drawable.facedown) {
            Text(
                text = "${Carta.Nombre} de ${Carta.Palo}",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 24.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Image(
            painter = painterResource(id = imagenID),
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
        )
    }

}

/**
 * Función para dibujar los botones
 * @param onClickDameCarta -> función que se ejecuta cuando se le da al botón dameCarta
 * @param onClickReiniciar -> función que se ejecuta cuando se le da al botón reiniciar
 */
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
                cartaNueva = Baraja.listaCartas.last()
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



