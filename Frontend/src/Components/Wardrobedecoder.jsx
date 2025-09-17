import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';


const WardrobeDecoder = () => {
  const [size, setSize] = useState('');
  const [skinTone, setSkinTone] = useState('');
  const [occasion, setOccasion] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!size || !skinTone || !occasion) {
      alert("⚠️ Please fill all fields!");
      return;
    }
    navigate('/results', { state: { size, skinTone, occasion } });
  };

  return (
    <div className="decoder-container">
      <div className="decoder-form-wrapper">
        <h2>Find Your Perfect Look</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <input
              type="text"
              value={size}
              onChange={(e) => setSize(e.target.value)}
              required
            />
            <label>📏 Size</label>
          </div>

          <div className="form-group">
            <select
              value={skinTone}
              onChange={(e) => setSkinTone(e.target.value)}
              required
            >
              <option value="" disabled>Select Skin Tone</option>
              <option value="Fair / Light Skin Tone">Fair / Light Skin Tone</option>
              <option value="Medium Skin Tone">Medium Skin Tone</option>
              <option value="Olive Skin Tone">Olive Skin Tone</option>
              <option value="Brown Skin Tone">Brown Skin Tone</option>
              <option value="Dark / Deep Skin Tone">Dark / Deep Skin Tone</option>
            </select>
            <label>🎨 Skin Tone</label>
          </div>

          <div className="form-group">
            <select
              value={occasion}
              onChange={(e) => setOccasion(e.target.value)}
              required
            >
              <option value="" disabled>Select Occasion</option>
              <option value="Vacation">Vacation</option>
              <option value="Wedding">Wedding</option>
              <option value="Interview">Interview</option>
              <option value="Casual">Casual</option>
            </select>
            <label>🎉 Occasion</label>
          </div>

          <button type="submit" className="submit-btn">
            ✅ Get Outfit Suggestions
          </button>
        </form>
      </div>
    </div>
  );
};

export default WardrobeDecoder;
