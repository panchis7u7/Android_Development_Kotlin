package com.app.dadm_u1p2_activities.Models

open class Civilizacion(
    private var nombre: String = "",
    private var imagenUrl: String = ""){

    public fun getNombre(): String {
        return this.nombre
    }

    public fun setNombre(nombre: String){
        this.nombre = nombre
    }

    public fun getImagen(): String{
        return this.imagenUrl
    }

    public fun setImagen(imagenUrl: String){
        this.imagenUrl = imagenUrl
    }
}