import React from 'react';
import { useParams, Link } from 'react-router-dom';

const TrainerDetail = ({ trainers }) => {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.TrainerId === parseInt(id));

  if (!trainer) {
    return <div style={{ padding: '20px' }}>Trainer not found!</div>;
  }

  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '400px', margin: '20px' }}>
      <h3>Trainer Details - {trainer.Name}</h3>
      <p><strong>ID:</strong> {trainer.TrainerId}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Stream:</strong> {trainer.Technology}</p>
      <p><strong>Skills:</strong> {trainer.Skills}</p>
      <Link to="/trainers">Back to List</Link>
    </div>
  );
};

export default TrainerDetail;
