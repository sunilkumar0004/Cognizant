import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetails';
import { trainersData } from './TrainersMock';

function App() {
  return (
    <BrowserRouter>
      <nav style={{ backgroundColor: '#282c34', padding: '15px' }}>
        <Link to="/" style={{ color: 'white', marginRight: '20px', textDecoration: 'none' }}>Home</Link>
        <Link to="/trainers" style={{ color: 'white', textDecoration: 'none' }}>Trainers List</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList trainers={trainersData} />} />
        <Route path="/trainer/:id" element={<TrainerDetail trainers={trainersData} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
