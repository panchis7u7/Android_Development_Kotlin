package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
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
    val residencia: Residencia? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura")
    val asignatura: Asignatura,

    @ManyToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "asignaturas_alumnos",
        joinColumns = arrayOf(JoinColumn(name = "id_alumno")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "id_grupo")))
    var grupos: List<Grupo> = mutableListOf()
) {}