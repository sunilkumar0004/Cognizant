import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeeList from './EmployeeList';

function App() {
  const [theme, setTheme] = useState('light');

  const employees = [
    { id: 1, name: 'Alice Smith', role: 'Software Engineer' },
    { id: 2, name: 'Bob Johnson', role: 'Technical Lead' }
  ];

  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h2>Employee Management Portal</h2>
        <button onClick={toggleTheme} style={{ marginBottom: '20px', padding: '8px 15px' }}>
          Toggle Theme (Current: {theme})
        </button>
        <EmployeeList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
