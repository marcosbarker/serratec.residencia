import React, { useState } from 'react';

export const AuthContext = React.createContext({});

export const AuthProvider = (props) => {
    const [isAdmin, setIsAdmin] = useState(0);
    const [enderecos, setEnderecos] = useState({});
    const [colaboradores, setColaboradores] = useState({})
    const [formacao, setFormacao] = useState({});
    const [posicao, setPosicao] = useState({});
    const [competencia, setCompetencia] = useState({});
    const [conhecimento, setConhecimento] = useState({});
    
    return (
        <AuthContext.Provider value={{
            isAdmin, setIsAdmin: (isAdmin) => setIsAdmin(isAdmin),
            enderecos, setEnderecos: (enderecos) => setEnderecos(enderecos),
            colaboradores, setColaboradores: (colaboradores) => setColaboradores(colaboradores),
            formacao, setFormacao: (formacao) => setFormacao(formacao),
            posicao, setPosicao: (posicao) => setPosicao(posicao),
            competencia, setCompetencia: (competencia) => setCompetencia(competencia),
            conhecimento, setConhecimento: (conhecimento) => setConhecimento(conhecimento)
        }}>
            {props.children}
        </AuthContext.Provider>
    )

}