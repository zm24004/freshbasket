package com.group1.proyect.freshbasket.repository;

import com.group1.proyect.freshbasket.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // JpaRepository brinda las opciones save(), findById(), findAll(), existsById(), etc.
    
    // Por si se necesita buscar proveedores por nombre en el futuro
    // Supplier findByNameIgnoreCase(String name);
}