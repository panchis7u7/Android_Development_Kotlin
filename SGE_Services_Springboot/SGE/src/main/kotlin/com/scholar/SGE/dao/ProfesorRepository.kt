package com.scholar.SGE.dao

import com.scholar.SGE.model.Profesor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfesorRepository: JpaRepository<Profesor, Long> {}