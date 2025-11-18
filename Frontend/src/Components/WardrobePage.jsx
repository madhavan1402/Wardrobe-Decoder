import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './WardrobePage.css'; // Optional, for styling

const WardrobePage = () => {
  const [recommendations, setRecommendations] = useState([]);
  const [loading, setLoading] = useState(false);
  const userId = 1; // Replace with logged-in user's ID

  // Fetch recommendations when component mounts
  useEffect(() => {
    fetchRecommendations();
  }, []);

  // Fetch existing recommendations
  const fetchRecommendations = async () => {
    try {
      setLoading(true);
      const response = await axios.get(
        `http://localhost:8080/api/recommendations/user/${userId}`
      );
      setRecommendations(response.data);
      setLoading(false);
    } catch (error) {
      console.error('Error fetching recommendations:', error);
      setLoading(false);
    }
  };

  // Generate a new recommendation using Gemini API
  const generateRecommendation = async () => {
    try {
      setLoading(true);
      const outfitPreferences = 'casual, summer'; // Example input
      const response = await axios.post(
        `http://localhost:8080/api/recommendations/user/${userId}`,
        null,
        { params: { outfitPreferences } }
      );
      // Add new recommendation to state
      setRecommendations((prev) => [...prev, response.data]);
      setLoading(false);
    } catch (error) {
      console.error('Error generating recommendation:', error);
      setLoading(false);
    }
  };

  return (
    <div className="wardrobe-page">
      <h1>Wardrobe Recommendations</h1>

      <button className="generate-btn" onClick={generateRecommendation}>
        Generate Outfit
      </button>

      {loading && <p>Loading...</p>}

      <div className="recommendation-list">
        {recommendations.length === 0 && !loading ? (
          <p>No recommendations yet.</p>
        ) : (
          recommendations.map((rec) => (
            <div key={rec.id} className="recommendation-card">
              <p><strong>Outfit:</strong> {rec.outfit}</p>
              <p><strong>Color Palette:</strong> {rec.colorPalette}</p>
              <p><strong>Occasion:</strong> {rec.occasion}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default WardrobePage;
