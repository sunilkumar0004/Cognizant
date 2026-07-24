import React, { useState } from 'react';

const Register = () => {
  const [formData, setFormData] = useState({ name: '', email: '', password: '' });
  const [errors, setErrors] = useState({});

  const validate = () => {
    const errs = {};
    if (formData.name.length < 5) {
      errs.name = 'Name should have at least 5 characters.';
    }
    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      errs.email = 'Email should contain @ and .';
    }
    if (formData.password.length < 8) {
      errs.password = 'Password should have at least 8 characters.';
    }
    return errs;
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
    } else {
      setErrors({});
      alert("Registration Successful!");
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: '30px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h3>User Mail Registration</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '15px' }}>
          <label>Name:</label>
          <input type="text" name="name" value={formData.name} onChange={handleChange} style={{ width: '100%', padding: '8px' }} />
          {errors.name && <span style={{ color: 'red', fontSize: '13px' }}>{errors.name}</span>}
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label>Email:</label>
          <input type="email" name="email" value={formData.email} onChange={handleChange} style={{ width: '100%', padding: '8px' }} />
          {errors.email && <span style={{ color: 'red', fontSize: '13px' }}>{errors.email}</span>}
        </div>
        <div style={{ marginBottom: '15px' }}>
          <label>Password:</label>
          <input type="password" name="password" value={formData.password} onChange={handleChange} style={{ width: '100%', padding: '8px' }} />
          {errors.password && <span style={{ color: 'red', fontSize: '13px' }}>{errors.password}</span>}
        </div>
        <button type="submit" style={{ padding: '10px 20px', backgroundColor: '#4CAF50', color: 'white', border: 'none' }}>Register</button>
      </form>
    </div>
  );
};

export default Register;
