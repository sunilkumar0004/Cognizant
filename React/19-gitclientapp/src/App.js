import React, { useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [username, setUsername] = useState('techiesyed');
  const [repos, setRepos] = useState([]);
  const [loading, setLoading] = useState(false);

  const fetchRepos = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const data = await GitClient.getRepositories(username);
      setRepos(data);
    } catch (err) {
      console.error(err);
      alert('Error fetching repositories');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>GitHub Client App</h2>
      <form onSubmit={fetchRepos} style={{ marginBottom: '20px' }}>
        <input 
          type="text" 
          value={username} 
          onChange={(e) => setUsername(e.target.value)} 
          style={{ padding: '8px', width: '250px' }}
        />
        <button type="submit" style={{ padding: '8px 15px', marginLeft: '10px' }}>Fetch Repositories</button>
      </form>

      {loading ? (
        <p>Loading repositories...</p>
      ) : (
        <ul>
          {repos.map((repo, idx) => (
            <li key={idx}>{repo}</li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
