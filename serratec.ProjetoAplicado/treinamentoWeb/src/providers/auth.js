import React, { useState } from 'react';

export const AuthContext = React.createContext({});

export const AuthProvider = (props) => {
    const [colaborador, setColaborador] = useState({});
    const [usuario, setUsuario] = useState({});
    const [endereco, setEndereco] = useState({});
    const [formacao, setFormacao] = useState({});
    const [posicao, setPosicao] = useState({});
    const [competencia, setCompetencia] = useState({});
    const [conhecimento, setConhecimento] = useState({});
    const [header, setHeader] = useState({titulo:'',caminho:''});

    return (
        <AuthContext.Provider
            value={{
                colaborador, setColaborador: (colaborador) => setColaborador(colaborador),
                usuario, setUsuario: (usuario) => setUsuario(usuario),
                endereco, setEndereco: (endereco) => setEndereco(endereco),
                formacao, setFormacao: (formacao) => setFormacao(formacao),
                posicao, setPosicao: (posicao) => setPosicao(posicao),
                competencia, setCompetencia: (competencia) => setCompetencia(competencia),
                conhecimento, setConhecimento: (conhecimento) => setConhecimento(conhecimento),
                header, setHeader: (header) => setHeader(header)
            }}>
            {props.children}
        </AuthContext.Provider>
    )
}