import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Flight Ticket Booking Portal</h2>
      <div style={{ marginBottom: '20px' }}>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)} style={{ padding: '8px 16px', backgroundColor: '#f44336', color: 'white', border: 'none', borderRadius: '4px' }}>
            Logout
          </button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)} style={{ padding: '8px 16px', backgroundColor: '#2196F3', color: 'white', border: 'none', borderRadius: '4px' }}>
            Login
          </button>
        )}
      </div>

      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
