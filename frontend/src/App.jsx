import Navbar  from './components/Navbar/Navbar.jsx'
import { BrowserRouter,Routes,Route } from 'react-router-dom'
import { Home } from './pages/Home.jsx';
import ShopCategory  from './pages/ShopCategory.jsx';
import { Cart } from './pages/Cart.jsx';
import Product  from './pages/Product.jsx';
import { LoginPage } from './pages/LoginPage.jsx';
import { Register} from './pages/Register.jsx';
import { Footer } from './components/Footer/Footer.jsx';


const App = () => {
  return (
    <div>
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/womens" element={<ShopCategory category="women"/>}/>
        <Route path="/kids" element={<ShopCategory category="kid"/>}/>
        <Route path="/login" element={<LoginPage/>}/>
        <Route path="/register" element={<Register/>}/>
        <Route path="/product" element={<Product/>}>
          <Route path=":productId" element={<Product/>}/>
        </Route>
        <Route path="/cart" element={<Cart/>}/>
      </Routes>
      <Footer/>
      </BrowserRouter>
    </div>
     
    
    
  );
}
export default App;
