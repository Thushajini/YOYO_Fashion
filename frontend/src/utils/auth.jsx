export const saveToken = (token,username) => {
    localStorage.setItem("token",token);
    localStorage.setItem("username",username);
};

export const getToken = () => localStorage.getItem("token");

export const clearToken = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
};