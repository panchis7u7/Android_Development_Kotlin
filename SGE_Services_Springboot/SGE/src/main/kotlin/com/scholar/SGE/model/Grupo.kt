package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.*
import javax.persistence.*

@Entity
@Table(name = "grupos")
data class Grupo (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo") @JsonProperty("id") val id: Long,
    @JsonProperty("grupo") @Column(name = "grupo") val grupo: String,
    @JsonProperty("horario_lunes") val horario_lunes: String?,
    @JsonProperty("horario_martes") val horario_martes: String?,
    @JsonProperty("horario_miercoles")val horario_miercoles: String?,
    @JsonProperty("horario_jueves") val horario_jueves: String?,
    @JsonProperty("horario_viernes") val horario_viernes: String?,
    @JsonProperty("aula_lunes")val aula_lunes: String?,
    @JsonProperty("aula_martes") val aula_martes: String?,
    @JsonProperty("aula_miercoles") val aula_miercoles: String,
    @JsonProperty("aula_jueves") val aula_jueves: String?,
    @JsonProperty("aula_viernes")val aula_viernes: String?,

    @ManyToOne @JoinColumn(name = "id_asignatura", nullable = false)
    @JsonProperty("asignatura") var asignatura: Asignatura,

    @ManyToOne @JoinColumn(name = "id_profesor", nullable = false)
    @JsonProperty("profesor") var profesor: Profesor,

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "asignaturas_alumnos",
        joinColumns = arrayOf(JoinColumn(name = "id_grupo")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "id_alumno")))
    @JsonIgnore
    var alumnos: List<Alumno> = mutableListOf()*/

    @OneToMany(mappedBy = "grupo", cascade = arrayOf(CascadeType.ALL))
    val gruposAlumnos: List<GruposAlumnos>

    ) {}