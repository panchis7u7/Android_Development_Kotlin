package com.app.dadm_u1p2_activities.Models

class EditModel(
    private var civilizacionCasa: Civilizacion,
    private var civilizacionVisitante: Civilizacion){

    private var editTextPuntuajeCasa: String = ""
    private var editTextPuntuajeVisitante: String = ""

    //--------------------------------------- Civil Casa -----------------------------------------//

    public fun getCivilizacionCasa(): Civilizacion{
        return this.civilizacionCasa
    }

    public fun setCivilizacionCasa(civilizacionCasa: Civilizacion){
        this.civilizacionCasa = civilizacionCasa
    }

    //--------------------------------------------------------------------------------------------//

    //------------------------------------- Civil Visitante --------------------------------------//

    public fun getCivilizacionVisitante(): Civilizacion{
        return this.civilizacionVisitante
    }

    public fun setCivilizacionVisitante(civilizacionVisitante: Civilizacion){
        this.civilizacionVisitante = civilizacionVisitante
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
}