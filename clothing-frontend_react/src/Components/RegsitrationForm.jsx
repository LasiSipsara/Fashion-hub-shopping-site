import React, { useState } from "react";
import "./Register.css";
import { useNavigate } from "react-router-dom";

import axios from "axios";

const RegistrationForm = () => {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    firstname: "",
    lastname: "",
    email: "",
    password: "",
    address: "",
    city: "",
    postalcode: "",
  });

  const { firstname, lastname, email, password, address, city, postalcode } =
    user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    try {
      // Check if the email already exists in the database
      const checkEmailResponse = await axios.get(
        `http://localhost:8080/user/check-email/${user.email}`
      );

      if (checkEmailResponse.data.exists) {
        // If email exists, show an alert and prevent further registration
        alert("Email already exists. Please use a different email.");
        navigate("/register");
      } else {
        // If email doesn't exist, proceed with registration
        await axios.post("http://localhost:8080/user", user);
       
        navigate("/home");
      }
    } catch (error) {
      console.error("Error submitting data:", error);
      alert("Registration failed. Please check your details and try again.");
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <h2 className="text-center">Sign In</h2>
            <div className="card-body">
              <form onSubmit={(e) => onSubmit(e)}>
                <div className="form-group">
                  <label>First name</label>
                  <input
                    type="text"
                    className="form-control"
                    placeholder="First Name"
                    name="firstname"
                    required
                    value={firstname}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    placeholder="Last Name"
                    name="lastname"
                    required
                    value={lastname}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>Email</label>
                  <input
                    type="email"
                    className="form-control"
                    placeholder="Email"
                    required
                    name="email"
                    value={email}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>Password</label>
                  <input
                    type="password"
                    required
                    className="form-control"
                    placeholder="Password"
                    name="password"
                    value={password}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>Address</label>
                  <input
                    type="text"
                    required
                    className="form-control"
                    placeholder="Address"
                    name="address"
                    value={address}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>City</label>
                  <input
                    type="text"
                    required
                    className="form-control"
                    placeholder="City"
                    name="city"
                    value={city}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label>Postal Code</label>
                  <input
                    required
                    type="text"
                    className="form-control"
                    placeholder="Postal Code"
                    name="postalcode"
                    value={postalcode}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RegistrationForm;
