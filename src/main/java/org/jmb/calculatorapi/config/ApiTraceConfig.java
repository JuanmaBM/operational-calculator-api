package org.jmb.calculatorapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class ApiTraceConfig {

    @Bean
    public TracerImpl tracerAPI() {
        // Entiendo que lo ideal seria crear el Bean usando la interfaz, pero por lo que veo
        // no hay ninguna clase que lo implemente, asi que uso esta implementacion directamente.
        return new TracerImpl();
    }
}
