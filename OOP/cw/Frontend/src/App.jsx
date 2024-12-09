import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Customer from './pages/Customer/Customer'
import Vendor from './pages/Vendor/Vendor'
import ControlPanel from './pages/ControlPanel/ControlPanel'
import TicketDisplay from './pages/TicketDisplay/TicketDisplay'
import TicketPurchase from './pages/PurchaseTicket/PurchaseTicket'
import Home from './pages/Home/Home'
import Admin from './pages/Admin/Admin'
import AdminDashbord from './pages/AdminDashbord/AdminDashbord'

const App = () => {
  return (
    <div>
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/customer' element={<Customer/>}/>
                <Route path='/vendor' element={<Vendor/>}/>
                <Route path='/admin' element={<Admin/>}/>
                <Route path='/control-panel' element={<ControlPanel/>}/>
                <Route path='/display-tickets' element={<TicketDisplay/>}/>
                <Route path='/ticket-purchase/:id' element={<TicketPurchase/>}/>
                <Route path='/admin-dashbord' element={<AdminDashbord/>}/>
            </Routes>
        </BrowserRouter>
    </div>
  )
}

export default App
