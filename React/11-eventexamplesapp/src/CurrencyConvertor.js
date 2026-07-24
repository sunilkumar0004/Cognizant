import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const result = (parseFloat(rupees) / 90).toFixed(2);
    setEuros(result);
  };

  return (
    <div style={{ marginTop: '30px', padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '350px' }}>
      <h3>Currency Converter (INR to EUR)</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Amount in INR: </label>
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)} 
            required 
            style={{ padding: '5px', marginLeft: '5px' }}
          />
        </div>
        <button type="submit" style={{ padding: '8px 15px', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '4px' }}>
          Convert
        </button>
      </form>
      {euros !== null && (
        <h4 style={{ color: 'green', marginTop: '15px' }}>Converted Amount: €{euros}</h4>
      )}
    </div>
  );
};

export default CurrencyConvertor;
