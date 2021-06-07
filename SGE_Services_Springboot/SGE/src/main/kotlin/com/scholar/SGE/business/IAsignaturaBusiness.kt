package com.scholar.SGE.business

import com.scholar.SGE.model.Asignatura
import com.scholar.SGE.model.Residencia

interface IAsignaturaBusiness {
    fun listAsignaturas(): List<Asignatura>
    fun loadAsignatura(clave: String): Asignatura
    fun saveAsignatura(Asignatura: Asignatura): Asignatura
    fun removeAsignatura(idAsignatura: Long)
}