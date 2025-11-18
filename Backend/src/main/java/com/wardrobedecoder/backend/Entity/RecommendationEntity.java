package com.wardrobedecoder.backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recommendations")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // e.g., "Casual Summer Look"
    private String description;  // e.g., "Light shirt with shorts for summer"

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recommendation_id")
    private List<ClothesEntity> clothes;  // List of clothes for this recommendation

    public RecommendationEntity() {
    }

    public RecommendationEntity(String title, String description, List<ClothesEntity> clothes) {
        this.title = title;
        this.description = description;
        this.clothes = clothes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClothesEntity> getClothes() {
        return clothes;
    }

    public void setClothes(List<ClothesEntity> clothes) {
        this.clothes = clothes;
    }
}
