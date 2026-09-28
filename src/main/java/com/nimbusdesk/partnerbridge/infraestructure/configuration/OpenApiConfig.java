package com.nimbusdesk.partnerbridge.infraestructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI nimbusdeskPartnerBridgeOpenApi() {
        return new OpenAPI().info(new Info()
                .title("NimbusDesk Partner Bridge Service")
                .description("Anti-corruption layer toward the partner's room-blocking system")
                .version("v1"));
    }
}
