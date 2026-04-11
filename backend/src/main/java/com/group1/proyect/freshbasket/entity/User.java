package com.group1.proyect.freshbasket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // En un futuro real esto se encripta

    @Column(length = 20)
    private String role;

    // Relación 1:N: Un usuario hace muchas entradas
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore 
    private List<Entry> entries = new ArrayList<>();

    // Relación 1:N: Un usuario hace muchas salidas
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore 
    private List<Exit> exits = new ArrayList<>();

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public List<Entry> getEntries() { return entries; }
    public void setEntries(List<Entry> entries) { this.entries = entries; }
    public List<Exit> getExits() { return exits; }
    public void setExits(List<Exit> exits) { this.exits = exits; }
}