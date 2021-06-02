package com.scholar.SGE.dao

import com.scholar.SGE.model.Colonia
import com.scholar.SGE.model.Estado
import com.scholar.SGE.model.Municipio
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.scholar.SGE.model.Residencia

@Repository
interface ResidenciaRepository: JpaRepository<Residencia, Long> {}

@Repository
interface  ColoniaRepository: JpaRepository<Colonia, Long> {}

@Repository
interface  MunicipioRepository: JpaRepository<Municipio, Long> {}

@Repository
interface  EstadoRepository: JpaRepository<Estado, Long> {}