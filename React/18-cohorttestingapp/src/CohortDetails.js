import React from 'react';

const CohortDetails = ({ cohort }) => {
  if (!cohort) return null;
  return (
    <div className="cohort-box">
      <h3>{cohort.code}</h3>
      <p>{cohort.name}</p>
      <p>Status: {cohort.status}</p>
    </div>
  );
};

export default CohortDetails;
