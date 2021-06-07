package com.example.dadm_u1p4_aplicacion_escolar.Models

import java.util.*

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
                  var telefono: String? ="") {

    companion object {
        var semestre: Int = -1
        var semestresCarrera: Int = -1
        var id: UUID = UUID.fromString("1575c67f-e248-46bb-8cc7-748278f33b6a")
        var token: String = "eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MjMwOTkzNDMsImV4cCI6MTYyMzEwNjU0MywiaWRBbHVtbm8iOiIxNTc1YzY3Zi1lMjQ4LTQ2YmItOGNjNy03NDgyNzhmMzNiNmEiLCJjb3JyZW8iOiJzbWFkQGdtYWlsLmNvbSAgICAgICAgICAgICAgICAgICAgICIsIm5vbWJyZSI6IkNhcmxvcyBTZWJhc3RpYW4gTWFkcmlnYWwgUm9kcmlndWV6Iiwibm9Db250cm9sIjoiMTgxMjE2OTkgICJ9.8L0PX61XV14S1bRqA30iqAcmlrgofvfrbcm_gruO1bnd9OWrOyjX6xa3xxSzy2soAUinHvsO7XY98qFD1Zw8uA"
    }
}