package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "domicilios")
data class Domicilio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name ="id_domicilio") @JsonProperty("id") val id: Long,
    @JsonProperty("domicilio") val domicilio: String,

    @ManyToOne
    @JoinColumn(name = "id_colonia", nullable = true)
    @JsonProperty("id_colonia") val colonia: Colonia?
) {}