package com.wardrobedecoder.backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clothes")
public class ClothesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;     // Shirt, Pant, Shoes
    private String color;    // Red, Blue
    private String pattern;  // Striped, Plain, Checkered
    private String size;     // S, M, L, XL
    private String material; // Cotton, Denim

    private LocalDateTime addedAt;

    // Default constructor
    public ClothesEntity() {
        this.addedAt = LocalDateTime.now();
    }

    // Parameterized constructor
    public ClothesEntity(String type, String color, String pattern, String size, String material) {
        this.type = type;
        this.color = color;
        this.pattern = pattern;
        this.size = size;
        this.material = material;
        this.addedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
}
