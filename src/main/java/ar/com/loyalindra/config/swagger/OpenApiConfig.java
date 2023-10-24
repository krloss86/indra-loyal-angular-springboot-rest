package ar.com.loyalindra.config.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Value("${loyalindra.openapi.dev-url}")
	private String devUrl;
	
	@Bean
	public OpenAPI myOpenApi() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("contact@loyalindra.com");
        contact.setName("LoyalIndra");
        contact.setUrl("https://www.loyalindra.com");

        License mitLicense = new License()
        		.name("MIT License")
        		.url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Recomendaciones API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints recomendacion")
                .termsOfService("https://www.loyalindra.com")
                .license(mitLicense);

        return new OpenAPI()
        		.info(info)
        		.servers(List.of(devServer));
	}
}
