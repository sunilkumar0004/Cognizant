import React, { Component } from 'react';
import Cart from './Cart';

export class OnlineShopping extends Component {
  render() {
    const CartItems = [
      { Itemname: "Laptop", Price: 55000 },
      { Itemname: "Smartphone", Price: 25000 },
      { Itemname: "Headphones", Price: 3000 },
      { Itemname: "Smartwatch", Price: 4500 },
      { Itemname: "Keyboard", Price: 1500 }
    ];

    return (
      <div>
        <h2>Welcome to Online Shopping Portal</h2>
        <Cart items={CartItems} />
      </div>
    );
  }
}

export default OnlineShopping;
