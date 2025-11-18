package com.wardrobedecoder.backend.Service;

import com.wardrobedecoder.backend.Entity.ClothesEntity;
import com.wardrobedecoder.backend.Repo.ClothesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepo clothesRepo;

    // Get all clothes
    public List<ClothesEntity> getAllClothes() {
        return clothesRepo.findAll();
    }

    // Get clothes by ID
    public Optional<ClothesEntity> getClothesById(Long id) {
        return clothesRepo.findById(id);
    }

    // Add clothes
    public ClothesEntity addClothes(ClothesEntity clothes) {
        return clothesRepo.save(clothes);
    }

    // Update clothes
    public ClothesEntity updateClothes(Long id, ClothesEntity updatedClothes) {
        return clothesRepo.findById(id).map(clothes -> {
            clothes.setType(updatedClothes.getType());
            clothes.setColor(updatedClothes.getColor());
            clothes.setPattern(updatedClothes.getPattern());
            clothes.setSize(updatedClothes.getSize());
            clothes.setMaterial(updatedClothes.getMaterial());
            return clothesRepo.save(clothes);
        }).orElseGet(() -> {
            updatedClothes.setId(id);
            return clothesRepo.save(updatedClothes);
        });
    }

    // Delete clothes
    public void deleteClothes(Long id) {
        clothesRepo.deleteById(id);
    }

    // Filters
    public List<ClothesEntity> findByType(String type) {
        return clothesRepo.findByType(type);
    }

    public List<ClothesEntity> findByColor(String color) {
        return clothesRepo.findByColor(color);
    }

    public List<ClothesEntity> findBySize(String size) {
        return clothesRepo.findBySize(size);
    }

    public List<ClothesEntity> findByMaterial(String material) {
        return clothesRepo.findByMaterial(material);
    }
}
