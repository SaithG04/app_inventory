import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './interfaces/Login';
import UserProfile from './interfaces/UserProfile';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/user-profile" element={<UserProfile />} />
        {/* Otras rutas pueden ir aquí */}
      </Routes>
    </Router>
  );
}

export default App;
