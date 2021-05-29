package com.scholar.SGE.model

import java.time.LocalDate
import java.util.UUID
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "alumnos")
data class Alumno(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_alumno") @JsonProperty("id") val id: UUID = UUID.randomUUID(),
    @JsonProperty("no_control") var no_control: String,
    @JsonProperty("correo") var correo: String,
    @JsonProperty("curp") var curp: String,
    @JsonProperty("nombre") var nombre: String,
    @JsonProperty("fecha_nacimiento") var fecha_nacimiento: LocalDate? = null,
    @JsonProperty("telefono") var telefono: String?,
    @JsonProperty("sexo") var sexo: Char? = Char.MIN_VALUE,
    @JsonProperty("fotografia") var fotografia: String? = "",
    @Column(name = "contrasena") var contrasena: String,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    var domicilio: Domicilio? = null
    ) {}