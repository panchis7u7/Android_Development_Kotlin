package com.scholar.SGE.util

import graphql.execution.ExecutionStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfig {
    @Bean
    fun executionStrategies(): Map<String, ExecutionStrategy> {
        val executionStrategyMap: HashMap<String, ExecutionStrategy> = hashMapOf()
        executionStrategyMap.put("queryExecutionStrategy", AsyncTransactionalExecutionStrategy())
        return executionStrategyMap
    }
}