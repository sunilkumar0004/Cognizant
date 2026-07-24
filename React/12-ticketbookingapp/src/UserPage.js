import React from 'react';

const UserPage = () => {
  const handleBook = (flight) => {
    alert(`Ticket successfully booked for ${flight}!`);
  };

  return (
    <div style={{ padding: '20px', backgroundColor: '#e8f5e9', borderRadius: '8px' }}>
      <h3>Logged-in User Booking Portal</h3>
      <p>Select your flight to complete ticket booking:</p>
      <ul>
        <li style={{ margin: '10px 0' }}>
          Flight AI-101 (Delhi -> Mumbai) 
          <button onClick={() => handleBook("AI-101")} style={{ marginLeft: '15px', padding: '5px 10px', backgroundColor: '#4CAF50', color: 'white', border: 'none' }}>Book Now</button>
        </li>
        <li style={{ margin: '10px 0' }}>
          Flight 6E-205 (Bangalore -> Chennai) 
          <button onClick={() => handleBook("6E-205")} style={{ marginLeft: '15px', padding: '5px 10px', backgroundColor: '#4CAF50', color: 'white', border: 'none' }}>Book Now</button>
        </li>
      </ul>
    </div>
  );
};

export default UserPage;
