package com.scholar.SGE.business
class AlumnoDataFetcher {}

/*
import graphql.schema.DataFetcher
import org.springframework.beans.factory.annotation.Autowired
import com.scholar.SGE.model.Alumno
import com.scholar.SGE.dao.AlumnoRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class AlumnoDataFetcher {

    @Autowired
    val alumnoRepository: AlumnoRepository? = null

    fun getAllAlumnos(): DataFetcher<List<Alumno>> {
        return DataFetcher<List<Alumno>> { dataFetchingEnvironment -> alumnoRepository!!.findAll() }
    }

    fun getAlumnoByID(): DataFetcher<Alumno> {
        return DataFetcher<Alumno> { dataFetchingEnvironment -> alumnoRepository!!
            .findById(dataFetchingEnvironment.getArgument("id_alumno"))
            .orElse(null)
        }
    }

    fun deleteAlumno(): DataFetcher<*> {
        return DataFetcher { dataFetchingEnvironment -> alumnoRepository!!
            .deleteById(dataFetchingEnvironment.getArgument("id_alumno"))
        }
    }

} */