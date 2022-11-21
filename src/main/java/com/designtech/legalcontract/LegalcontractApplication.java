package com.designtech.legalcontract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.modelmapper.ModelMapper;
@SpringBootApplication
@EnableFeignClients
public class LegalcontractApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegalcontractApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	 @Bean
	    public ModelMapper modelMapper(){
	        return new ModelMapper();
	    }
}
