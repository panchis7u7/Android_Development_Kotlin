package com.example.dadm_u1p4_aplicacion_escolar.Models

data class ReporteSemestral(var periodo: String,
                            var calificaciones: MutableList<Materia>) {
}