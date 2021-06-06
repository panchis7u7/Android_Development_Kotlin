package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class GruposAlumnosIdentity(
    @JsonProperty("id_alumno") val id_alumno: UUID,
    @JsonProperty("id_grupo") val id_grupo: Long,
    @JsonProperty("estado") var estado: String
): Serializable {}