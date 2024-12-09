import React, { useState } from 'react';
import axios from 'axios';
import './Customer.css';

const Customer = () => {
  // State to manage form inputs
  const [formData, setFormData] = useState({
    customerName: '',
    email: '',
    password: '',
    phone: '',
  });

  // State for form submission status
  const [message, setMessage] = useState('');

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Save customer using axios
  const saveCustomer = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/v1/customer/save-customer', {
        customerName: formData.customerName,
        email: formData.email,
        password: formData.password,
        phone: formData.phone,
      });
      console.log('Customer registered:', response.data);
      alert('Customer registered successfully!');
      setFormData({ customerName: '', email: '', password: '', phone: '' }); // Reset the form
    } catch (error) {
      console.error('Error registering customer:', error);
      alert('Registration failed. Please try again.');
    }
  };

  return (
    <div className="container-fluid">
      <div className="card">
        <div className="card-body p-5">
          <h2 className="text-uppercase text-center text-white mb-5">Register as Customer</h2>

          <form onSubmit={saveCustomer}>
            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="customerName">
                Customer Name
              </label>
              <input
                type="text"
                id="customerName"
                name="customerName"
                value={formData.customerName}
                onChange={handleInputChange}
                className="form-control form-control-lg"
                required
              />
            </div>

            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="email">
                Email
              </label>
              <input
                type="email"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleInputChange}
                className="form-control form-control-lg"
                required
              />
            </div>

            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="phone">
                Phone
              </label>
              <input
                type="tel"
                id="phone"
                name="phone"
                value={formData.phone}
                onChange={handleInputChange}
                className="form-control form-control-lg"
                required
              />
            </div>

            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="password">
                Password
              </label>
              <input
                type="password"
                id="password"
                name="password"
                value={formData.password}
                onChange={handleInputChange}
                className="form-control form-control-lg"
                required
              />
            </div>

            <div className="d-flex justify-content-center">
              <button type="submit" className="btn btn-block btn-lg text-body reg-btn">
                Register
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Customer;
