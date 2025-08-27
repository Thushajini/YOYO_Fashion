// import React , { useState,useEffeect,createContext, Children } from "react";
// import { login,register } from "../api/authapi";
// import { saveToken,getToken,clearToken } from "../utils/auth";



// export const AuthContext = createContext();
// export const AuthProvider = ({Children}) => {
//     const [user,setUser] = useState(null);

//     useEffeect(() => {
//         const token = getToken();

//         if(token) setUser({username:localStorage.getItem("username")});
//     }, []);


//     const handleLogin = async(Credentials) => {
//         const data = await login(Credentials);
//         saveToken(data.token,Credentials.username);
//         setUser({username:Credentials.username});
//     };


//     const handleRegister = async (userData) => {
//         await register(userData);
//     };

//     const handleLogout = () => {
//         clearToken();
//         setUser(null);
//      };

//      return (
//         <AuthContext.Provider value = {{ user,handleLogin,handleRegister,handleLogout }}>
//             {Children}
//         </AuthContext.Provider>
//      );
// };