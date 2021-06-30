import React, {useEffect, useState} from 'react';
import { HomePage } from './style';
import api from '../../services/api';
import createHistory from 'history/createBrowserHistory';


const Login = () => {
    const history = createHistory();
    const [cliente, setCliente] = useState([]);
    const [funcionario, setFuncionario] = useState([]);
    const [usuario, setUsuario] = useState();
    const [senha, setSenha] = useState();
    const [erro, setErro] = useState();

    const loadCliente = async () => {
        try {
            const response = await api.get('cliente');
            setCliente(response.data)          
        } catch (error) {
            console.log("Acesso negado", error)
        }
    };

    const loadFuncionario = async () => {
        try {
            const response = await api.get('funcionario');
           setFuncionario(response.data)
        } catch (error) {
            console.log("Vai entrar não menor", error)
        }
    };

    useEffect(() =>{
        loadCliente();
        loadFuncionario();
    }, []);

    function logar(){

        if(!usuario || !senha){
            return
        }
        cliente.map((clien) =>{
            if(clien.email === usuario.toLowerCase() && clien.cpf === senha.toLowerCase()){
                localStorage.setItem('@LOJA:user',JSON.stringify(clien));
                history.go(0)   
            }else{
                setTimeout(() => {
                    setErro("Errou o login aí")
                }, 1000);
                setTimeout(() => {
                    setErro(false)
                }, 6000);
            }
        })

        funcionario.map((funcio) =>{
            if(funcio.nome.toLowerCase() === usuario.toLowerCase() && funcio.cpf === senha.toLowerCase()){
                localStorage.setItem('@LOJA:funcionario',JSON.stringify(funcio));
                history.go(0)
            }else{
                setTimeout(() => {
                    setErro("Ta na disney?")
                }, 1000);
                setTimeout(() => {
                    setErro(false)
                }, 6000);
            }
        })  
    }

    return (
        <HomePage>
            <div>
                <input type="text" placeholder="Digite seu email" autoComplete="off" onChange={e => setUsuario(e.target.value)}></input>
                <input type="password" placeholder="Digite sua senha (CPF)" autoComplete="off" onChange={e => setSenha(e.target.value)}></input>
                {erro && 
                    <span>{erro}</span> }
                <button type="button" onClick={e => logar()}>Entrar</button>
                <a href="/cadastro" style={{textDecoration:"none"}}>Cadastrar</a>
            </div>
        </HomePage>
    )
}
export default Login;
