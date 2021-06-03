package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.transaction.annotation.Transactional
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

   @OneToMany(mappedBy = "asignatura", fetch = FetchType.EAGER)
   @JsonIgnoreProperties("asignatura")
   var grupos: List<Grupo>,

   @ManyToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
   @JoinTable(name = "asignaturas_alumnos",
      joinColumns = arrayOf(JoinColumn(name = "id_asignatura")),
      inverseJoinColumns = arrayOf(JoinColumn(name = "id_alumno")))
   @JsonIgnoreProperties("asignatura", "grupos")
   var alumnos: List<Alumno> = mutableListOf()

) {}