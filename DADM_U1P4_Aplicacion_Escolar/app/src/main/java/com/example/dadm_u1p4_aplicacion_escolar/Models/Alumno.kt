package com.example.dadm_u1p4_aplicacion_escolar.Models

data class Alumno(var nombre: String? = "",
                  var fotografia: String? = "",
                  var carrera: String? = "",
                  var noControl: String? = "",
                  var correoInstitucional: String? = "",
                  var curp: String? = "",
                  var fechaNacimiento: String? = "",
                  var sexo: String? = "",
                  var calleNumero: String? = "",
                  var municipio: String? = "",
                  var estado: String? = "",
                  var colonia: String? = "",
                  var codigoPostal: String? = "",
                  var telefono: String? ="",) {

    companion object {
        var semestre: Int = -1
    }
}