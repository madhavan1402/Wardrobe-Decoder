package com.wardrobedecoder.backend.Controller;

import com.wardrobedecoder.backend.DTO.RecommendationRequest;
import com.wardrobedecoder.backend.Entity.RecommendationEntity;
import com.wardrobedecoder.backend.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    // Get all recommendations
    @GetMapping
    public List<RecommendationEntity> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    // Get a recommendation by ID
    @GetMapping("/{id}")
    public RecommendationEntity getRecommendationById(@PathVariable Long id) {
        return recommendationService.getRecommendationById(id);
    }

    // Add a new recommendation
    @PostMapping
    public RecommendationEntity addRecommendation(@RequestBody RecommendationEntity recommendation) {
        return recommendationService.saveRecommendation(recommendation);
    }

    // Update an existing recommendation
    @PutMapping("/{id}")
    public RecommendationEntity updateRecommendation(@PathVariable Long id, @RequestBody RecommendationEntity recommendation) {
        return recommendationService.updateRecommendation(id, recommendation);
    }

    // Delete a recommendation
    @DeleteMapping("/{id}")
    public String deleteRecommendation(@PathVariable Long id) {
        recommendationService.deleteRecommendation(id);
        return "Recommendation with ID " + id + " deleted successfully!";
    }

    // New endpoint for recommendations
    @PostMapping("/recommend")
    public List<Map<String, Object>> getRecommendations(@RequestBody RecommendationRequest request) {
        return recommendationService.recommend(request);
    }
}
