import axios from 'axios';

const api = axios.create({
    baseURL: "https://api-zerocommerce.herokuapp.com/"
});

export default api;