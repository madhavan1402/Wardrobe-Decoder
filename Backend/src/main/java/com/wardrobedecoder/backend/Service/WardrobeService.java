package com.wardrobedecoder.backend.Service;

import com.wardrobedecoder.backend.Entity.ClothesEntity;
import com.wardrobedecoder.backend.Entity.WardrobeEntity;
import com.wardrobedecoder.backend.Repo.WardrobeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardrobeService {

    @Autowired
    private WardrobeRepo wardrobeRepo;

    // Get all wardrobes
    public List<WardrobeEntity> getAllWardrobes() {
        return wardrobeRepo.findAll();
    }

    // Get wardrobe by ID
    public Optional<WardrobeEntity> getWardrobeById(Long id) {
        return wardrobeRepo.findById(id);
    }

    // Add wardrobe
    public WardrobeEntity addWardrobe(WardrobeEntity wardrobe) {
        return wardrobeRepo.save(wardrobe);
    }

    // Update wardrobe
    public WardrobeEntity updateWardrobe(Long id, WardrobeEntity updatedWardrobe) {
        return wardrobeRepo.findById(id).map(wardrobe -> {
            wardrobe.setOwnerName(updatedWardrobe.getOwnerName());
            wardrobe.setLocation(updatedWardrobe.getLocation());
            wardrobe.setClothes(updatedWardrobe.getClothes());
            return wardrobeRepo.save(wardrobe);
        }).orElseGet(() -> {
            updatedWardrobe.setId(id);
            return wardrobeRepo.save(updatedWardrobe);
        });
    }

    // Delete wardrobe
    public void deleteWardrobe(Long id) {
        wardrobeRepo.deleteById(id);
    }

    // Add clothes to wardrobe
    public WardrobeEntity addClothesToWardrobe(Long wardrobeId, ClothesEntity clothes) {
        return wardrobeRepo.findById(wardrobeId).map(wardrobe -> {
            wardrobe.getClothes().add(clothes);
            return wardrobeRepo.save(wardrobe);
        }).orElseThrow(() -> new RuntimeException("Wardrobe not found"));
    }
}
