import React, { useState } from 'react';

const ComplaintRegister = () => {
  const [empName, setEmpName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const refNo = "REF-" + Math.floor(10000 + Math.random() * 90000);
    alert(`Thanks ${empName}! Your complaint has been submitted successfully.\nReference No: ${refNo}`);
    setEmpName('');
    setComplaint('');
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', border: '1px solid #ccc', borderRadius: '8px', margin: '20px' }}>
      <h3>Register a Complaint</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '15px' }}>
          <label>Employee Name:</label><br />
          <input 
            type="text" 
            value={empName} 
            onChange={(e) => setEmpName(e.target.value)} 
            required 
            style={{ width: '100%', padding: '8px', marginTop: '5px' }}
          />
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label>Complaint Detail:</label><br />
          <textarea 
            value={complaint} 
            onChange={(e) => setComplaint(e.target.value)} 
            required 
            rows="4" 
            style={{ width: '100%', padding: '8px', marginTop: '5px' }}
          />
        </div>
        <button type="submit" style={{ padding: '10px 20px', backgroundColor: '#008CBA', color: 'white', border: 'none', borderRadius: '4px' }}>
          Submit Complaint
        </button>
      </form>
    </div>
  );
};

export default ComplaintRegister;
