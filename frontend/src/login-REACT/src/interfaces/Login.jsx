import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import logo from '../logo.svg';
import '../styles/login/LoginPC.css';
import '../styles/login/LoginTablet.css';
import '../styles/login/LoginMobile.css';
import '../styles/login/LoginLaptop.css';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    const data = { username, password };

    try {
      const response = await fetch('https://x2tp78xr-8080.brs.devtunnels.ms/api/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });

      if (response.ok) {
        const jsonResponse = await response.json();
        localStorage.setItem('idUsuario', jsonResponse.idUsuario);
        localStorage.setItem('username', jsonResponse.username);
        localStorage.setItem('rol', jsonResponse.rol);
        localStorage.setItem('status', 'loggedOn');
        navigate('/user-profile');
      } else {
        const errorResponse = await response.json();
        console.error('Error:', errorResponse);
      }
    } catch (error) {
      console.error('Error de red:', error);
    }
  };

  return (
    <div className="login-wrapper"> {/* Nuevo div contenedor */}
      <div className="login-container">
        <div className="login-form-container">
          <img src={logo} alt="Logo" className="login-circular-image" />
          <h2>Iniciar Sesión</h2>
          <form onSubmit={handleSubmit} className="login-form">
            <input
              type="text"
              placeholder="Nombre de usuario"
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              className="login-input"
            />
            <input
              type="password"
              placeholder="Contraseña"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="login-input"
            />
            <button type="submit" className="login-button">Iniciar Sesión</button>
          </form>
        </div>
        <div className="login-image-container"></div>
      </div>
    </div>
  );
}

export default Login;
