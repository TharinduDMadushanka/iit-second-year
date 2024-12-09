import React, { useState } from 'react';
import axios from 'axios';
import './Vendor.css';

const Vendor = () => {
  // State to manage form inputs
  const [formData, setFormData] = useState({
    vendorName: '',
    email: '',
    ticketType: 'SILVER', // Default value for the dropdown
    ticketPrice: '',
  });

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Save vendor using axios
  const saveVendor = async (e) => {
    e.preventDefault();

    // Validation (Optional)
    if (!formData.vendorName || !formData.email || !formData.ticketPrice) {
      alert('Please fill out all required fields.');
      return;
    }

    try {
      const response = await axios.post(
        'http://localhost:8080/api/v1/vendor/save-vendor',
        {
          vendorName: formData.vendorName,
          email: formData.email,
          ticketType: formData.ticketType,
          ticketPrice: formData.ticketPrice,
        }
      );
      console.log('Vendor registered:', response.data);
      alert('Vendor registered successfully!');
      setFormData({ vendorName: '', email: '', ticketType: 'GOLD', ticketPrice: '' }); // Reset the form
    } catch (error) {
      console.error('Error registering vendor:', error);
      alert('Registration failed. Please try again.');
    }
  };

  return (
    <div className="container-fluid">
      <div className="card">
        <div className="card-body p-5">
          <h2 className="text-uppercase text-center text-white mb-5">Register as Vendor</h2>

          <form onSubmit={saveVendor}>
            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="vendorName">
                Vendor Name
              </label>
              <input
                type="text"
                id="vendorName"
                name="vendorName"
                value={formData.vendorName}
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

            <div className="form-outline mb-4">
              <label className="form-label" htmlFor="ticketType">
                Ticket Type
              </label>
              <select
                id="ticketType"
                name="ticketType"
                value={formData.ticketType}
                onChange={handleInputChange}
                className="form-control"
              >
                <option value="SILVER">SILVER</option>
                <option value="GOLD">GOLD</option>
                <option value="PLATINUM">PLATINUM</option>
              </select>
            </div>

            <div data-mdb-input-init className="form-outline mb-4">
              <label className="form-label" htmlFor="ticketPrice">
                Ticket Price
              </label>
              <input
                type="number"
                id="ticketPrice"
                name="ticketPrice"
                value={formData.ticketPrice}
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

export default Vendor;
