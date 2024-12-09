import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Admin = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    adminName: '',
    email: '',
    password: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const saveAdmin = async (e) => {
    e.preventDefault(); // Prevent page reload on form submission

    try {
      const response = await axios.post('http://localhost:8080/api/v1/admin/save-admin', {
        adminName: formData.adminName,
        email: formData.email,
        password: formData.password,
      });

      console.log('Admin saved successfully!', response.data);
      alert('Admin saved successfully!');
      setFormData({ adminName: '', email: '', password: '' });
      navigate('/admin-dashbord'); // Ensure route matches your application
    } catch (error) {
      console.error('Error saving admin:', error);
      alert('Admin save failed!');
    }
  };

  return (
    <div className="container-fluid">
      <div className="card">
        <div className="card-body p-5">
          <h2 className="text-uppercase text-center text-white mb-5">Register as Admin</h2>

          <form onSubmit={saveAdmin}>
            <div className="form-outline mb-4">
              <label className="form-label" htmlFor="adminName">
                Admin Name
              </label>
              <input
                type="text"
                id="adminName"
                name="adminName"
                value={formData.adminName}
                onChange={handleInputChange}
                className="form-control form-control-lg"
                required
              />
            </div>

            <div className="form-outline mb-4">
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

export default Admin;
