package br.com.lgabrieldev.micro_orders.swagger;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
     
     @Bean
    public OpenAPI gerarSwaggerPersonalizado(){
        return new OpenAPI()
            .info(
                new Info().title("Sistema de Pedidos")
                    .license(
                        new License().name("MIT").url("http://localhost:8080/")
                    )
                    .version("1.0")
            )
            .servers(
                List.of(
                    new Server().url("http://localhost:8080")
                )
            );
            //tags.... etc....
    }
}