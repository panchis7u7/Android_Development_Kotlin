package com.scholar.SGE.dao

import com.scholar.SGE.model.GruposAlumnos
import com.scholar.SGE.model.GruposAlumnosIdentity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GruposAlumnosRepository: JpaRepository<GruposAlumnos, GruposAlumnosIdentity> {}