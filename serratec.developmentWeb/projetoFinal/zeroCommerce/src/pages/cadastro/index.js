import React, { useState, useEffect } from 'react';
import api from '../../services/api';
import {Conteudo} from './style';
import { useHistory } from 'react-router-dom';

const Cadastro = () => {

    const [novoNomeCliente, setNovoNomeCliente] = useState();
    const [novoCpf, setNovoCpf] = useState();
    const [novoEmail, setNovoEmail] = useState();
    const [novoUsuario, setNovoUsuario] = useState();
    const history = useHistory();

    async function cadastrarCliente(e) {
        e.preventDefault();
        const params = {
            nome:novoNomeCliente,
            usuario:novoUsuario.toLowerCase(),
            cpf: novoCpf,
            email: novoEmail,
            dataNascimento: "1992-02-01T00:00:00Z",
                endereco: {
                rua: "Rua dos Bobos",
                numero: "0",
                complemento: "",
                bairro: "Castanheira",
                cidade: "Metropolis",
                estado: "SP",
                cep: "23451234"
            }
        }
        try {
            await api.post(`cliente`, params);
            history.push('/');
        } catch (error) {
            console.log('Erro ao cadastrar Cliente', error);
        }
    }

    return (
        <>   
             <Conteudo>
                <div>
                    <form onSubmit={cadastrarCliente} >
                    <label id="nome">Nome</label>
                    <input type="text" id="nome" value={novoNomeCliente} onChange={e => setNovoNomeCliente(e.target.value)} placeholder="Digite o seu nome" autoComplete="off"/>
                    <br/>
                    <label id="cpf">CPF</label>
                    <input type="text" id="cpf" value={novoCpf} onChange={e => setNovoCpf(e.target.value)} placeholder="Digite o seu CPF(somente números)" autoComplete="off" maxlength="11"/>
                    <br/>
                    <label id="email">E-mail</label>
                    <input type="text" id="email" value={novoEmail} onChange={e => setNovoEmail(e.target.value)} placeholder="Digite o seu e-mail" autoComplete="off"/>
                    <br/>
                    <label id="usuario">Usuario</label>
                    <input type="text" id="usuario" value={novoUsuario} onChange={e => setNovoUsuario(e.target.value)} placeholder="Nome de usuário" autoComplete="off"/>
                    <br/>
                    <button type="submit">Novo Cadastro</button>
                    </form>
                </div>   
            </Conteudo>        
        </>
    )
}
export default Cadastro;
