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
    fun findByEmailAndPassword(@Param("email") email: String, @Param("password") password: String): Alumno

    @Query("SELECT a FROM Alumno a WHERE a.correo IN (:email)")
    fun findByEmail(@Param("email") email: String): Optional<Alumno>

    /*@Query("""
       SELECT r.domicilio, c.colonia, c.codigo_postal, m.municipio, e.estado FROM Alumno a
       INNER JOIN residencias r ON r.id_residencia = a.id_residencia
       INNER JOIN colonias c ON c.id_colonia = r.id_colonia
       INNER JOIN municipios m ON m.id_municipio = r.id_municipio
       INNER JOIN estados e ON e.id_estado = r.id_estado""")
   fun getResidencia*/
}