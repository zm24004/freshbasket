package com.group1.proyect.freshbasket.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.context.annotation.Configuration;
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Inventario FreshBasket",
        version = "2.0.0",
        description = """
            API REST para la gestión del inventario de la tienda FreshBasket.
            
            ## Características principales:
            * CRUD completo de productos
            * Búsqueda por nombre
            * Manejo de stock
            * Documentación interactiva con Swagger UI
            
            ## Contactos del proyecto:
            - **Desarrollador:** Victor Rodriguez
            - **Email:** RM240804@ues.edu.sv
            - **GitHub:** https://github.com/RM240804/freshbasket
            """,
        contact = @Contact(
            name = "Victor Rodriguez - Grupo 1 DAW",
            email = "RM240804@ues.edu.sv",
            url = "https://github.com/RM240804/freshbasket"
        ),
        license = @License(
            name = "Licencia Grupo 1 DAW",
            url = "https://github.com/RM240804/freshbasket/blob/main/LICENSE"
        )
    ),
    servers = {
        @Server(
            description = "Servidor Local",
            url = "http://localhost:8080"
        )
    }
)
public class OpenApiConfig {
    // Clase de configuración para la documentación de la API
}
