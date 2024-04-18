package com.jack_dev.inventory_control.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Inventory Control")
						.version("V1")
						.description("application of inventory control and management of items and products")
						.termsOfService("https://Jcode.com.br")
						.license(new License()
								.name("Apache 2.0")
								.url("https://Jcode.com.br")
						)
				);
	}
}
