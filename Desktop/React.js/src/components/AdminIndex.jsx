import React from 'react'
import './AdminIndex.css'
import Header_Admin from './Header_Admin.jsx'
import Menu_Admin from './Menu_Admin.jsx'
import Main_Admin from './Main_Admin.jsx'
import Footer_Admin from './Footer_Admin.jsx'

export default function AdminIndex() {
  return (
      <div className='container-admin'>
            <Header_Admin />
            <div className='main'>
                <Menu_Admin />
                <div className='content-admin'>
                    <Main_Admin />
                    <Footer_Admin />
                </div>
            </div>
    </div>
  )
}
