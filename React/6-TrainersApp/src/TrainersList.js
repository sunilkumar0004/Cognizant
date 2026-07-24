import React from 'react';
import { Link } from 'react-router-dom';

const TrainersList = ({ trainers }) => (
  <div style={{ padding: '20px' }}>
    <h3>Trainers List</h3>
    <ul>
      {trainers.map((t) => (
        <li key={t.TrainerId} style={{ margin: '10px 0' }}>
          <Link to={`/trainer/${t.TrainerId}`} style={{ fontSize: '18px', textDecoration: 'none', color: '#0066cc' }}>
            {t.Name} ({t.Technology})
          </Link>
        </li>
      ))}
    </ul>
  </div>
);

export default TrainersList;
