import { useState } from 'react';
import cart_icon from '../Assets/cart_icon.png';
import './Navbar.css';
import { Link } from 'react-router-dom';

const Navbar = () => {
    const [menu,setMenu] = useState("home");

   return (
    <div className='navbar'>
      <div className='nav-logo'>
      <p>YOYO</p>
      </div>
      <ul className='nav-menu'>
        <li onClick={() => {setMenu("home")}}><Link style={{ textDecoration:'none' }}to="/">Home</Link> {menu === "home"?<hr/>:<></>}</li>
        <li onClick={() => {setMenu("product")}}><Link style={{ textDecoration:'none' }}to="/product">Product</Link> {menu === "product"?<hr/>:<></>}</li>
        <li onClick={() => {setMenu("womens")}}><Link style={{ textDecoration:'none' }} to ="/womens">Women</Link>{menu === "women"?<hr/>:<></>}</li>
        <li onClick={() => {setMenu("kids")}}><Link style={{ textDecoration:'none' }} to ="/kids">Kids</Link>{menu ==="kids"?<hr/>:<></>}</li>
      </ul>

      <div className='nav-profile-cart'>
       <Link to ="/login"> <button>login</button></Link>
        <Link to ="/cart"><img src ={cart_icon} alt="" /></Link>
        <div className='nav-cart-count'>0</div>
      </div>

    </div>
    
  );
};
export default Navbar;