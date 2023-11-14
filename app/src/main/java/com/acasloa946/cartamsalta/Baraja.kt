package com.acasloa946.cartamsalta

import com.acasloa946.cartamsalta.Screens.UIControl

/**
 * Clase baraja
 * @author: Álvaro Castilla
 */
class Baraja {

    /**
     * Companion objects de métodos y variables de la baraja
     */
    companion object {
        //variables necesarias
        lateinit var Carta : Carta
        var listaCartas = arrayListOf<Carta>()
        var objetoControl = UIControl()
        var ultimaCarta = false

        /**
         * Función para generar la baraja
         */
        fun crearBaraja() {
            var contFotos = 4

            for (i in Naipes.values()) {
                for (j in Palos.values()) {
                    //controlo si son ASES para añadirlos con sus puntuacions (1 y 11)
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
                    //sino, el valor es el mismo.
                    else {
                        listaCartas.add(Carta(i,j,i.ordinal,i.ordinal, objetoControl.listaDeResources[contFotos]))
                        contFotos++
                    }
                }
            }

        }

        /**
         * Función para barajar.
         */
        fun barajar() {
            listaCartas.shuffle()
        }

        /**
         * Función que devuelve la última carta de la baraja y la borra.
         * @return Carta -> Carta devuelta
         */
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

        /**
         * Función para borrar la baraja (solo se borra cuando se pulsa boton reiniciar).
         */
        fun borrarBaraja() {
            listaCartas.clear()
        }
    }
}