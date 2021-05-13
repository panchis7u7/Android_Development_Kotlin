package com.example.dadm_u1p4_aplicacion_escolar.Models

data class ReporteSemestral(var periodo: String,
                            var materias: MutableList<Materia>? = null,
                            var promedio: Float? = 0f,
                            var creditos: Long? = 0) {
    /*constructor(periodo: String,
                materias: MutableList<Materia>,
                promedio: Int? = 0,
                creditos: Int? = 0) : this(periodo, materias)*/
}