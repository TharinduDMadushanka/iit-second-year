import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './TicketDisplay.css';
import { useNavigate } from 'react-router-dom';

const TicketDisplay = () => {
  const [tickets, setTickets] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  // Fetch tickets from backend
  useEffect(() => {
    const fetchTickets = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/v1/ticket/get-all-tickets');
        setTickets(response.data.data); // Assuming the tickets are in the "data" field
        setLoading(false);
      } catch (err) {
        console.error('Error fetching tickets:', err);
        setError('Failed to fetch tickets. Please try again.');
        setLoading(false);
      }
    };

    fetchTickets();
  }, []);

  return (
    <div className="ticket-display-container">
      <h1 className="text-center">Tickets</h1>
      {loading && <p className="text-center">Loading tickets...</p>}
      {error && <p className="text-center text-danger">{error}</p>}

      <div className="ticket-grid">
        {tickets.map((ticket, index) => (
          <div 
            className="ticket-card" 
            key={ticket.ticketId}
            onClick={()=> navigate(`/ticket-purchase/${ticket.ticketId}`, { state: ticket })}>
            {/* <h3>{ticket.ticketName}</h3> */}
            <h3>Ticket: {ticket.ticketId}</h3>
            <p><strong>Price:</strong> ${ticket.ticketPrice}</p>
            <p><strong>Type:</strong> {ticket.ticketType}</p>
            {/* <p>Produce by:</p> */}
          </div>
        ))}
      </div>
    </div>
  );
};

export default TicketDisplay;
