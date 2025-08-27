import React from 'react'
import './Footer.css'

export const Footer = () => {
  return (
    <div className='footer'>
        <div className="footer-logo">
            {/* <img src='' alt=''/> */}
            <p>YOYO</p>
        </div>

        <ul className="footer-links">
            <li>Company</li>
            <li>Products</li>
            <li>Offices</li>
            <li>About</li>
            <li>Contact</li>        
            </ul>

            <div className="footer-social-icon">
                <div className="footer-icons-container">
                    <img src=' ' alt=''/>
                </div>

                <div className="footer-icons-container">
                    <img src=' ' alt=''/>
                </div>

                <div className="footer-icons-container">
                    <img src=' ' alt=''/>
                </div>
            </div>

            <div className="footer-copyright">
                <hr/>
                <p>Copyright @ 2025 - All Right Reserved</p>
            </div>
    </div>
  )
}
