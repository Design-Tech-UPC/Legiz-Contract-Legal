package com.designtech.legalcontract.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
	 @Bean(name = "LegalContractService")
	    public OpenAPI bloggingOpenApi() {
	        return new OpenAPI()
	                .components(new Components())
	                .info(new Info()
	                        .title("Legal Contract Application Service API")
	                        .description("Legal Contract Service API implemented with Spring Boot RESTful service by Design Tech"));
	    }
}
