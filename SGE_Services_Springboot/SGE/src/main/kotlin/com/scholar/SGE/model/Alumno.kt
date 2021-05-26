package com.scholar.SGE.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.hibernate.annotations.GeneratorType
import java.time.LocalDate
import java.util.UUID
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@Table(name = "alumnos")
data class Alumno(
    @Id @JsonProperty("id_alumno") val id_alumno: UUID,
    @JsonProperty("no_control")val no_control: String,
    @JsonProperty("correo") val correo: String,
    @JsonProperty("curp") val curp: String,
    @JsonProperty("nombre") val nombre: String,
    @JsonProperty("fecha_nacimiento") val fecha_nacimiento: LocalDate? = null,
    @JsonProperty("telefono") val telefono: String?,
    @JsonProperty("sexo") val sexo: Char? = Char.MIN_VALUE,
    @JsonProperty("fotografia") val fotografia: String? = ""
    ) { 
        //@Id
        //@GeneratedValue(strategy = GenerationType.SEQUENCE)
        //var id_alumno: UUID = UUID.randomUUID()
    }