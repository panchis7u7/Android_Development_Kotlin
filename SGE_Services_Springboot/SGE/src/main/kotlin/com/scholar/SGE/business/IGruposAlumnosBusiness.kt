package com.scholar.SGE.business

import com.scholar.SGE.model.GruposAlumnos
import java.util.*

interface IGruposAlumnosBusiness {
    fun addGroup(id_alumno: UUID, id_grupo: Long, estado: String, semestre_cursada: Int, calificacion: Int, regularizacion: String, evaluacion: String, observaciones: String): Boolean
    //fun addGroup(grupo: GruposAlumnos): Boolean
}