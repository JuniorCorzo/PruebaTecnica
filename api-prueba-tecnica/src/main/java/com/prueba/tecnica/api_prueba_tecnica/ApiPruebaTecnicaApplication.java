package com.prueba.tecnica.api_prueba_tecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiPruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPruebaTecnicaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configCors(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
