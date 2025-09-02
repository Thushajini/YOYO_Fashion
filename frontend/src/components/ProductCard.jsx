import React from 'react'
import { Link } from 'react-router-dom';


export const ProductCard = ({items}) => {
  return (
    <div>
       <div className="card">
        <img src ="https://m.media-amazon.com/images/I/51fYXSnSu9L._AC_UY327_FMwebp_QL65_.jpg" alt ="" className="productimg"/>
        <h3 className="productname">{items.productName}</h3>
        <div className="productprice">${items.price}</div>
        <button className="viewdetails"><Link  style={{ textDecoration:'none' ,color:'white'}} to ={`/products/${items.productId}`} >Viewdetails</Link></button>
       </div>
    </div>
  )
}
