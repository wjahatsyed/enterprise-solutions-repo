package com.wjahatadiltech.ugdp.controller

import graphql.schema.GraphQLSchema
import graphql.schema.validation.SchemaValidator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
class SchemaValidationController(private val schema: GraphQLSchema) {

    @GetMapping("/validate-schema")
    fun validateSchema(): ResponseEntity<out List<Any>> {
        val validator = SchemaValidator()
        val errors = validator.validateSchema(schema)
        return if (errors.isEmpty()) {
            ResponseEntity.ok(listOf("Schema is valid"))
        } else {
            ResponseEntity.badRequest().body(errors.map {})
        }
    }
}
