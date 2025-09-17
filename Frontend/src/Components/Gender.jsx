import React from "react";
import { useNavigate } from "react-router-dom";
import "./Gender.css";

const Gender = () => {
  const navigate = useNavigate();

  return (
    <div className="gender-page">
      <h1 className="gender-title">Select Your Category</h1>
      <p className="gender-subtitle">Choose the style journey tailored for you</p>
      
      <div className="gender-buttons">
        <button onClick={() => navigate("/DressForm/male")} className="male-btn">
          👔 Male
        </button>
        <button onClick={() => navigate("/DressForm/female")} className="female-btn">
          👗 Female
        </button>
      </div>
    </div>
  );
};

export default Gender;
