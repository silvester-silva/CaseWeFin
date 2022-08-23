package com.wefin.gerenciapessoa.core.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("Gerencia Pessoa API - WeFin").version("v1").description("REST API de gerenciamento de pessoas WeFin"));
	}
}
