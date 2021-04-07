package com.example.dadm_u1p4_aplicacion_escolar.Models

data class Materia (var aula: String? = "",
                    var clave: String? = "",
                    var grupo: String? = "",
                    var horario: String? = "",
                    var materia: String? = "",
                    var profesor: String? = "",
                    var creditos: String? = "",
                    var semestre: String? = "",
                    var calificacion: String? = "",
                    var evaluacion: String? = "No cursada",
                    var observaciones: String? = "",
                    var regularizacion: String? = "No cursada"){
}