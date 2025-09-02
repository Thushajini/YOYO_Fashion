import {  useContext, useState } from 'react';
import cart_icon from '../Assets/cart_icon.png';
import './Navbar.css';
import { Link } from 'react-router-dom';
import logo4 from '../Assets/logo4.png';
import {CartContext} from '../../context/CartContext.jsx';



const Navbar = () => {
    const [menu,setMenu] = useState("");
    
    const {cart} =useContext(CartContext);

   return (
    <div className='navbar'>
      <div className='nav-logo'>
     <img src ={logo4} alt="" />
      </div>
      <ul className='nav-menu'>
        <li onClick={() => {setMenu("home")}}><Link style={{ textDecoration:'none' }}to="/">HOME</Link> {menu === "home"?<hr/>:<></>}</li>
        <li onClick={() => {setMenu("shopCategory")}}><Link style={{ textDecoration:'none' }}to="/shopCategory">PRODUCT</Link> {menu === "shopCategory"?<hr/>:<></>}</li>
        
      </ul>

      <div className='nav-profile-cart'>
       <Link to ="/login"> <button>login</button></Link>
        
<Link to="/cart" className="cart-wrapper">
    <img    src={cart_icon} alt="cart" />
    {cart.length > 0 && (
      <span className="cart-badge">{cart.length}</span>
    )}
  </Link>
      
       
    
       
  
      
      </div>

    </div>
    
  );
};
export default Navbar;