package com.scholar.SGE.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "profesores")
data class Profesor(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_profesor") @JsonProperty("id") var id: Long,
    @Column(name = "nombre") var nombre: String,

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "asignaturas_profesores",
    joinColumns = arrayOf(JoinColumn(name = "id_profesor")),
    inverseJoinColumns = arrayOf(JoinColumn(name = "id_asignatura")))
    var asignaturas: List<Asignatura> = mutableListOf()*/
) {}