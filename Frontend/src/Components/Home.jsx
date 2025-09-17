import React from "react";
import "./Home.css";
import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div className="log">
        <button
          className="login-button"
          onClick={() => navigate("/Login")}
        >
          Login / Sign Up
        </button>
      </div>

      <div className="home">
        <h1>Welcome to Wardrobe Decoder</h1>
        <p>Find the perfect outfit for any occasion!</p>
        <button
          className="start-button"
          onClick={() => navigate("/Gender")}
        >
          Start Now
        </button>
      </div>
    </div>
  );
};

export default Home;
