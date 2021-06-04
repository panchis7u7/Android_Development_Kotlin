package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "profesores")
data class Profesor(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_profesor") @JsonProperty("id") var id: Long,
    @Column(name = "nombre") var nombre: String,

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    @JsonIgnore
    var grupos: List<Grupo>
) {}