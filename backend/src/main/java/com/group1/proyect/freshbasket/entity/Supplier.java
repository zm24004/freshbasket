package com.group1.proyect.freshbasket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 15)
    private String phone;

    @Column(length = 100)
    private String email;

    // Relación 1:N: Un proveedor tiene muchos productos
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    @JsonIgnore 
    private List<Product> products = new ArrayList<>();

    // Relación 1:N: Un proveedor tiene muchas entradas
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    @JsonIgnore 
    private List<Entry> entries = new ArrayList<>();

    public Supplier() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    public List<Entry> getEntries() { return entries; }
    public void setEntries(List<Entry> entries) { this.entries = entries; }
}
