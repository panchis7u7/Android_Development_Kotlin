package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "asignaturas")
data class Asignatura(
   @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_asignatura") @JsonProperty("id") val id: Long,
   @JsonProperty("asignatura") val asignatura: String,
   @JsonProperty("clave") val clave: String,
   @JsonProperty("creditos") val creditos: Int,
   @JsonProperty("semestre") val semestre: Int,
   @JsonProperty("semestre_cursada") val semestre_cursada: Int,
   @JsonProperty("calificacion") val calificacion: Int?,
   @JsonProperty("regularizacion") val regularizacion: String?,
   @JsonProperty("evaluacion") val evaluacion: String?,
   @JsonProperty("observaciones") val observaciones: String?,

   @OneToMany(mappedBy = "asignatura", fetch = FetchType.LAZY)
   @JsonIgnore
   var grupos: List<Grupo>,

) {}