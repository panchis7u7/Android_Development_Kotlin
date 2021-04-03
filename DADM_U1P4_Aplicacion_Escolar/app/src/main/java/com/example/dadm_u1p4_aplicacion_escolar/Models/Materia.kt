package com.example.dadm_u1p4_aplicacion_escolar.Models

data class Materia (val clave: String,
                    val materia: String,
                    var creditos: String,
                    val calificacion: Int = 0,
                    val evaluacion: String = "",
                    val observaciones: String = ""){
}