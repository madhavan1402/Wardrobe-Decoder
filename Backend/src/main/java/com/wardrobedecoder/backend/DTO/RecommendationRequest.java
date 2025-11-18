package com.wardrobedecoder.backend.DTO;

public class RecommendationRequest {
    private String gender;
    private String skinTone;
    private String heightCategory;
    private String weather;
    private String occasion;
    private String vacationType;
    private String stylePreference;

    // Default constructor
    public RecommendationRequest() {}

    // Parameterized constructor
    public RecommendationRequest(String gender, String skinTone, String heightCategory, String weather, String occasion, String vacationType, String stylePreference) {
        this.gender = gender;
        this.skinTone = skinTone;
        this.heightCategory = heightCategory;
        this.weather = weather;
        this.occasion = occasion;
        this.vacationType = vacationType;
        this.stylePreference = stylePreference;
    }

    // Getters and Setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkinTone() {
        return skinTone;
    }

    public void setSkinTone(String skinTone) {
        this.skinTone = skinTone;
    }

    public String getHeightCategory() {
        return heightCategory;
    }

    public void setHeightCategory(String heightCategory) {
        this.heightCategory = heightCategory;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getStylePreference() {
        return stylePreference;
    }

    public void setStylePreference(String stylePreference) {
        this.stylePreference = stylePreference;
    }
}
