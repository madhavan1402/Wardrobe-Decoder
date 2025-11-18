package com.wardrobedecoder.backend.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wardrobes")
public class WardrobeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;   // e.g., Madhavan's Wardrobe
    private String location;    // e.g., Bedroom, PG room

    // One Wardrobe can have many Clothes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wardrobe_id")  // FK in clothes table
    private List<ClothesEntity> clothes = new ArrayList<>();

    // Constructors
    public WardrobeEntity() {}

    public WardrobeEntity(String ownerName, String location) {
        this.ownerName = ownerName;
        this.location = location;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<ClothesEntity> getClothes() { return clothes; }
    public void setClothes(List<ClothesEntity> clothes) { this.clothes = clothes; }
}
