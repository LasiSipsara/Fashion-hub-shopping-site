import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginForm from "./Components/LoginForm";
import "bootstrap/dist/css/bootstrap.min.css";
import RegsitrationForm from "./Components/RegsitrationForm";
import { FaUser } from "react-icons/fa";
import Home from "./Components/Home";


function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginForm />}></Route>
          <Route path="/register" element={<RegsitrationForm />}></Route>
          <Route path="/forgotpassword" element={<LoginForm />}></Route>
          <Route path="/home" element={<Home />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
