package com.group1.proyect.freshbasket.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para enviar datos del producto al cliente (con ID y relaciones)")
public class ProductResponseDTO {

    @Schema(description = "ID del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Manzana Roja")
    private String name;

    @Schema(description = "Precio del producto", example = "0.50")
    private Double price;

    @Schema(description = "Stock disponible", example = "150")
    private Integer stock;

    @Schema(description = "Descripción del producto", example = "Manzana fresca importada")
    private String description;

    @Schema(description = "Nombre de la categoría", example = "Frutas")
    private String categoryName;

    @Schema(description = "Nombre del proveedor", example = "Distribuidora El Campo")
    private String supplierName;

    // Constructores
    public ProductResponseDTO() {}

    public ProductResponseDTO(Long id, String name, Double price, Integer stock, String description, String categoryName, String supplierName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.categoryName = categoryName;
        this.supplierName = supplierName;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }
}