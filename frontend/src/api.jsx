import axios from "axios";

const url = "http://localhost:8080/api/product";

 export const getProducts= () => axios.get(url);



 export const getById =(productId) => {
   return axios.get( `http://localhost:8080/api/product/${productId}`);
 }

  export const getCarts= () => {
    return axios.get("http://localhost:8080/api/cart");
  }

  export const deleteCart = (productId)=>{
    return axios.delete(`http://localhost:8080/api/cart/product/${productId}`);
  }