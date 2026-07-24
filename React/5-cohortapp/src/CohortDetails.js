import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  const titleColor = cohort.status === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: titleColor }}>{cohort.code}</h3>
      <dl>
        <dt>Course Name:</dt>
        <dd>{cohort.courseName}</dd>
        <dt>Start Date:</dt>
        <dd>{cohort.startDate}</dd>
        <dt>Status:</dt>
        <dd>{cohort.status}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
