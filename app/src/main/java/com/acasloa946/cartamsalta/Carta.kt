package com.acasloa946.cartamsalta

class Carta(nombre:Naipes,palo:Palos,puntosMin:Int,puntosMax:Int,idDrawable:Int) {
    var IdDrawable = idDrawable
    var Nombre = nombre
    var Palo = palo
    constructor():this(Naipes.AS,Palos.PICAS,0,0,0)
}