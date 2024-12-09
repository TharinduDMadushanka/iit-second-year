import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './PurchaseTicket.css';

const TicketPurchase = () => {
  const { state: ticket } = useLocation(); // Get ticket details from navigation state
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    ticketId: ticket?.ticketId || '', // Ensure ticketId matches backend's first parameter
    customerId: '', // Initialize as an empty string, will convert to number before submitting
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const purchaseTicket = async () => {
    // Ensure both fields are filled and `customerId` is converted to a number
    if (!formData.ticketId || !formData.customerId) {
      alert('Please provide both Ticket ID and Customer ID.');
      return;
    }

    const ticketId = Number(formData.ticketId); // Convert ticketId to a number
    const customerId = Number(formData.customerId); // Convert customerId to a number

    try {
      // Send ticketId and customerId as URL parameters
      const response = await axios.post(
        `http://localhost:8080/api/v1/ticket/ticket-purchase/${ticketId}/${customerId}`
      );
      alert('Ticket purchased successfully!');
      navigate('/display-tickets'); // Redirect to home after purchase
    } catch (error) {
      console.error('Error purchasing ticket:', error);
      alert('Failed to purchase ticket. Please try again.');
    }
    console.log(ticketId);
    console.log(customerId);
  };

  return (
    <div className="ticket-purchase-container">
      <div className="ticket-card-details">
        <h3>{ticket.ticketName}</h3>
        <p><strong>Price:</strong> ${ticket.ticketPrice}</p>
        <p><strong>Type:</strong> {ticket.ticketType}</p>
        <p><strong>Date:</strong> {ticket.date.split('T')[0]}</p>
      </div>

      <div className="ticket-purchase-form">
        <h3>Purchase Ticket</h3>
        <div className="form-outline mb-3">
          <label className="form-label" htmlFor="customerId">Customer ID</label>
          <input
            type="number" // Enforce numeric input
            id="customerId"
            name="customerId"
            value={formData.customerId}
            onChange={handleInputChange}
            className="form-control"
            required
          />
        </div>

        <button type="button" className="btn btn-primary" onClick={purchaseTicket}>
          Purchase Ticket
        </button>
      </div>
    </div>
  );
};

export default TicketPurchase;
