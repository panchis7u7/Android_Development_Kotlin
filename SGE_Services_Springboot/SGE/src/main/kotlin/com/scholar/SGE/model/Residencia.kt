package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "residencias")
data class Residencia (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name ="id_residencia") @JsonProperty("id") val id: Long,
    @JsonProperty("domicilio") val domicilio: String,

    @ManyToOne
    @JoinColumn(name = "id_colonia", nullable = true)
    @JsonProperty("id_colonia") val colonia: Colonia?,

    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = true)
    @JsonProperty("id_municipio") val municipio: Municipio?,

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = true)
    @JsonProperty("id_estado") val estado: Estado?
){}

@Entity
@Table(name = "colonias")
data class Colonia (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_colonia") @JsonProperty("id") val id: Long,
    @Column(name = "colonia") @JsonProperty("colonia") var colonia: String,
    @Column(name = "codigo_postal") @JsonProperty("codigo_postal") var codigoPostal: String
) {}

@Entity
@Table(name = "municipios")
data class Municipio (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_municipio") @JsonProperty("id") val id: Long,
    @Column(name = "municipio") @JsonProperty("municipio") var municipio: String,
) {}

@Entity
@Table(name = "estados")
data class Estado (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_estado") @JsonProperty("id") val id: Long,
    @Column(name = "estado") @JsonProperty("estado") var estado: String,
) {}