import React, { useState } from 'react'
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import './CSS/Login.css';
import { Link } from 'react-router-dom';

export const LoginPage = () => {
  const [values,setUser] = useState({
      username:'',
      email:'',
    password:''
    })
  const[message,setMessage] = useState("");
  const navigate =useNavigate();
  
   const handleChanges = (e) => {
        setUser({...values,[e.target.name]:e.target.value})
    }
  const handleLogin = async (e) => {
    e.preventDefault(); 

    try {
      const res = await axios.post("http://localhost:8080/api/user/login",{
        email:values.email,
        password:values.password
      });

      if (res.data === "Login Successful") {
        navigate("/shopCategory"); //
      } else {
        setMessage(res.data);
      }
    } catch (error) {
      if (error.response) {
        setMessage("invalid credential");
        
      } else {
        setMessage("Network error: please try again");
      }
    }
  };
  return (
    <div className='login-container'>
      <h2>Login</h2>
         {message && <p className="login-error">{message}</p>}

      <form onSubmit={handleLogin} className='login-form'>
    
        <input
        type='email'
        name='email'
        placeholder='Enter your email'
        value={values.email}
        onChange={handleChanges}
        required/>

        <input
        type='password'
        name='password'
        value={values.password}
        placeholder='Enter the password'
        onChange={handleChanges}
        required
        />
        <button type='submit' >Login</button>
        <h4>OR</h4>
        <Link to="/register"><h3>Signup Page</h3></Link>
      </form>
       
    </div>
  )
}
