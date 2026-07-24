import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat Kohli", score: 85 },
    { name: "Rohit Sharma", score: 92 },
    { name: "KL Rahul", score: 65 },
    { name: "Shreyas Iyer", score: 45 },
    { name: "Rishabh Pant", score: 78 },
    { name: "Hardik Pandya", score: 62 },
    { name: "Ravindra Jadeja", score: 71 },
    { name: "R Ashwin", score: 55 },
    { name: "Jasprit Bumrah", score: 20 },
    { name: "Mohammed Shami", score: 15 },
    { name: "Kuldeep Yadav", score: 30 }
  ];

  const highScorers = players.filter((player) => player.score >= 70);
  const lowScorers = players.filter((player) => player.score < 70);

  return (
    <div style={{ padding: '20px' }}>
      <h3>List of All Players & Scores</h3>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name}: {p.score}</li>
        ))}
      </ul>
      <h4 style={{ color: 'red' }}>Players with Scores Below 70 (Filtered):</h4>
      <ul>
        {lowScorers.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
