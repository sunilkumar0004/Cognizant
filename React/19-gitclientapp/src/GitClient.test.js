import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyRepos = [
      { name: 'repo-one' },
      { name: 'repo-two' },
      { name: 'react-hands-on' }
    ];
    axios.get.mockResolvedValue({ data: dummyRepos });

    const repos = await GitClient.getRepositories('techiesyed');

    expect(repos).toEqual(['repo-one', 'repo-two', 'react-hands-on']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
