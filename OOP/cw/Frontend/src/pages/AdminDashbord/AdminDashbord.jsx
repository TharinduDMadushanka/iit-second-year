import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./AdminDashbord.css";

const AdminDashbord = () => {
  const [activeSection, setActiveSection] = useState(''); // Track the active section
  const [data, setData] = useState([]); // Store the fetched data

  // Fetch data based on the active section
  useEffect(() => {
    const fetchData = async () => {
      try {
        let response;
        switch (activeSection) {
          case 'Customer':
            response = await axios.get('http://localhost:8080/api/v1/customer/get-all-customers');
            break;
          case 'Vendor':
            response = await axios.get('http://localhost:8080/api/v1/vendor/get-all-vendors');
            break;
          case 'Tickets':
            response = await axios.get('http://localhost:8080/api/v1/ticket/get-all-tickets');
            break;
          default:
            return;
        }
        console.log(response.data); // Debugging: Check the structure of the response
        const resolvedData =
          Array.isArray(response.data) // Case 1: Direct array in `response.data`
            ? response.data
            : Array.isArray(response.data.data) // Case 2: Nested array in `response.data.data`
            ? response.data.data
            : []; // Default: Empty array if no valid data
        setData(resolvedData); // Set the extracted data
      } catch (error) {
        console.error(`Error fetching ${activeSection} data:`, error);
        setData([]); // Reset data on error
      }
    };
  
    if (activeSection) {
      fetchData();
    }
  }, [activeSection]);
  
  
  

  // Render table dynamically based on the fetched data
  const renderTable = () => {
    if (!data || data.length === 0) {
      return <p className="text-center mt-3">No data available.</p>;
    }

    switch (activeSection) {
      case 'Customer':
        return (
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact</th>
              </tr>
            </thead>
            <tbody>
              {data.map((customer) => (
                <tr key={customer.customerId}>
                  <td>{customer.customerId}</td>
                  <td>{customer.customerName}</td>
                  <td>{customer.email}</td>
                  <td>{customer.phone}</td>
                </tr>
              ))}
            </tbody>
          </table>
        );

      case 'Vendor':
        return (
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              {data.map((vendor) => (
                <tr key={vendor.vendorId}>
                  <td>{vendor.vendorId}</td>
                  <td>{vendor.vendorName}</td>
                  <td>{vendor.email}</td>
                </tr>
              ))}
            </tbody>
          </table>
        );

      case 'Tickets':
        return (
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Status</th>
                <th>Release Date</th>
              </tr>
            </thead>
            <tbody>
              {data.map((ticket) => (
                <tr key={ticket.ticketId}>
                  <td>{ticket.ticketId}</td>
                  <td>{ticket.ticketName}</td>
                  <td>{ticket.ticketType}</td>
                  <td>{ticket.ticketStatus}</td>
                  <td>{ticket.ticketPrice}</td>
                  <td>{ticket.date}</td>
                </tr>
              ))}
            </tbody>
          </table>
        );

    //   case 'Purchase Details':
    //     return (
    //       <table className="table">
    //         <thead>
    //           <tr>
    //             <th>ID</th>
    //             <th>Customer Name</th>
    //             <th>Ticket ID</th>
    //             <th>Purchase Date</th>
    //           </tr>
    //         </thead>
    //         <tbody>
    //           {data.map((purchase) => (
    //             <tr key={purchase.id}>
    //               <td>{purchase.id}</td>
    //               <td>{purchase.customerName}</td>
    //               <td>{purchase.ticketId}</td>
    //               <td>{purchase.purchaseDate}</td>
    //             </tr>
    //           ))}
    //         </tbody>
    //       </table>
    //     );

      default:
        return <p className="text-center mt-3">Select an option to view details.</p>;
    }
  };

  return (
    <div className="dashboard">
      <div className="container-fluid">
        <div className="row">

          <div className="col-2 left-col">
            <h3 className="mt-4">Admin Dashboard</h3>
            <div className="btn dasbord-btn">
              <button className="btn" onClick={() => setActiveSection('Customer')}>Customer</button>
              <button className="btn" onClick={() => setActiveSection('Vendor')}>Vendor</button>
              <button className="btn" onClick={() => setActiveSection('Tickets')}>Tickets</button>
              <button className="btn">Purchase Details</button>
            </div>
          </div>

          <div className="col-9 right-col">
            <h3 className="text-center">{activeSection || 'Welcome to Admin Dashboard'}</h3>
            {renderTable()}
          </div>

        </div>
      </div>
    </div>
  );
};

export default AdminDashbord;
