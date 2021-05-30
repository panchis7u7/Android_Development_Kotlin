package com.scholar.SGE.business

import com.scholar.SGE.model.Profesor

interface IProfesorBusiness {
    fun listProfesores(): List<Profesor>
    fun loadProfesor(idProfesor: Long): Profesor
    fun saveProfesor(profesor: Profesor): Profesor
    fun removeProfesor(idProfesor: Long)
}