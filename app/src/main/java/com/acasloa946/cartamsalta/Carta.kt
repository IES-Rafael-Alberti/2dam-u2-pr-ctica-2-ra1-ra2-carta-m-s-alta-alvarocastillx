package com.acasloa946.cartamsalta

/**
 * Clase carta
 * @author: Álvaro Castilla
 * @params nombre,palo,puntosMin,puntosMax,idDrawable -> variables de carta
 */
class Carta(nombre:Naipes,palo:Palos,puntosMin:Int,puntosMax:Int,idDrawable:Int) {
    //variables que necesito
    var IdDrawable = idDrawable
    var Nombre = nombre
    var Palo = palo
    //constructor vacío para inicializar una Carta
    constructor():this(Naipes.AS,Palos.PICAS,0,0,0)
}