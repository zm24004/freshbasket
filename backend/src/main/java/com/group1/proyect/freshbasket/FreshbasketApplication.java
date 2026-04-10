package com.group1.proyect.freshbasket;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPiDefinition(
		info = @Info(
			title = "Inventario de tienda",
			version = "1.0",
			description = "Api para gestion de inventatio",
			contact = @Contact(name = "victor", email = "victor@mail.com") 
		)
	)
@SpringBootApplication
public class FreshbasketApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FreshbasketApplication.class, args);
	}

}
