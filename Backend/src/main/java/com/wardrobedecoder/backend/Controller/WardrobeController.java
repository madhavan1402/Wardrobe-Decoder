package com.wardrobedecoder.backend.Controller;

import com.wardrobedecoder.backend.Entity.ClothesEntity;
import com.wardrobedecoder.backend.Entity.WardrobeEntity;
import com.wardrobedecoder.backend.Service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wardrobes")
@CrossOrigin(origins = "http://localhost:3000")
public class WardrobeController {

    @Autowired
    private WardrobeService wardrobeService;

    // Get all wardrobes
    @GetMapping
    public List<WardrobeEntity> getAllWardrobes() {
        return wardrobeService.getAllWardrobes();
    }

    // Get wardrobe by ID
    @GetMapping("/{id}")
    public Optional<WardrobeEntity> getWardrobeById(@PathVariable Long id) {
        return wardrobeService.getWardrobeById(id);
    }

    // Add wardrobe
    @PostMapping
    public WardrobeEntity addWardrobe(@RequestBody WardrobeEntity wardrobe) {
        return wardrobeService.addWardrobe(wardrobe);
    }

    // Update wardrobe
    @PutMapping("/{id}")
    public WardrobeEntity updateWardrobe(@PathVariable Long id, @RequestBody WardrobeEntity wardrobe) {
        return wardrobeService.updateWardrobe(id, wardrobe);
    }

    // Delete wardrobe
    @DeleteMapping("/{id}")
    public void deleteWardrobe(@PathVariable Long id) {
        wardrobeService.deleteWardrobe(id);
    }

    // Add clothes to wardrobe
    @PostMapping("/{id}/clothes")
    public WardrobeEntity addClothesToWardrobe(@PathVariable Long id, @RequestBody ClothesEntity clothes) {
        return wardrobeService.addClothesToWardrobe(id, clothes);
    }
}
