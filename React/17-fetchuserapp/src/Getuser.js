import React, { Component } from 'react';

export class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (err) {
      console.error(err);
      this.setState({ loading: false });
    }
  }

  render() {
    if (this.state.loading) {
      return <div style={{ padding: '20px' }}>Loading user data...</div>;
    }

    if (!this.state.user) {
      return <div style={{ padding: '20px' }}>Failed to load user.</div>;
    }

    const { name, picture } = this.state.user;

    return (
      <div style={{ textAlign: 'center', margin: '40px auto', width: '300px', padding: '20px', border: '1px solid #ccc', borderRadius: '12px' }}>
        <img src={picture.large} alt="User Avatar" style={{ borderRadius: '50%', marginBottom: '15px' }} />
        <h3>{name.title} {name.first} {name.last}</h3>
      </div>
    );
  }
}

export default Getuser;
