package com.scholar.SGE.model

import java.time.LocalDate
import java.util.UUID
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "alumnos")
data class Alumno(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonProperty("id_alumno") val id_alumno: UUID = UUID.randomUUID(),
    @JsonProperty("no_control") val no_control: String,
    @JsonProperty("correo") val correo: String,
    @JsonProperty("curp") val curp: String,
    @JsonProperty("nombre") val nombre: String,
    @JsonProperty("fecha_nacimiento") val fecha_nacimiento: LocalDate? = null,
    @JsonProperty("telefono") val telefono: String?,
    @JsonProperty("sexo") val sexo: Char? = Char.MIN_VALUE,
    @JsonProperty("fotografia") val fotografia: String? = "",

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    val domicilio: Domicilio? = null
    ) {}