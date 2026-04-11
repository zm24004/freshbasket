package com.group1.proyect.freshbasket.service.impl;

import com.group1.proyect.freshbasket.dto.request.ProductRequestDTO;
import com.group1.proyect.freshbasket.dto.response.ProductResponseDTO;
import com.group1.proyect.freshbasket.entity.Category;
import com.group1.proyect.freshbasket.entity.Product;
import com.group1.proyect.freshbasket.entity.Supplier;
import com.group1.proyect.freshbasket.repository.CategoryRepository;
import com.group1.proyect.freshbasket.repository.ProductRepository;
import com.group1.proyect.freshbasket.repository.SupplierRepository;
import com.group1.proyect.freshbasket.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    
    //Repositorio para buscar las relaciones
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    // constructor con los 3 repositorios
    public ProductServiceImpl(ProductRepository productRepository,
                CategoryRepository categoryRepository,
                SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    // DTO: Entidad (para recibir y guardar)
    @SuppressWarnings("null")
    private Product convertToEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setDescription(dto.getDescription());

        // Buscar la Categoría por ID. Si no existe, lanza error.
        @SuppressWarnings("null")
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + dto.getCategoryId()));
        
        // Buscar el Proveedor por ID. Si no existe, lanza error.
        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + dto.getSupplierId()));

        // Asignar las relaciones al producto
        product.setCategory(category);
        product.setSupplier(supplier);

        return product;
    }

    // Entidad → DTO (para enviar al cliente)
    private ProductResponseDTO convertToDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setDescription(product.getDescription());

        // Extraemos solo el nombre para no enviar todo el objeto de la relación
        if (product.getCategory() != null) {
            dto.setCategoryName(product.getCategory().getName());
        }
        if (product.getSupplier() != null) {
            dto.setSupplierName(product.getSupplier().getName());
        }

        return dto;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public ProductResponseDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = convertToEntity(requestDTO); // Convierte y busca relaciones
        @SuppressWarnings("null")
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @SuppressWarnings("null")
    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    // Actualizar campos básicos
                    existingProduct.setName(requestDTO.getName());
                    existingProduct.setPrice(requestDTO.getPrice());
                    existingProduct.setStock(requestDTO.getStock());
                    existingProduct.setDescription(requestDTO.getDescription());

// Actualiza relaciones si se envían nuevos IDs
                    @SuppressWarnings("null")
                    Category category = categoryRepository.findById(requestDTO.getCategoryId())
                            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + requestDTO.getCategoryId()));
                    Supplier supplier = supplierRepository.findById(requestDTO.getSupplierId())
                            .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + requestDTO.getSupplierId()));

                    existingProduct.setCategory(category);
                    existingProduct.setSupplier(supplier);

                    return productRepository.save(existingProduct);
                })
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @SuppressWarnings("null")
    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}