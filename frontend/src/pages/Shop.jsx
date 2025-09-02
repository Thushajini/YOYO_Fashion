// import React, { useEffect, useState } from 'react';
// import axios from "axios";
// import { Link } from "react-router-dom";

//  const Shop= () => {
//   const [products,setProducts] = useState([]);
   

//     useEffect(() => {
//     axios.get("http://localhost:8080/api/products")
//       .then(res => {
//         console.log("products",res.data);
//         setProducts(res.data)})
//       .catch(err => console.error(err));
//   }, []);

   

//   return (
//    <div className="p-6">
//       <h2 className="text-2xl font-bold mb-4">All Products</h2>
//       <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6">
//         {Array.isArray(products) && products.map((p) => (
//           <div key={p.productId} className="border p-4 rounded-lg shadow">
//             <h3 className="font-semibold">{p.productName}</h3>
//             <p>${p.price}</p>
//             <Link
//               to={`/products/${p.productId}`}
//               className="text-blue-600 underline"
//             >
//               View Details
//             </Link>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default Shop;

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
