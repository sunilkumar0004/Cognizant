import React from 'react';

function App() {
  const heading = <h1>Office Space Rental Portal</h1>;
  const officeImage = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80";

  const singleOffice = {
    Name: "DBS Tech Park",
    Rent: 55000,
    Address: "DLF Cyber City, Hyderabad"
  };

  const officeList = [
    { Name: "Cognizant Tech Center", Rent: 75000, Address: "OMR, Chennai" },
    { Name: "Prestige Cyber Towers", Rent: 48000, Address: "Electronic City, Bangalore" },
    { Name: "Infinity Business Hub", Rent: 65000, Address: "Sector 5, Kolkata" },
    { Name: "Magarpatta City Office", Rent: 52000, Address: "Hadapsar, Pune" }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      {heading}
      <img src={officeImage} alt="Office Space" style={{ width: '300px', height: '200px', borderRadius: '10px' }} />
      
      <h3>Featured Office Details</h3>
      <p><strong>Name:</strong> {singleOffice.Name}</p>
      <p><strong>Address:</strong> {singleOffice.Address}</p>
      <p><strong>Rent:</strong> <span style={{ color: singleOffice.Rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>₹{singleOffice.Rent}</span></p>

      <h3>Available Office Spaces</h3>
      <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%', maxWidth: '600px' }}>
        <thead>
          <tr style={{ backgroundColor: '#e0e0e0' }}>
            <th>Office Name</th>
            <th>Address</th>
            <th>Rent (₹)</th>
          </tr>
        </thead>
        <tbody>
          {officeList.map((office, idx) => (
            <tr key={idx}>
              <td>{office.Name}</td>
              <td>{office.Address}</td>
              <td style={{ color: office.Rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
                ₹{office.Rent}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
