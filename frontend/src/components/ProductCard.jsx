import React from 'react'
import { Link } from 'react-router-dom';


export const ProductCard = ({items}) => {
  return (
    <div>
       <div className="card">
        <img src ={`http://localhost:8080/uploads/${items.image}`} alt ="" className="productimg"/>
        <h3 className="productname">{items.productName}</h3>
        <div className="productprice">{items.price}.00</div>
        <button className="viewdetails"><Link  style={{ textDecoration:'none' ,color:'white'}} to ={`/products/${items.productId}`} >Viewdetails</Link></button>
       </div>
    </div>
  )
}
