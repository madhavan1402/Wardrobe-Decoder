import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./Results.css";

const Results = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { recommendations } = location.state || { recommendations: [] };

  if (!recommendations || recommendations.length === 0) {
    return (
      <div className="results-container">
        <h2>No recommendations found.</h2>
        <button onClick={() => navigate(-1)}>Go Back</button>
      </div>
    );
  }

  return (
    <div className="results-container">
      <h1>🎉 Your Outfit Recommendations</h1>
      <div className="recommendations-grid">
        {recommendations.map((rec, index) => (
          <div key={index} className="recommendation-card">
            <h3>Outfit {index + 1}</h3>
            <div className="outfit-details">
              <p><strong>👕 Top Wear:</strong> {rec.topWear}</p>
              <p><strong>👖 Bottom Wear:</strong> {rec.bottomWear}</p>
              <p><strong>👟 Footwear:</strong> {rec.footwear}</p>
              <p><strong>👜 Accessories:</strong> {rec.accessories}</p>
              <p><strong>🎨 Colors:</strong> {Array.isArray(rec.colors) ? rec.colors.join(", ") : rec.colors}</p>
            </div>
            <div className="explanation">
              <p><strong>💡 Explanation:</strong> {rec.explanation}</p>
            </div>
          </div>
        ))}
      </div>
      <button className="back-btn" onClick={() => navigate(-1)}>⬅ Back to Form</button>
    </div>
  );
};

export default Results;
