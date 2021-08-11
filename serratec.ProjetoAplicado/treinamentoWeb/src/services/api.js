import axios from 'axios';

const api = axios.create({
    baseURL: "https://api-treinamento-t2m.herokuapp.com",
});

export default api;