import React from 'react'
import './Home.css'

import bg_img from '../../assets/bg-image.jpg'
import { useNavigate } from 'react-router-dom'

const Home = () => {

  const navigate = useNavigate();

  return (
    <div id='home'>
        <img className='bg-img' src={bg_img} alt="" />
        <div className="title">
            <h1>Welcome</h1>
            <h3>Real Time Ticketing System..!</h3>
        </div>

        <div className="button-group home-btn">
          <button className="btn admin-btn" onClick={() => navigate('/admin')}>Admin</button>
          <button className="btn cust-btn" onClick={() => navigate('/customer')}>Customer</button>
          <button className="btn vendor-btn" onClick={() => navigate('/vendor')}>Vendor</button>
        </div>
        
    </div>
  )
}

export default Home
