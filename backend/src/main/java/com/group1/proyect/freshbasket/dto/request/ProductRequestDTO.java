package com.group1.proyect.freshbasket.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Schema(description = "DTO para recibir datos de un producto (sin ID)")
public class ProductRequestDTO {

    @Schema(description = "Nombre del producto", example = "Manzana Roja")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Schema(description = "Precio del producto", example = "0.50")
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    private Double price;

    @Schema(description = "Stock disponible", example = "150")
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    private Integer stock;

    @Schema(description = "Descripción del producto", example = "Manzana fresca importada")
    private String description;

    @Schema(description = "ID de la categoría", example = "1")
    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoryId;

    @Schema(description = "ID del proveedor", example = "1")
    @NotNull(message = "El ID del proveedor es obligatorio")
    private Long supplierId;

    // Constructores
    public ProductRequestDTO() {}

    public ProductRequestDTO(String name, Double price, Integer stock, String description, Long categoryId, Long supplierId) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
}