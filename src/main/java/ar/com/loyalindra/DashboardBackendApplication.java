package ar.com.loyalindra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Annotations
@SpringBootApplication
public class DashboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/cliente/*").allowedOrigins("http://localhost:4200");
			}
		};
	}
}
/*
ar.com.loyalindra.DashboardBackendApplication
por defecto debo usar subpaquetes:
	ar.com.loyalindra.subpaquete1
	ar.com.loyalindra.subpaquete2
	ar.com.loyalindra.subpaquete3
	ar.com.subpaquete4 //fuera del manejo de springboot
 */
