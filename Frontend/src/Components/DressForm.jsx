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
  const [occasion, setOccasion] = useState(config?.occasions[0] || "");

  if (!config) {
    return (
      <h2 style={{ textAlign: "center", marginTop: "50px", color: "#444" }}>
        🚫 Invalid Category Selected
      </h2>
    );
  }

  const handleSubmit = () => {
    if (!size) {
      alert("⚠️ Please enter your size!");
      return;
    }
    alert(
      `👕 Outfit Selected for ${gender.toUpperCase()}:
       📏 Size: ${size}
       👔 Dress Type: ${dressType}
       🎨 Skin Tone: ${skinTone}
       🎉 Occasion: ${occasion}`
    );
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
