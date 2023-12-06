import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';



const Login = ({ onLogin }) => {
    const navigate = useNavigate();

    const handleSubmit = (e) => {
      e.preventDefault();
      const username = e.target.username.value;
      const password = e.target.password.value;
  
      if (username === 'admin123' && password === 'admin123') {
        onLogin(true, 'admin');
        navigate('/admin');
      } else if (username === 'attendant123' && password === 'attendant123') {
        onLogin(true, 'attendant');
        navigate('/attendant');
      }
      else {
        navigate('/');
    }
    };
  
    return (
      <form onSubmit={handleSubmit}>
        <input type="text" name="username" placeholder="Username" />
        <input type="password" name="password" placeholder="Password" />
        <button type="submit">Login</button>
      </form>
    );
  };
  
  export default Login;
  