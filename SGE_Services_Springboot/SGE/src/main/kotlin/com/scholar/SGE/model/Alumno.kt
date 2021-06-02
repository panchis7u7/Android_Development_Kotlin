package com.scholar.SGE.model

import java.time.LocalDate
import java.util.UUID
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "alumnos")
data class Alumno(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_alumno") @JsonProperty("id") val id: UUID = UUID.randomUUID(),
    @JsonProperty("no_control") @Column(name = "no_control") var no_control: String,
    @JsonProperty("correo") @Column(name = "correo") var correo: String,
    @JsonProperty("curp") @Column(name = "curp") var curp: String,
    @JsonProperty("nombre") @Column(name = "nombre") var nombre: String,
    @JsonProperty("fecha_nacimiento") @Column(name = "fecha_nacimiento") var fecha_nacimiento: LocalDate? = null,
    @JsonProperty("telefono") @Column(name = "telefono") var telefono: String? ="",
    @JsonProperty("sexo") @Column(name = "sexo") var sexo: Char? = Char.MIN_VALUE,
    @JsonProperty("fotografia") @Column(name = "fotografia") var fotografia: String? = "",
    @JsonProperty("contrasena") @Column(name = "contrasena") var contrasena: String,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "id_residencia", referencedColumnName = "id_residencia")
    var residencia: Residencia? = null
    ) {}