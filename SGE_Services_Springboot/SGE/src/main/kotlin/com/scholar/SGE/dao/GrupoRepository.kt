package com.scholar.SGE.dao

import com.scholar.SGE.model.Alumno
import com.scholar.SGE.model.Grupo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GrupoRepository: JpaRepository<Grupo, Long> {
    @Query("SELECT g FROM Grupo g WHERE g.grupo IN (:grupo)")
    fun findByGrupo(@Param("grupo") grupo: String): Optional<Grupo>
}