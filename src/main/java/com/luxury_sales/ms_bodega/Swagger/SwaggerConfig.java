package com.luxury_sales.ms_bodega.Swagger;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Microservicio de Bodega")
                        .version("1.0")
                        .description("Documentación de la api para el ms-bodega."));
    }
}
//localhost:8083/swagger-ui/index.html