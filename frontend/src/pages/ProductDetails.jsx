// import axios from 'axios';
// import React, {  useContext, useEffect, useState } from 'react'
// import { useParams } from 'react-router-dom';
// import { CartContext} from '../context/CartContext';


// const ProductDetails = () => {

//     const {productId}  = useParams();
//     const { addToCart } = useContext(CartContext);
    
//     const [products,setProducts] = useState([]);

//     useEffect( () => {
//         axios.get(`http://localhost:8080/api/products/${productId}`)
//         .then(response => setProducts(response.data))
//         .catch(error => console.error(error));
//     }, [productId]);

   

// if(!products) return <p>Loading....</p>;
 

//   return (
//     <div className="p-6">
//       <h2 className="text-2xl font-bold">{products.name}</h2>
//       <p className="my-2">Price: ${products.price}</p>
//       <button 
//         onClick={() => addToCart(products,1)} 
//         className="bg-green-500 text-white px-4 py-2 rounded"
//       >
//         Add to Cart
//       </button>
//     </div>
//   );
// };

// export default ProductDetails;
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

// const addToCart = (products) => {
//     setCart((preCart) => [...preCart,products]);
//     alert("hi");
//   }


  return (
    <div className="container"> 
       <div className="detail">
        <img src ="https://m.media-amazon.com/images/I/51fYXSnSu9L._AC_UY327_FMwebp_QL65_.jpg" alt ="" className="img"/>
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
        <div className="price">${product.price}</div>
        <button  onClick={() => addToCart(product)} className="cart">Add to Cart</button>
        </div>
      </div>
        <Link to ="/shopCategory"><img src ={arrow} className='back-to'/></Link>
    </div>
    
  )
}

export default ProductDetails;
