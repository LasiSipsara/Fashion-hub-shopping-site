import React, { useState } from "react";
import { Link } from "react-router-dom";
import { FaUser } from "react-icons/fa";
import { RiLockPasswordLine } from "react-icons/ri";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const LoginForm = () => {
  let navigate = useNavigate();
  const [user, setUser] = useState({
    email: "",
    password: "",
  });
  const [error, setError] = useState(null);

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    // Check for empty fields
    if (!user.email.trim()) {
      setError("Please enter your email.");
      return;
    }

    if (!user.password.trim()) {
      setError("Please enter your password.");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/login", user);

      if (response.status === 200 && response.data) {
        // Assuming your backend returns some data on successful login
        navigate("/home"); // Redirect to the desired page
      } else {
        setError("Invalid username or password");
      }
    } catch (error) {
      console.error("Error while sending data to the server:", error.response);
      setError("An error occurred. Please try again."); // Display a generic error message
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <h2 className="text-center">Login</h2>
            <div className="card-body">
              <form onSubmit={onSubmit} noValidate>
                <div className="form-group">
                  <FaUser />
                  <label>Email</label>
                  <input
                    type="email"
                    required
                    className="form-control"
                    placeholder="Enter email"
                    name="email"
                    value={user.email}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <RiLockPasswordLine />
                  <label>Password</label>
                  <input
                    type="password"
                    required
                    className="form-control"
                    placeholder="**********"
                    name="password"
                    value={user.password}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                {error && <div className="alert alert-danger">{error}</div>}

                <div className="text-center">
                  <button type="submit" className="btn btn-primary btn-block">
                    LogIn
                  </button>
                </div>
              </form>

              <p>
                Don't have an account?{" "}
                <Link to="/register">Click to register</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
