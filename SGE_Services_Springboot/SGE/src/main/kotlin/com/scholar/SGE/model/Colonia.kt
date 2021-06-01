package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "colonias")
data class Colonia (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_colonia") @JsonProperty("id") val id: Long,
    @Column(name = "colonia") @JsonProperty("colonia") var colonia: String,

    @OneToMany(mappedBy = "colonia")
    private val domicilios: List<Domicilio>

) {}