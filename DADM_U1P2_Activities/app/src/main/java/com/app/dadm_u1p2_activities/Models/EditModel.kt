package com.app.dadm_u1p2_activities.Models

class EditModel(
    private var textViewCasa: String,
    private var textViewVisitante: String,
    private var imagenUrlCasa: String,
    private var imagenUrlVisitante: String){

    private lateinit var editTextPuntuajeCasa: String
    private lateinit var editTextPuntuajeVisitante: String

    //-------------------------------------- Nombre Casa -----------------------------------------//
    public fun getEquipoCasa(): String{
        return this.textViewCasa
    }

    public fun setEquipoCasa(nombre: String){
        this.textViewCasa = nombre
    }

    //--------------------------------------------------------------------------------------------//

    //------------------------------------ Nombre Visitante --------------------------------------//

    public fun getEquipoVisitante(): String{
        return this.textViewVisitante
    }

    public fun setEquipoVisitante(nombre: String){
        this.textViewVisitante = nombre
    }

    //--------------------------------------------------------------------------------------------//

    //------------------------------------- Puntuaje Casa ----------------------------------------//

    public fun getPuntuajeCasa(): Int{
        return this.editTextPuntuajeCasa.toInt()
    }

    public fun setPuntuajeCasa(puntuaje: Int){
        this.editTextPuntuajeCasa = puntuaje.toString()
    }

    //--------------------------------------------------------------------------------------------//

    //----------------------------------- Puntuaje Visitante -------------------------------------//

    public fun getPuntuajeVisitante(): Int{
        return this.editTextPuntuajeVisitante.toInt()
    }

    public fun setPuntuajeVisitante(puntuaje: Int){
        this.editTextPuntuajeVisitante = puntuaje.toString()
    }

    //--------------------------------------------------------------------------------------------//

    //-------------------------------------- Imagen Casa -----------------------------------------//

    public fun getImagenCasa(): String{
        return this.imagenUrlCasa
    }

    public fun setImagenCasa(url: String){
        this.imagenUrlVisitante = url
    }

    //--------------------------------------------------------------------------------------------//

    //------------------------------------ Imagen Visitante --------------------------------------//

    public fun getImagenVisitante(): String{
        return this.imagenUrlVisitante
    }

    public fun setImagenVisitante(url: String){
        this.imagenUrlVisitante = url
    }

    //--------------------------------------------------------------------------------------------//
}