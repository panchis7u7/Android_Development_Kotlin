package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

class Residencia {
}

@Entity
@Table(name = "domicilios")
data class Domicilio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name ="id_domicilio") @JsonProperty("id") val id: Long,
    @JsonProperty("domicilio") val domicilio: String,

    @ManyToOne
    @JoinColumn(name = "id_colonia", nullable = true)
    @JsonProperty("id_colonia") val colonia: Colonia?
) {}

@Entity
@Table(name = "colonias")
data class Colonia (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_colonia") @JsonProperty("id") val id: Long,
    @Column(name = "colonia") @JsonProperty("colonia") var colonia: String,

    @OneToMany(mappedBy = "colonia")
    private val domicilios: List<Domicilio>

) {}

@Entity
@Table(name = "municipios")
data class Municipio (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_municipio") @JsonProperty("id") val id: Long,
    @Column(name = "municipio") @JsonProperty("municipio") var municipio: String,

    @OneToMany(mappedBy = "colonia")
    private val domicilios: List<Domicilio>

) {}

@Entity
@Table(name = "estados")
data class Estado (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_estado") @JsonProperty("id") val id: Long,
    @Column(name = "estado") @JsonProperty("estado") var estado: String,

) {}