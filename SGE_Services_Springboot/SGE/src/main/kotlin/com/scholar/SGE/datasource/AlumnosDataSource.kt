package com.scholar.SGE.datasource

import com.scholar.SGE.model.Alumnos

// Data retrieval, storage => Allow us to inject diferenta type of sources to service layer.
interface AlumnosDataSource {
    fun obtenerAlumnos(): Collection<Alumnos>
}