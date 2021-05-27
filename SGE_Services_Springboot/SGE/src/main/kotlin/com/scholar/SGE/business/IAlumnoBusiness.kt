package com.scholar.SGE.business

import com.scholar.SGE.model.Alumno
import com.scholar.SGE.model.AlumnoGraphQL

interface IAlumnoBusiness {
    fun listAlumnos(): List<Alumno>
    fun loadAlumno(idAlumno: String): Alumno
    fun saveAlumno(alumno: Alumno): Alumno
    fun saveAlumnoQL(alumno: AlumnoGraphQL): Alumno
    fun removeAlumno(idAlumno: String)
}