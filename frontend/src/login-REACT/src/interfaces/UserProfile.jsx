import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/userprofile/UserProfilePC.css';

function UserProfile() {
  const [userData, setUserData] = useState({
    idUsuario: null,
    username: '',
    rol: '',
    status: ''
  });
  
  const navigate = useNavigate();

  useEffect(() => {
    // Recupera los datos del localStorage
    const idUsuario = localStorage.getItem('idUsuario');
    const username = localStorage.getItem('username');
    const rol = localStorage.getItem('rol');
    const status = localStorage.getItem('status');

    // Actualiza el estado con los datos recuperados
    if (idUsuario && username && rol && status) {
      setUserData({ idUsuario, username, rol, status });
    }
  }, []);

  const handleLogout = async () => {
    // Realiza la solicitud de cierre de sesión al backend
    const data = {
      userId: userData.idUsuario // Envía el ID del usuario
    };

    try {
      const response = await fetch('https://x2tp78xr-8080.brs.devtunnels.ms/api/auth/logout', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });

      if (response.ok) {
        // Elimina los datos del localStorage y redirige al inicio
        localStorage.clear();
        navigate('/');
      } else {
        const errorResponse = await response.json();
        console.error('Error al cerrar sesión:', errorResponse);
      }
    } catch (error) {
      console.error('Error de red:', error);
    }
  };

  return (
    <div className="user-profile">
      <div className="container">
        <h2>Perfil de Usuario</h2>
        <p><strong>ID Usuario:</strong> {userData.idUsuario}</p>
        <p><strong>Nombre de Usuario:</strong> {userData.username}</p>
        <p><strong>Rol:</strong> {userData.rol}</p>
        <p><strong>Estado:</strong> {userData.status}</p>
        <button className="logout-button" onClick={handleLogout}>
          Cerrar Sesión
        </button>
      </div>
    </div>
  );
}

export default UserProfile;
