package com.acasloa946.cartamsalta

import com.acasloa946.cartamsalta.Screens.UIControl

class Baraja {
    companion object {
        var listaCartas = arrayListOf<Carta>()
        var objetoControl = UIControl()

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
            val Carta = listaCartas.last()
            listaCartas.remove(Carta)
            return Carta
        }
    }
}