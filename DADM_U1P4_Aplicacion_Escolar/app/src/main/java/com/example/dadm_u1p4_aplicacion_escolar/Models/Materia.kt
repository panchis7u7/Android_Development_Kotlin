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
                    val aulas: List<String>? = null,
                    var estado: String? = "No cursada",
                    var id_grupo: Long? = 0){
}

/*
data class Materia(
    var id: Int,
    var asignatura: String,
    var clave: String,
    var creditos: Int,
    var semestre: Int
){}*/