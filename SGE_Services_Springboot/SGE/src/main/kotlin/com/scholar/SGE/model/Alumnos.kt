package com.scholar.SGE.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "alumnos")
data class Alumnos(
    val id_alumno: Int,
    val no_control: String,
    val correo: String,
    val curp: String,
    val nombre: String,
    val fecha_nacimiento: String,
    val telefono: String,
    val sexo: Char,
    val fotografia: String
    ) { }