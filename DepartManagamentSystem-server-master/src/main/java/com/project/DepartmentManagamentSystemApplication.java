package com.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@CrossOrigin(origins = "*" ,allowedHeaders = "*" )
@SpringBootApplication
public class DepartmentManagamentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentManagamentSystemApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new  ModelMapper();
	}

//	@Bean
//	public WebMvcConfigurer  corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*") // Replace with your Angular app URL
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
//						.allowedHeaders("*") // Allowed request headers (you can customize this based on your requirements)
//						.allowCredentials(true);
//			}
//		};
//	}
}
