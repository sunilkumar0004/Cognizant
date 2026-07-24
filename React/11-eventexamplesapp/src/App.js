import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [counter, setCounter] = useState(0);

  const sayHello = () => {
    alert("Hello! Welcome to React Event Handling session.");
  };

  const handleIncrement = () => {
    setCounter((prev) => prev + 1);
    sayHello();
  };

  const handleDecrement = () => {
    setCounter((prev) => prev - 1);
  };

  const sayWelcome = (msg) => {
    alert("Message: " + msg);
  };

  const handlePressSynthetic = (e) => {
    alert("I was clicked! Synthetic Event Type: " + e.type);
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Event Handling Examples</h2>
      
      <div style={{ marginBottom: '20px' }}>
        <h3>Counter: {counter}</h3>
        <button onClick={handleIncrement} style={{ marginRight: '10px', padding: '8px 15px' }}>Increment & Say Hello</button>
        <button onClick={handleDecrement} style={{ padding: '8px 15px' }}>Decrement</button>
      </div>

      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => sayWelcome("welcome")} style={{ padding: '8px 15px' }}>Say Welcome</button>
      </div>

      <div style={{ marginBottom: '20px' }}>
        <button onClick={handlePressSynthetic} style={{ padding: '8px 15px', backgroundColor: '#008CBA', color: 'white', border: 'none' }}>
          OnPress Synthetic Event
        </button>
      </div>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
