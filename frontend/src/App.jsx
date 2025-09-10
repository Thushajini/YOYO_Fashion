import Navbar  from './components/Navbar/Navbar.jsx'
import { BrowserRouter,Routes,Route } from 'react-router-dom'
import { Home } from './pages/Home.jsx';
 import {Shop}  from './pages/Shop.jsx';
import ProductDetails  from './pages/ProductDetails.jsx';
import { LoginPage } from './pages/LoginPage.jsx';
// import { Footer } from './components/Footer/Footer.jsx';
import { Cart } from './pages/Cart.jsx';
import { Register } from './pages/Register.jsx';


const App = () => {
  // const username = "thusha";
  return (
    <div>
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path ="/shopCategory" element={<Shop/>}/>
         <Route path="/login" element={<LoginPage/>}/>
           <Route path="/register" element={<Register/>}/>
       <Route path="/products/:productId" element={<ProductDetails />}/>
       <Route path="/cart" element={<Cart/>}/>
       </Routes>
      {/* <Footer/> */}
      </BrowserRouter>
    </div>
     
    
    
  );
}
export default App;
