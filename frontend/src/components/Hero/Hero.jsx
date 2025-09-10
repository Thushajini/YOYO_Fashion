import React from 'react'
import './Hero.css';
import hand_icon from '../Assets/hand_icon.png';
import { Link } from 'react-router-dom';
import arrow_right from '../Assets/arrow_right.png'

import hero_image from '../Assets/hero_image.png';

export const Hero = () => {
  return (
    <div className='hero'>
        <div className='hero-left'>
        
        <div className="hero-hand-icon">
             <h2>WELCOME</h2>
             <img src ={hand_icon} alt=""/>
            </div>
            <p>YOYO Fashion</p>
          <div className="hero-btn">
           <Link to="/login" style={{ textDecoration:'none' }}> <div>Collections <img src={arrow_right}/></div></Link>
            
            
          </div>
        </div>
        <div className='hero-right'>
          <div className="hero-image">
            <img src={hero_image} alt="" />
          </div>

        </div>

    </div>
  )
}
