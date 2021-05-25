package com.scholar.SGE.business

import com.scholar.SGE.model.Alumno

interface IAlumnoBusiness {
    fun list(): List<Alumno>
    fun load(idAlumno: Long): Alumno
    fun save(alumno: Alumno): Alumno
    fun remove(idAlumno: Long)
}