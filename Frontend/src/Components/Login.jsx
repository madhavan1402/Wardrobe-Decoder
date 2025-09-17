import React, { useState } from "react";
import { FaUser, FaLock, FaEnvelope } from "react-icons/fa";
import { Link } from "react-router-dom";
import { IoIosHome } from "react-icons/io";
import "./Login.css";

const Login = () => {
  const [action, setAction] = useState("");

  const registerLink = (e) => {
    e.preventDefault();
    setAction("active");
  };

  const loginLink = (e) => {
    e.preventDefault();
    setAction("");
  };

  return (
    <div className="Login-Register">
      {/* Home Icon */}
      <Link to="/home">
        <IoIosHome className="Home-Icon" />
      </Link>

      {/* Wrapper for Login/Register */}
      <div className={`wrapper ${action}`}>
        {/* Login Box */}
        <div className="form-box login">
          <form>
            <h1>Login</h1>

            <div className="input-box">
              <input type="text" placeholder="Enter Username" required />
              <FaUser className="icon" />
            </div>

            <div className="input-box">
              <input type="password" placeholder="Enter Password" required />
              <FaLock className="icon" />
            </div>

            <div className="remember-forget">
              <label>
                <input type="checkbox" /> Remember Me
              </label>
              <a href="#">Forgot Password?</a>
            </div>

            <button type="submit" className="btn-primary">
              Login
            </button>

            <div className="register-link">
              <p>
                Don&apos;t have an account?{" "}
                <a href="#" onClick={registerLink}>
                  Register
                </a>
              </p>
            </div>
          </form>
        </div>

        {/* Register Box */}
        <div className="form-box register">
          <form>
            <h1>Register</h1>

            <div className="input-box">
              <input type="text" placeholder="Choose Username" required />
              <FaUser className="icon" />
            </div>

            <div className="input-box">
              <input type="email" placeholder="Enter Email" required />
              <FaEnvelope className="icon" />
            </div>

            <div className="input-box">
              <input type="password" placeholder="Create Password" required />
              <FaLock className="icon" />
            </div>

            <div className="remember-forget">
              <label>
                <input type="checkbox" required /> I agree to the Terms & Conditions
              </label>
            </div>

            <button type="submit" className="btn-primary">
              Register
            </button>

            <div className="register-link">
              <p>
                Already have an account?{" "}
                <a href="#" onClick={loginLink}>
                  Login
                </a>
              </p>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
