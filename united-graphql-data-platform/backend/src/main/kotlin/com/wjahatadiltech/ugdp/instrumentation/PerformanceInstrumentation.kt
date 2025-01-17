package com.wjahatadiltech.ugdp.instrumentation

import graphql.ExecutionResult
import graphql.execution.instrumentation.Instrumentation
import graphql.execution.instrumentation.InstrumentationContext
import graphql.execution.instrumentation.SimpleInstrumentationContext
import graphql.execution.instrumentation.parameters.InstrumentationExecuteOperationParameters
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PerformanceInstrumentation : Instrumentation {

    private val log = LoggerFactory.getLogger(PerformanceInstrumentation::class.java)

    fun beginExecuteOperation(
        parameters: InstrumentationExecuteOperationParameters
    ): InstrumentationContext<ExecutionResult> {
        val startTime = System.currentTimeMillis()

        // Return an InstrumentationContext to handle post-execution logic
        return SimpleInstrumentationContext.whenCompleted { result, throwable ->
            val duration = System.currentTimeMillis() - startTime
            if (throwable == null) {
                log.info("Query executed successfully in {} ms", duration)
                log.info("Execution Result: {}", result.toSpecification())
            } else {
                log.error("Query execution failed in {} ms", duration, throwable)
            }
        }
    }
}
