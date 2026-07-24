import React from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = ({ Name, School, Total, Goal }) => {
  const average = (Total / Goal * 100).toFixed(2);

  return (
    <div className="score-card">
      <h2>Student Score Details</h2>
      <div className="score-details">
        <p><strong>Name:</strong> {Name}</p>
        <p><strong>School:</strong> {School}</p>
        <p><strong>Total Marks Scored:</strong> {Total}</p>
        <p><strong>Total Goal Marks:</strong> {Goal}</p>
        <p><strong>Average Percentage:</strong> <span className="score-highlight">{average}%</span></p>
      </div>
    </div>
  );
};

export default CalculateScore;
