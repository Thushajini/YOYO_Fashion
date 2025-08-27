
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import HomeContextProvider from './context/HomeContext';



createRoot(document.getElementById('root')).render(
 <HomeContextProvider>
    <App/>
    </HomeContextProvider>
  
);
