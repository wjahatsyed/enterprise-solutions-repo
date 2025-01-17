package com.wjahatadiltech.ugdp.config

import graphql.GraphQL
import graphql.schema.GraphQLSchema
import com.wjahatadiltech.ugdp.instrumentation.PerformanceInstrumentation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfig(private val schema: GraphQLSchema, private val instrumentation: PerformanceInstrumentation) {

    @Bean
    fun graphQL(): GraphQL {
        return GraphQL.newGraphQL(schema)
            .instrumentation(instrumentation)
            .build()
    }
}
