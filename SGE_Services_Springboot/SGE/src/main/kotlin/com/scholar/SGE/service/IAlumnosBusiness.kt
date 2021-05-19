package com.scholar.SGE.service

import com.scholar.SGE.model.Alumno

interface IAlumnosBusiness {
    fun list(): List<Alumno>
    fun load(idAlumno: Int): Alumno
    fun save(alumno: Alumno): Alumno
    fun remove(idAlumno: Int)
}