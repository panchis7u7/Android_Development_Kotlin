package com.scholar.SGE.dao

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.scholar.SGE.model.Alumno

@Repository("postgres")
interface AlumnoRepository: JpaRepository<Alumno, Long> {

}