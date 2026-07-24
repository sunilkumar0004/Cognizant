import React, { Component } from 'react';

export class Cart extends Component {
  render() {
    const { items } = this.props;
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h3>Shopping Cart Items</h3>
        <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%', maxWidth: '400px' }}>
          <thead>
            <tr style={{ backgroundColor: '#f2f2f2' }}>
              <th>Item Name</th>
              <th>Price (₹)</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <tr key={index}>
                <td>{item.Itemname}</td>
                <td>{item.Price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Cart;
