import React from 'react'
import './Home.css';
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import NotificationsNoneIcon from '@mui/icons-material/NotificationsNone';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function Home() {
  return (
    <div>
      <div className='dash-home-container'>
        <div className='dash-home-navbar'>
            <SearchOutlinedIcon className='SearchOutlinedIcon' />
            <input className='dash-home-searchbar' placeholder='Explore Products' />
        </div>
        <div className='dash-home-title'>
          <AccountCircleIcon />
          <h3>Ankit Seth</h3>
          <MailOutlineIcon />
          <NotificationsNoneIcon />
        </div>
      </div>
      <div className='dash-product-section'>
        <h3>Featured Product</h3>
      </div>
    </div>
  )
}

export default Home;