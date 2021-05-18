package com.scholar.SGE.datasource

import com.scholar.SGE.model.Alumnos

interface AlumnosDataSource {
    fun obtenerAlumnos(): Collection<Alumnos> = emptyList()
}