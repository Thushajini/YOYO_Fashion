import React, { useContext, useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import { getById } from '../api';
import "./CSS/ProductDetails.css"
import { CartContext } from '../context/CartContext';
import arrow from "../components/Assets/arrow.png"

 const ProductDetails = () => {
    const {productId} = useParams();
    const [product,setProduct] = useState(null);
    const {addToCart} = useContext(CartContext);

   

    useEffect ( () => {
        getById(productId).then(res => setProduct(res.data))
        .catch((error) => console.error("error:",error))
    },[productId]);

    if (!product) {
    return <p className="p-6">Loading product details...</p>;
  }



  return (
    <div className="container"> 
       <div className="detail">
        <img src ={`http://localhost:8080/uploads/${product.image}`} alt ="" className="img"/>
        <div className="details">
        <h3 className="name">{product.productName}</h3>
        <p className="des">{product.description}</p>
        <div className="rating">
          {
            [1,2,3,4,5].map((count) => (
                   <span key ={count} style={{color: count<= product.rating ? "#f39c12":"#ccc"}}>&#9733;</span>
            ))
          }
         

        </div>
        <div className="price">{product.price}.00</div>
        <button  onClick={() => addToCart(product)} className="cart">Add to Cart</button>
        </div>
      </div>
        <Link to ="/shopCategory"><img src ={arrow} className='back-to'/></Link>
    </div>
    
  )
}

export default ProductDetails;
