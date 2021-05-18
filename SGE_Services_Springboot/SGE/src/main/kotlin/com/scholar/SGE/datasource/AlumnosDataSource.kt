package com.scholar.SGE.datasource

import com.scholar.SGE.model.Alumnos
import org.springframework.stereotype.Repository

// Data retrieval, storage => Allow us to inject diferenta type of sources to service layer.
@Repository
interface AlumnosDataSource {
    fun obtenerAlumnos(): Collection<Alumnos>
}