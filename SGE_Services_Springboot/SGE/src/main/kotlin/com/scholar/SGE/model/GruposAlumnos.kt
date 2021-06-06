package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "grupos_alumnos")
data class GruposAlumnos(

    @EmbeddedId
    val gruposAlumnosIdentity: GruposAlumnosIdentity,
    @JsonProperty("semestre_cursada") @Column(name = "semestre_cursada") val semestre_cursada: Int?,
    @JsonProperty("calificacion") @Column(name = "calificacion") val calificacion: Int?,
    @JsonProperty("regularizacion") @Column(name = "regularizacion") val regularizacion: String?,
    @JsonProperty("evaluacion") @Column(name = "evaluacion") val evaluacion: String?,
    @JsonProperty("observaciones") @Column(name = "observaciones") val observaciones: String?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", updatable = false, insertable = false)
    val alumno: Alumno,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo", updatable = false, insertable = false)
    val grupo: Grupo,

    ) {
    fun estado(): String = gruposAlumnosIdentity.estado
}
