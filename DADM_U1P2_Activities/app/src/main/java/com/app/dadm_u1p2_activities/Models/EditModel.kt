package com.app.dadm_u1p2_activities.Models

class EditModel {
    private lateinit var editTextPuntuajeCasa: String
    private lateinit var editTextPuntuajeVisitante: String
    private lateinit var textViewCasa: String
    private lateinit var textViewVisitante: String

    public fun getEquipoCasa(): String{
        return this.textViewCasa
    }

    public fun getEquipoVisitante(): String{
        return this.textViewVisitante
    }

    public fun setEquipoCasa(nombre: String){
        this.textViewCasa = nombre
    }

    public fun setEquipoVisitante(nombre: String){
        this.textViewVisitante = nombre
    }

    public fun getPuntuajeCasa(): Int{
        return this.editTextPuntuajeCasa.toInt()
    }

    public fun getPuntuajeVisitante(): Int{
        return this.editTextPuntuajeVisitante.toInt()
    }
}