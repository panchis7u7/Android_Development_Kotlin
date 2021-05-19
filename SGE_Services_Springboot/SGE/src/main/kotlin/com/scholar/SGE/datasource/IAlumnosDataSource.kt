package com.scholar.SGE.datasource

import com.scholar.SGE.model.Alumno
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

// Data retrieval, storage => Allow us to inject diferenta type of sources to service layer.
@Repository
interface AlumnosDataSource: JpaRepository<Alumno, Int> {
    /*fun obtenerAlumnos(): Collection<Alumno>*/
}