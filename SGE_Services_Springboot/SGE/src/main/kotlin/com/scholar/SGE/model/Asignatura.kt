package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "asignaturas")
data class Asignatura(
   @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_asignatura") @JsonProperty("id") val id: Long,
   @JsonProperty("asignatura") val asignatura: String,
   @JsonProperty("clave") val clave: String,
   @JsonProperty("grupo") val grupo: String,
   @JsonProperty("creditos") val creditos: Int,
   @JsonProperty("semestre") val semestre: Int,
   @JsonProperty("semestre_cursada") val semestre_cursada: Int,
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
   @JsonProperty("calificacion") val calificacion: Int?,
   @JsonProperty("regularizacion") val regularizacion: String?,
   @JsonProperty("evaluacion") val evaluacion: String?,
   @JsonProperty("observaciones") val observaciones: String?,

   @ManyToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
   @JoinTable(name = "asignaturas_profesores",
      joinColumns = arrayOf(JoinColumn(name = "id_asignatura")),
      inverseJoinColumns = arrayOf(JoinColumn(name = "id_profesor")))
   var profesores: List<Profesor> = mutableListOf()
) {}