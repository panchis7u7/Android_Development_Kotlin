package com.scholar.SGE.dao

import com.scholar.SGE.model.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AlumnoRepository: JpaRepository<Alumno, UUID> {
    @Query("SELECT COUNT(*) FROM Alumno a WHERE a.correo IN (:email)")
    fun getCountByAlumnoCorreo(@Param("email") email: String): Long

    @Query("SELECT a FROM Alumno a WHERE a.correo IN (:email) AND a.contrasena IN (:password)")
    fun findByEmailAndPassword(@Param("email") email: String, @Param("password")password: String): Alumno
}