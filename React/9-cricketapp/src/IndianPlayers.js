import React from 'react';

const IndianPlayers = () => {
  const team = ["Virat Kohli", "Rohit Sharma", "KL Rahul", "Shreyas Iyer", "Rishabh Pant", "Hardik Pandya"];
  
  // Destructuring Odd and Even indexed players
  const [p1, p2, p3, p4, p5, p6] = team;
  const oddTeam = [p1, p3, p5];
  const evenTeam = [p2, p4, p6];

  // Merging arrays
  const T20players = ["Suryakumar", "Ishan Kishan"];
  const RanjiTrophy = ["Sarfaraz Khan", "Abhimanyu Easwaran"];
  const mergedSquad = [...T20players, ...RanjiTrophy];

  return (
    <div style={{ padding: '20px' }}>
      <h3>Odd Team Players:</h3>
      <ul>{oddTeam.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h3>Even Team Players:</h3>
      <ul>{evenTeam.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h3>Merged Squad (T20 + Ranji):</h3>
      <ul>{mergedSquad.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
