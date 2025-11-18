package com.wardrobedecoder.backend.Service;

import com.wardrobedecoder.backend.DTO.RecommendationRequest;
import com.wardrobedecoder.backend.Entity.RecommendationEntity;
import com.wardrobedecoder.backend.Repo.RecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepo recommendationRepository;

    // Get all recommendations
    public List<RecommendationEntity> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    // Get recommendation by ID
    public RecommendationEntity getRecommendationById(Long id) {
        Optional<RecommendationEntity> recommendation = recommendationRepository.findById(id);
        return recommendation.orElse(null);
    }

    // Save a new recommendation
    public RecommendationEntity saveRecommendation(RecommendationEntity recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Update existing recommendation
    public RecommendationEntity updateRecommendation(Long id, RecommendationEntity updatedRecommendation) {
        return recommendationRepository.findById(id).map(recommendation -> {
            recommendation.setTitle(updatedRecommendation.getTitle());
            recommendation.setDescription(updatedRecommendation.getDescription());
            recommendation.setClothes(updatedRecommendation.getClothes());
            return recommendationRepository.save(recommendation);
        }).orElse(null);
    }

    // Delete recommendation
    public void deleteRecommendation(Long id) {
        recommendationRepository.deleteById(id);
    }

    // New recommendation logic
    public List<Map<String, Object>> recommend(RecommendationRequest request) {
        List<Map<String, Object>> recommendations = new ArrayList<>();

        // Define color palettes based on skin tone
        Map<String, List<String>> skinToneColors = Map.of(
            "fair", Arrays.asList("pastel", "blues", "maroon"),
            "wheatish", Arrays.asList("olive", "navy", "beige"),
            "dark", Arrays.asList("mustard", "white", "green")
        );

        // Define styles based on height
        Map<String, String> heightStyles = Map.of(
            "short", "vertical stripes, high-waist",
            "medium", "neutral suggestions",
            "tall", "layering, avoid vertical stripes"
        );

        // Define vacation types
        Map<String, Map<String, String>> vacationOutfits = Map.of(
            "beach", Map.of("top", "floral shirts", "bottom", "shorts", "footwear", "sandals"),
            "mountains", Map.of("top", "hoodies", "bottom", "jackets", "footwear", "boots"),
            "desert", Map.of("top", "light cotton", "bottom", "full-sleeves", "footwear", "sneakers"),
            "city", Map.of("top", "tees", "bottom", "jeans", "footwear", "casual shoes"),
            "adventure", Map.of("top", "sportswear", "bottom", "cargos", "footwear", "hiking boots")
        );

        // Define weather types
        Map<String, Map<String, String>> weatherOutfits = Map.of(
            "summer", Map.of("top", "cotton shirts", "bottom", "light pants", "footwear", "sandals"),
            "winter", Map.of("top", "sweaters", "bottom", "jackets", "footwear", "boots"),
            "rainy", Map.of("top", "waterproof jackets", "bottom", "rain pants", "footwear", "rain boots")
        );

        // Define occasion types
        Map<String, Map<String, String>> occasionOutfits = Map.of(
            "office", Map.of("top", "formal shirts", "bottom", "trousers", "footwear", "formal shoes"),
            "party", Map.of("top", "bright fitted wear", "bottom", "stylish pants", "footwear", "heels"),
            "traditional", Map.of("top", "ethnic wear", "bottom", "traditional bottoms", "footwear", "traditional shoes")
        );

        // Get user preferences
        String gender = request.getGender().toLowerCase();
        String skinTone = request.getSkinTone().toLowerCase();
        String height = request.getHeightCategory().toLowerCase();
        String weather = request.getWeather().toLowerCase();
        String occasion = request.getOccasion().toLowerCase();
        String vacation = request.getVacationType().toLowerCase();
        String style = request.getStylePreference().toLowerCase();

        // Generate 5 recommendations
        for (int i = 1; i <= 5; i++) {
            Map<String, Object> outfit = new HashMap<>();

            // Base on vacation type
            Map<String, String> vacOutfit = vacationOutfits.getOrDefault(vacation, vacationOutfits.get("city"));
            Map<String, String> weaOutfit = weatherOutfits.getOrDefault(weather, weatherOutfits.get("summer"));
            Map<String, String> occOutfit = occasionOutfits.getOrDefault(occasion, occasionOutfits.get("office"));

            // Combine elements
            String topWear = vacOutfit.get("top") + " with " + weaOutfit.get("top") + " and " + occOutfit.get("top");
            String bottomWear = vacOutfit.get("bottom") + " with " + weaOutfit.get("bottom") + " and " + occOutfit.get("bottom");
            String footwear = vacOutfit.get("footwear") + " or " + weaOutfit.get("footwear") + " or " + occOutfit.get("footwear");
            String accessories = "Watch, belt, sunglasses";

            // Colors based on skin tone
            List<String> colors = skinToneColors.getOrDefault(skinTone, Arrays.asList("neutral"));

            // Explanation
            String explanation = "This outfit is recommended for " + gender + " with " + skinTone + " skin tone, " + height + " height, " +
                weather + " weather, " + occasion + " occasion, and " + vacation + " vacation. " +
                "Colors chosen: " + String.join(", ", colors) + ". " +
                "Style tips: " + heightStyles.getOrDefault(height, "balanced look") + ".";

            outfit.put("topWear", topWear);
            outfit.put("bottomWear", bottomWear);
            outfit.put("footwear", footwear);
            outfit.put("accessories", accessories);
            outfit.put("colors", colors);
            outfit.put("explanation", explanation);

            recommendations.add(outfit);
        }

        return recommendations;
    }
}
