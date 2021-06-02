package com.scholar.SGE.model

import org.hibernate.annotations.GeneratorType
import java.time.LocalDate
import java.util.UUID
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "alumnos")
data class AlumnoGraphQL (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JsonProperty("id_alumno") val id_alumno: UUID= UUID.randomUUID(),
    @JsonProperty("no_control")val no_control: String,
    @JsonProperty("correo") val correo: String,
    @JsonProperty("curp") val curp: String,
    @JsonProperty("nombre") val nombre: String,
    @JsonProperty("fecha_nacimiento") val fecha_nacimiento: String? = "",
    @JsonProperty("telefono") val telefono: String? = "",
    @JsonProperty("sexo") val sexo: Char? = Char.MIN_VALUE,
    @JsonProperty("fotografia") val fotografia: String? = "",
    var contrasena: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_residencia")
    val residencia: Residencia? = null
) {}