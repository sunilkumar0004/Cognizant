import React, { Component } from 'react';

export class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', margin: '40px auto', width: '350px', padding: '20px', border: '2px solid #008CBA', borderRadius: '10px' }}>
        <h2>Mall Visitor Counter</h2>
        <div style={{ margin: '20px 0', fontSize: '18px' }}>
          <p>People Entered: <strong>{this.state.entrycount}</strong></p>
          <button 
            onClick={this.UpdateEntry} 
            style={{ padding: '10px 20px', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer', margin: '5px' }}>
            Login
          </button>
        </div>
        <div style={{ margin: '20px 0', fontSize: '18px' }}>
          <p>People Exited: <strong>{this.state.exitcount}</strong></p>
          <button 
            onClick={this.UpdateExit} 
            style={{ padding: '10px 20px', backgroundColor: '#f44336', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer', margin: '5px' }}>
            Exit
          </button>
        </div>
      </div>
    );
  }
}

export default CountPeople;
