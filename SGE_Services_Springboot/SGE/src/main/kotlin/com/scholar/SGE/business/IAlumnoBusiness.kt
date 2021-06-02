package com.scholar.SGE.business

import com.scholar.SGE.model.Alumno
import com.scholar.SGE.model.AlumnoGraphQL
import com.scholar.SGE.model.Domicilio
import com.scholar.SGE.model.Residencia

interface IAlumnoBusiness {
    fun listAlumnos(): List<Alumno>
    fun loadAlumno(idAlumno: String): Alumno
    fun saveAlumno(alumno: Alumno): Alumno

    fun validateUser(email: String, password: String): Alumno
    fun registerUser(alumno: AlumnoGraphQL): Alumno
    fun generateJWTToken(alumno: Alumno): Map<String, String>

    fun updateAlumno(idAlumno: String, telefono: String?, residencia: Residencia?): Alumno
    fun saveAlumnoQL(alumno: AlumnoGraphQL): Alumno
    fun removeAlumno(idAlumno: String)
    fun getResidencia(idAlumno: String): Residencia
}