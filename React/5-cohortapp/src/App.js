import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    { code: 'CH-2026-JAVA', courseName: 'Full Stack Java', startDate: '2026-01-10', status: 'ongoing' },
    { code: 'CH-2025-REACT', courseName: 'React Modern Development', startDate: '2025-11-01', status: 'completed' },
    { code: 'CH-2026-CLOUD', courseName: 'AWS & DevOps', startDate: '2026-03-15', status: 'ongoing' }
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h2>Cognizant Academy Cohort Dashboard</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
