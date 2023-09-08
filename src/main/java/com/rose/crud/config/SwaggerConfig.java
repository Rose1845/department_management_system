package com.rose.crud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.context.annotation.Bean;
@OpenAPI31

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new io.swagger.v3.oas.models.info
                        .Info()
                        .title("SECURITY FOR SCHOOL MANAGEMENT SYSTEM")
                        .description("API to reister and login A USER ")
                        .version("1.0.0")
        );
    }
}




