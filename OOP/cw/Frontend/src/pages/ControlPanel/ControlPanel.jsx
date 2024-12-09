import React from 'react';
import axios from 'axios';
import './ControlPanel.css';

const ControlPanel = () => {
  // Call backend to start vendor thread
  const startVendorThread = async () => {

    try {
      // Make POST request
      const response = await axios.post(
        'http://localhost:8080/api/v1/vendor/start-all-vendor-threads');

      console.log('Vendor thread started:', response.data);
      alert('Vendor thread started successfully!');
    } catch (error) {
      console.error('Error starting vendor thread:', error);
      alert('Failed to start vendor thread. Please try again.');
    }
  };

  const StopVendorThread = async () =>{

    try {

      const response = await axios.post('http://localhost:8080/api/v1/vendor/stop-all-vendor-threads')
      
      console.log('Vendor thread sttoped:', response.data);
      alert('Vendor thread stop successfully!');
      
    } catch (error) {
      console.error('Error in stopping vendor thread:', error);
      alert('Failed to stop vendor thread. Please try again.');
    }

  }

  return (
    <div className="control-panel">
      <div className="btn-group">
        <div className="d-flex justify-content-center">
          <button
            type="button"
            className="btn btn-block btn-lg start-btn"
            onClick={startVendorThread}
          >
            Start
          </button>
        </div>

        <div className="d-flex justify-content-center">
          <button 
            type="button" 
            className="btn btn-block btn-lg stop-btn"
            onClick={StopVendorThread}
            >
            Stop
          </button>
        </div>
      </div>
    </div>
  );
};

export default ControlPanel;
