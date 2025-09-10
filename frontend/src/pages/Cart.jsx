import React, { useState ,useEffect} from 'react'
import { deleteCart, getCarts } from '../api';
// import { data } from 'react-router-dom';
import "./CSS/Cart.css";
import { CartContext } from '../context/CartContext';


export const Cart = () => {

    const [cartItem,setCartItem] = useState([]);
    const [total,setTotal] = useState(0);
    

  
    useEffect(() => {
    const newTotal =  cartItem.reduce((sum,item) => sum+item.product?.price * item.quantity,0)
   setTotal(newTotal)
    },[cartItem])
    

    const mergedProducts =(data) => {
        const merged ={};
        data.forEach((item) => {
            const productId =item.product.productId;

            if(merged[productId]){
                merged[productId].quantity += item.quantity;
            }
            else{
                merged[productId] ={...item}
            }
        });
        return Object.values(merged)
      }
      

      useEffect(() => {
        getCarts() 
        .then(res => setCartItem(mergedProducts(res.data)))
      .catch((error) => console.error("error:",error))
      },[]);
    

      if(cartItem.length === 0){
        return <p className='cart-empty'>Your cart is empty</p>
      }

      const deleteCartItem =(productId) => {
        deleteCart(productId)
        .then(() => {getCarts().then(res => setCartItem(mergedProducts(res.data)))
      .catch((error) => console.error("error:",error))

        })
       
      }

      const increaseQuantity = (productId) => {
    const updatedCart = cartItem.map((item) =>
      item.product.productId === productId
        ? { ...item, quantity: item.quantity + 1 }
        : item
    );
    setCartItem(updatedCart);
  };

  const decreaseQuantity = (productId) => {
    const updatedCart = cartItem.map((item) =>
      item.product.productId === productId && item.quantity > 1
        ? { ...item, quantity: item.quantity - 1 }
        : item
    );
    setCartItem(updatedCart);
  };


      
  return (
    <div className='cart-container'>
        <h1 className='cart-heading'>Cart Items</h1>
       
            <table className="cart-page">
               <thead>
          <tr>
            <th>Product</th>
             <th>ProductName</th>
             <th>Quantity</th>
            <th>Price</th>
            <th>Action</th>
           
            
          </tr>
        </thead>
        <tbody>
              
                {cartItem.map((item) => (
                        <tr key={item.cartId} className='cart-item'>
                           <td> <img src={`http://localhost:8080/uploads/${item.product.image}`} alt="" className='img' /></td>
                           <td> {item.product.productName} </td>
                            
                           <td> <button className="count" onClick={() => decreaseQuantity(item.product.productId)}> - </button>   {item.quantity}   <button className="count" onClick={() => increaseQuantity(item.product.productId)}> + </button></td>
                             
                           <td> {item.product.price * item.quantity}</td>
                            <td><button  onClick={()=>deleteCartItem(item.product.productId)}className='cart-button'>remove</button></td>
                        </tr>
                    ))
                }
                </tbody>
                </table>
               
              
                <h2 className='amount'>Amount:{total}.00</h2>
               
           

            

    </div>
  )
}
