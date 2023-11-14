package com.acasloa946.cartamsalta

import android.widget.Toast
import com.acasloa946.cartamsalta.Screens.UIControl

class Baraja {

    companion object {
        lateinit var Carta : Carta
        var listaCartas = arrayListOf<Carta>()
        var objetoControl = UIControl()
        var ultimaCarta = false

        fun crearBaraja() {
            var contFotos = 4
            for (i in Naipes.values()) {
                for (j in Palos.values()) {
                    if (i == Naipes.AS) {
                        if (j == Palos.CORAZONES) {
                            listaCartas.add(Carta(i,j,1,11,objetoControl.listaDeResources[0]))
                        }
                        if (j == Palos.DIAMANTES) {
                            listaCartas.add(Carta(i,j,1,11,objetoControl.listaDeResources[1]))
                        }
                        if (j == Palos.TREBOLES) {
                            listaCartas.add(Carta(i,j,1,11,objetoControl.listaDeResources[3]))
                        }
                        if (j == Palos.PICAS) {
                            listaCartas.add(Carta(i,j,1,11,objetoControl.listaDeResources[4]))

                        }
                    }
                    else {
                        listaCartas.add(Carta(i,j,i.ordinal,i.ordinal, objetoControl.listaDeResources[contFotos]))
                        contFotos++
                    }
                }
            }

        }
        fun barajar() {
            listaCartas.shuffle()
        }
        fun dameCarta():Carta {
            if (listaCartas.isNotEmpty()){
                listaCartas.remove(listaCartas.last())
                Carta = listaCartas.last()
                if (listaCartas.size==1) {
                    ultimaCarta = true
                }
                return Carta
            }

            return Carta
        }
        fun borrarBaraja() {
            listaCartas.clear()
        }
    }
}