import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h2>Cricket Dashboard</h2>
      <button 
        onClick={() => setFlag(!flag)} 
        style={{ padding: '10px 15px', backgroundColor: '#008CBA', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}>
        Toggle View (Current Flag: {flag ? 'true' : 'false'})
      </button>

      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
