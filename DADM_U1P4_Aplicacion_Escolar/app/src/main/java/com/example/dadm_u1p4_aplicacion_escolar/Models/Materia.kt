package com.example.dadm_u1p4_aplicacion_escolar.Models

data class Materia (val clave: String,
                    val materia: String,
                    val calificacion: String,
                    val regularizacion: String,
                    var creditos: String = ""){
}