import React, { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import formConfig from "./FormConfig";
import "./DressForm.css";

const DressForm = () => {
  const { gender } = useParams();
  const navigate = useNavigate();

  const genderKey = gender?.toLowerCase();
  const config = formConfig[genderKey];

  const [size, setSize] = useState("");
  const [dressType, setDressType] = useState(config?.dressTypes?.[0] || "");
  const [skinTone, setSkinTone] = useState(config?.skinTones?.[0] || "");
  const [occasion, setOccasion] = useState(config?.occasions?.[0] || "");
  const [heightCategory, setHeightCategory] = useState(config?.heightCategories?.[0] || "");
  const [weather, setWeather] = useState(config?.weathers?.[0] || "");
  const [vacationType, setVacationType] = useState(config?.vacationTypes?.[0] || "");
  const [stylePreference, setStylePreference] = useState(config?.stylePreferences?.[0] || "");

  if (!config) {
    return (
      <h2 style={{ textAlign: "center", marginTop: "50px", color: "#444" }}>
        🚫 Invalid Category Selected
      </h2>
    );
  }

  const handleSubmit = async () => {
    if (!size) {
      alert("⚠️ Please enter your size!");
      return;
    }

    const requestData = {
      gender: gender,
      skinTone: skinTone,
      heightCategory: heightCategory,
      weather: weather,
      occasion: occasion,
      vacationType: vacationType,
      stylePreference: stylePreference,
    };

    try {
      const response = await fetch("http://localhost:8081/api/recommendations/recommend", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
      });

      if (response.ok) {
        const data = await response.json();
        navigate("/results", { state: { recommendations: data } });
      } else {
        alert("❌ Failed to get recommendations. Please try again.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("❌ Network error. Please check your connection.");
    }
  };

  return (
    <div className="dressform">
      <div className="form-container">
        <h1>
          {gender.charAt(0).toUpperCase() + gender.slice(1)} Outfit Form
        </h1>

        {/* ✅ Size Input */}
        <div className="form-group">
          <label>📏 Size:</label>
          <input
            type="text"
            value={size}
            onChange={(e) => setSize(e.target.value)}
            placeholder="Enter size (S, M, L, XL)"
          />
        </div>

        {/* ✅ Dress Type */}
        <div className="form-group">
          <label>👔 Dress Type:</label>
          <select
            value={dressType}
            onChange={(e) => setDressType(e.target.value)}
          >
            <option value="" disabled>
              --Select a type--
            </option>

            {config.dressTypes.map((type, index) => (
              <option key={index} value={type}>
                {type}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Skin Tone */}
        <div className="form-group">
          <label>🎨 Skin Tone:</label>
          <select
            value={skinTone}
            onChange={(e) => setSkinTone(e.target.value)}
          >
            <option value="" disabled>
              --Select a tone--
            </option>

            {config.skinTones.map((tone, index) => (
              <option key={index} value={tone}>
                {tone}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Occasion */}
        <div className="form-group">
          <label>🎉 Occasion:</label>
          <select
            value={occasion}
            onChange={(e) => setOccasion(e.target.value)}
          >
            <option value="" disabled>
              --Select a occasion--
            </option>

            {config.occasions.map((occ, index) => (
              <option key={index} value={occ}>
                {occ}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Height Category */}
        <div className="form-group">
          <label>📏 Height Category:</label>
          <select
            value={heightCategory}
            onChange={(e) => setHeightCategory(e.target.value)}
          >
            <option value="" disabled>
              --Select height category--
            </option>

            {config.heightCategories.map((height, index) => (
              <option key={index} value={height}>
                {height}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Weather */}
        <div className="form-group">
          <label>🌤️ Weather:</label>
          <select
            value={weather}
            onChange={(e) => setWeather(e.target.value)}
          >
            <option value="" disabled>
              --Select weather--
            </option>

            {config.weathers.map((w, index) => (
              <option key={index} value={w}>
                {w}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Vacation Type */}
        <div className="form-group">
          <label>🏖️ Vacation Type:</label>
          <select
            value={vacationType}
            onChange={(e) => setVacationType(e.target.value)}
          >
            <option value="" disabled>
              --Select vacation type--
            </option>

            {config.vacationTypes.map((vac, index) => (
              <option key={index} value={vac}>
                {vac}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Style Preference */}
        <div className="form-group">
          <label>👗 Style Preference:</label>
          <select
            value={stylePreference}
            onChange={(e) => setStylePreference(e.target.value)}
          >
            <option value="" disabled>
              --Select style preference--
            </option>

            {config.stylePreferences.map((style, index) => (
              <option key={index} value={style}>
                {style}
              </option>
            ))}
          </select>
        </div>

        {/* ✅ Buttons */}
        <div className="button-group">
          <button className="back-btn" onClick={() => navigate(-1)}>
            ⬅ Back
          </button>

          <button className="submit-btn" onClick={handleSubmit}>
             Get Outfit
          </button>
        </div>
      </div>
    </div>
  );
};

export default DressForm;
