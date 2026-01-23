package com.levelup.app.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Level Up API",
        version = "0.0.1",
        description = "Documentacion de la API"
    )
    
)
public class OpenApiConfig {
    
}
