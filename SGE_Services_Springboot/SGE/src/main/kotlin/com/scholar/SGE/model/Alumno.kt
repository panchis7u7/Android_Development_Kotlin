package com.scholar.SGE.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.hibernate.annotations.GeneratorType
import java.time.LocalDate

@Entity
@Table(name = "alumnos")
data class Alumno(
    /*val id_alumno: Int,*/
    val no_control: String? = "",
    val correo: String? = "",
    val curp: String? = "",
    val nombre: String? = "",
    val fecha_nacimiento: LocalDate? = null,
    val telefono: String? = "",
    val sexo: Char? = Char.MIN_VALUE,
    val fotografia: String? = ""
    ) { 
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id_alumno: Long = 0
    }