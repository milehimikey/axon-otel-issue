package com.example.axonotelissue.config

import org.axonframework.tracing.MultiSpanFactory
import org.axonframework.tracing.SpanFactory
import org.axonframework.tracing.opentelemetry.OpenTelemetrySpanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfiguration {
    @Bean
    fun spanFactory(): SpanFactory {
        return MultiSpanFactory(
            listOf(
//                Logging commented out solely so we know which is causing the issue
//                LoggingSpanFactory.INSTANCE,
                OpenTelemetrySpanFactory
                    .builder()
                    .build()
            )
        )
    }
}
