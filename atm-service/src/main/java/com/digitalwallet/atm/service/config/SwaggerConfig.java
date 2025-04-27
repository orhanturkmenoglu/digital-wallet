package com.digitalwallet.atm.service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    @Bean
    public Info apiInfo() {
        return new Info()
                .title("ATM Service")
                .description("API Documentation for ATM Service")
                .version("1.0.0")
                .contact(contact());
    }

    @Bean
    public Contact contact() {
        return new Contact()
                .name("ATM Service")
                .email("support@digitalwallet.com");
    }
}
