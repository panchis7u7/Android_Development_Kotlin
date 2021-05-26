package com.scholar.SGE.business

import com.scholar.SGE.model.Alumno

interface IAlumnoBusiness {
    fun listAlumnos(): List<Alumno>
    fun loadAlumno(idAlumno: String): Alumno
    fun save(alumno: Alumno): Alumno
    fun remove(idAlumno: String)
}