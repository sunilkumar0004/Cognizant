import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext);

  const buttonStyle = theme === 'dark' 
    ? { backgroundColor: '#333', color: '#fff', padding: '8px 12px', border: 'none', borderRadius: '4px' }
    : { backgroundColor: '#e0e0e0', color: '#000', padding: '8px 12px', border: 'none', borderRadius: '4px' };

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', marginBottom: '10px' }}>
      <h4>{employee.name}</h4>
      <p>Designation: {employee.role}</p>
      <button style={buttonStyle}>View Profile ({theme} theme)</button>
    </div>
  );
};

export default EmployeeCard;
