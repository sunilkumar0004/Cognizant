import React from 'react';

const GuestPage = () => (
  <div style={{ padding: '20px', backgroundColor: '#e3f2fd', borderRadius: '8px' }}>
    <h3>Guest User Portal</h3>
    <p>Welcome Guest! You can browse available flight schedules below:</p>
    <ul>
      <li>Flight AI-101: Delhi to Mumbai - 10:00 AM</li>
      <li>Flight 6E-205: Bangalore to Chennai - 02:30 PM</li>
      <li>Flight UK-812: Hyderabad to Kolkata - 06:15 PM</li>
    </ul>
    <p style={{ fontStyle: 'italic', color: '#555' }}>* Please log in to book tickets.</p>
  </div>
);

export default GuestPage;
