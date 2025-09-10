import React from 'react'
import { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './CSS/login.css';

export const Register = () => {
  const [values,setUser] = useState({
    username:'',
    email:'',
  password:''
  })

  const[message,setMessage] = useState("");
   const handleChanges = (e) => {
        setUser({...values,[e.target.name]:e.target.value})
    }

  const handleRegister = async (e) => {
    e.preventDefault(); // ✅ prevent page refresh

    try {
      const res = await axios.post("http://localhost:8080/api/user/register",values
      );

        // setMessage("Registration Successful");
        alert("Registration Successful");
        console.log(res.data);
      
    } catch (error) {
      if (error.response) {
        setMessage(error.response.data);
        
      } else {
        setMessage("Registration failed");
      }
    }
  };
  return (
    <div className='login-container'>
      <h2>Sign Up</h2>
         {message && <p >{message}</p>}

      <form onSubmit={handleRegister} className='login-form'>
    
      <input
        type='text'
        name='username'
        placeholder="Enter your username"
        value={values.username}
        onChange={handleChanges}
        required
        />
        <input
        type="email"
        name='email'
        placeholder="Enter your email"
        value={values.email}
        onChange={handleChanges}
        required/>

        <input
        type='password'
        name='password'
        value={values.password}
        placeholder="Enter the password"
        onChange={handleChanges}
        required
        />
        <button type='submit' >Signup</button>
        <h4>OR</h4>
        <Link to="/login"><h3>Login Page</h3></Link>
      </form>
       
    </div>
  )
  
}
