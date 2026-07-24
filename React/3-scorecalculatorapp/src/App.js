import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name="Rahul Sharma" 
        School="St. Xavier High School" 
        Total={450} 
        Goal={500} 
      />
    </div>
  );
}

export default App;
