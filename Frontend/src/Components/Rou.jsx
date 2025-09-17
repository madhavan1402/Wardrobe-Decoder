import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Home from './Home';
import Gender from './Gender';
import DressForm from './DressForm';

const Rou = () => {
  return (
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/Gender" element={<Gender />} />
        {/* ✅ Dynamic gender route */}
        <Route path="/DressForm/:gender" element={<DressForm />} />
        <Route path="/Login" element={<Login />} />
      </Routes>
  );
};

export default Rou;
