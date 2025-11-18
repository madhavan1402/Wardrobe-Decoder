package com.wardrobedecoder.backend.Controller;

import com.wardrobedecoder.backend.Entity.ClothesEntity;
import com.wardrobedecoder.backend.Service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothes")
@CrossOrigin(origins = "http://localhost:3000") // React frontend
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    // Get all clothes
    @GetMapping
    public List<ClothesEntity> getAllClothes() {
        return clothesService.getAllClothes();
    }

    // Get clothes by ID
    @GetMapping("/{id}")
    public Optional<ClothesEntity> getClothesById(@PathVariable Long id) {
        return clothesService.getClothesById(id);
    }

    // Add clothes
    @PostMapping
    public ClothesEntity addClothes(@RequestBody ClothesEntity clothes) {
        return clothesService.addClothes(clothes);
    }

    // Update clothes
    @PutMapping("/{id}")
    public ClothesEntity updateClothes(@PathVariable Long id, @RequestBody ClothesEntity clothes) {
        return clothesService.updateClothes(id, clothes);
    }

    // Delete clothes
    @DeleteMapping("/{id}")
    public void deleteClothes(@PathVariable Long id) {
        clothesService.deleteClothes(id);
    }

    // Filters
    @GetMapping("/type/{type}")
    public List<ClothesEntity> getByType(@PathVariable String type) {
        return clothesService.findByType(type);
    }

    @GetMapping("/color/{color}")
    public List<ClothesEntity> getByColor(@PathVariable String color) {
        return clothesService.findByColor(color);
    }

    @GetMapping("/size/{size}")
    public List<ClothesEntity> getBySize(@PathVariable String size) {
        return clothesService.findBySize(size);
    }

    @GetMapping("/material/{material}")
    public List<ClothesEntity> getByMaterial(@PathVariable String material) {
        return clothesService.findByMaterial(material);
    }
}
