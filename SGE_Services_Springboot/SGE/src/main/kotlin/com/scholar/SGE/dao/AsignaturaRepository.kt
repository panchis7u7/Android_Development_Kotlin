package com.scholar.SGE.dao

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.scholar.SGE.model.Asignatura
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

@Repository
interface AsignaturaRepository: JpaRepository<Asignatura, Long> {
    @Query("SELECT a FROM Asignatura a WHERE a.clave IN (:clave)")
    fun findByCLave(@Param("clave") clave: String): Optional<Asignatura>
}