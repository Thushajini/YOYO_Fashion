import React,{ createContext, useState } from "react";
import axios from "axios";

export const CartContext = createContext();

export const CartProvider = ({children}) => {
    
    const [cart,setCart] =useState([]);
   
   

    
     
        const addToCart = (product) => {
  
    axios.post("http://localhost:8080/api/cart/add", {
      productId: product.productId,
      quantity: 1
    })
    .then(res => {
     
      setCart(prev => [...prev, res.data]); 
    })
    .catch(err => console.error("Failed to add to cart:", err));
}
 
      
    return (
        <CartContext.Provider value={{cart,addToCart}}>
            {children}
        </CartContext.Provider>
    );
};

// export const useCart = () => useContext(CartContext);