import React, { useEffect, useState } from 'react'
import { ProductCard } from '../components/ProductCard'
import './CSS/Shop.css';
import { getProducts } from '../api';

export const Shop = () => {
  const [products,setProducts] = useState([]);
 

  useEffect(() => {
    getProducts() .then(res => setProducts(res.data))
  .catch((error) => console.error("error:",error))
  },[]);
  
  
  

  return (

    
    
    <div className="container"  >
      {
      products.map((product) => (
        <ProductCard key={product.productId} items = {product}  />
      ))
}
      
    </div>
   
  )
}
