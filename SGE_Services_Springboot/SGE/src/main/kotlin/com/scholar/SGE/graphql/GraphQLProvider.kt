package com.scholar.SGE.graphql

class GraphQLProvider {}
/*
import com.scholar.SGE.business.AlumnoBusiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import com.google.common.io.Resources
import com.scholar.SGE.business.AlumnoDataFetcher
import graphql.schema.idl.*
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import javax.annotation.PostConstruct
import kotlin.jvm.Throws

@Component
class GraphQLProvider {
    
    @Autowired
    val alumnoDataFetcher: AlumnoDataFetcher? = null

    private lateinit var graphql: GraphQL

    @Bean
    fun graphql(): GraphQL = graphql

    @PostConstruct
    @Throws
    fun init() {
        val url = Resources.getResource("schema.graphql")
        val schemaString = Resources.toString(url, Charsets.UTF_8)
        val graphQLSchema: GraphQLSchema = schema(schemaString)
        this.graphql = GraphQL.newGraphQL(graphQLSchema).build()
    }

    private fun schema(schema: String): GraphQLSchema {
        val typeDefinitionRegistry: TypeDefinitionRegistry = SchemaParser().parse(schema)
        val runtimeWiring: RuntimeWiring = buildWiring()
        val schemaGenerator = SchemaGenerator()
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)
    }

    private fun buildWiring(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring()
            .type(mutationBuilder())
            .type(queryBuilder())
            .build()
    }

    private fun mutationBuilder(): TypeRuntimeWiring.Builder {
        return TypeRuntimeWiring.newTypeWiring("Mutation")
            .dataFetcher("deleteAlumno", alumnoDataFetcher!!.deleteAlumno())
    }

    private fun queryBuilder(): TypeRuntimeWiring.Builder {
        return TypeRuntimeWiring.newTypeWiring("Query")
            .dataFetcher("getAllAlumnos", alumnoDataFetcher!!.getAllAlumnos())
            .dataFetcher("getAlumnoByID", alumnoDataFetcher!!.getAlumnoByID())
    }
}*/