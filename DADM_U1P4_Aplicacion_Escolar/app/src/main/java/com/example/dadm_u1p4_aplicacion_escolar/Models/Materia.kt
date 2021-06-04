package com.example.dadm_u1p4_aplicacion_escolar.Models

data class Materia (var aula: String? = "",
                    var clave: String? = "",
                    var grupo: String? = "",
                    var horario: String? = "",
                    var materia: String? = "",
                    var profesor: String? = "",
                    var creditos: Long? = 0,
                    var semestre: Long? = 0,
                    var calificacion: String? = "",
                    var evaluacion: String? = "No cursada",
                    var observaciones: String? = "",
                    var regularizacion: String? = "No cursada",
                    val horarios: List<String>? = null,
                    val aulas: List<String>? = null ){
}