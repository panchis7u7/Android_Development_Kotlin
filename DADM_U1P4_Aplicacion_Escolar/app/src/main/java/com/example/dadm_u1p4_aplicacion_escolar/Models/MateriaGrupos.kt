package com.example.dadm_u1p4_aplicacion_escolar.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MateriaGrupos(
    @SerializedName("asignatura") @Expose
    val asignatura: String,
    val clave: String,
    val grupos: List<Grupo>,
    val profesor: Profesor
) {}

data class Grupo(
   val grupo: String,
   val horarioLunes: String,
   val horarioMartes: String,
   val horarioMiercoles: String,
   val horarioJueves: String,
   val horarioViernes: String,
   val aulaMartes: String,
   val aulaMiercoles: String,
   val aulaJueves: String,
   val aulaViernes: String,
   val profesor: Profesor
){}

data class Profesor(
    val nombre: String
){}