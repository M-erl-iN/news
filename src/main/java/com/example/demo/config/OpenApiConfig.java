package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .path("/api", new PathItem())
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .title("Inner Compass API")
                .description("Api for rest services")
                .version("1.0.0");
    }
}