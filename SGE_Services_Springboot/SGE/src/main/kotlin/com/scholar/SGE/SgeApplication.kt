package com.scholar.SGE

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.dao.AlumnoRepository
import com.scholar.SGE.model.Alumno
import java.time.format.DateTimeFormatter
import java.time.LocalDate
import java.util.UUID

@SpringBootApplication
class SgeApplication /* :CommandLineRunner*/ {
/* 	
	@Autowired
	val alumnoRepository: AlumnoRepository? = null

	override fun run(vararg args: String?){

		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val alumno = Alumno(
			UUID.randomUUID(),
			"568734", 
			"sebastian.prueba@gmail.com", 
			"MICA82378DS872",
			"Carlos Sebastian Madrigal Rodriguez",
			LocalDate.parse("29-05-1999", formatter),
			"44968521",
			'M',
			"foto")

		alumnoRepository!!.save(alumno)
	} */
}

fun main(args: Array<String>) {
	runApplication<SgeApplication>(*args)
}
