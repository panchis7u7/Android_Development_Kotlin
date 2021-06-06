package com.scholar.SGE

import com.scholar.SGE.business.AuthFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean

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
	@Bean
	fun filterRegistrationBean(): FilterRegistrationBean<AuthFilter> {
		val registrationBean = FilterRegistrationBean<AuthFilter>()
		registrationBean.filter = AuthFilter()
		registrationBean.addUrlPatterns("/alumnos")
		//registrationBean.addUrlPatterns("/graphql/*")
		registrationBean.addUrlPatterns("/profesores/*")
		registrationBean.addUrlPatterns("/domicilios/*")
		registrationBean.addUrlPatterns("/asignaturas/*")
		return registrationBean
	}
}

fun main(args: Array<String>) {
	runApplication<SgeApplication>(*args)
}
