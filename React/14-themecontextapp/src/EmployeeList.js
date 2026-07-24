import React from 'react';
import EmployeeCard from './EmployeeCard';

const EmployeeList = ({ employees }) => (
  <div>
    <h3>Employee Directory</h3>
    {employees.map((emp) => (
      <EmployeeCard key={emp.id} employee={emp} />
    ))}
  </div>
);

export default EmployeeList;
