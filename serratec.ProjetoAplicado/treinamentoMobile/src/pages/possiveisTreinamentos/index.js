import React, { useState, useEffect } from 'react';
import { Container, ListScroll, TreinaColaView, TreinamentoColaButton, TreiText, Titulo, TreinaText, TreinamentoColaArea, TreinamentoColaView, TreinamenText, TreinamentoButton } from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import axios from 'axios';
import { AuthContext } from '../../services/auth';
import { Alert, ActivityIndicator } from 'react-native';

export default function PossiveisTreinamentos({ navigation }) {
    const { conhecimento, setConhecimento } = React.useContext(AuthContext);
    const [refresh, setRefresh] = useState(false);
    const [loading, setLoading] = useState(true);

    async function handleRemoverTreinamento(p) {
        await axios.put(`https://api-treinamento-t2m.herokuapp.com/consTrns/conhecimento/${conhecimento.idConhecimentos}/treinamentoARemover/${p.treinamento.idTreinamentos}`);
        Alert.alert("Treinamento removido com sucesso!");
        setRefresh(!refresh)
    };

    useEffect(async () => {
        const responseConhecimento = await axios.get(`https://api-treinamento-t2m.herokuapp.com/conhecimentos/${conhecimento.idConhecimentos}`)
        setConhecimento(responseConhecimento.data)
        setLoading(false);
    }, [refresh]);

    const treinamentos = conhecimento.setConsTrns.map((p, i) => {
        return (
            <TreinamentoColaArea key={i} >
                <TreinamentoColaView>
                    <TreinaText>Nome:</TreinaText>
                    <TreinamenText>{p.treinamento.nome}</TreinamenText>
                </TreinamentoColaView>
                <TreinamentoColaView>
                    <TreinaText>Descrição:</TreinaText>
                    <TreinamenText>{p.treinamento.descricao}</TreinamenText>
                </TreinamentoColaView>
                <TreinamentoColaView>
                    <TreinaText>Instituição:</TreinaText>
                    <TreinamenText>{p.treinamento.instituicao}</TreinamenText>
                </TreinamentoColaView>
                <TreinamentoColaView>
                    <TreinaText>Carga Horária:</TreinaText>
                    <TreinamenText>{p.treinamento.cargaHoraria}Hora(s)</TreinamenText>
                </TreinamentoColaView>
                <TreinaColaView>
                    <TreinamentoColaButton onPress={() => handleRemoverTreinamento(p)} >
                        <TreiText>Remover</TreiText>
                    </TreinamentoColaButton>
                </TreinaColaView>
            </TreinamentoColaArea>
        )
    })

    if (loading) {
        return (
            <Container>
                <LoadingView>
                    <ActivityIndicator size='large' color='white' />
                    <LoadingText>Carregando...</LoadingText>
                </LoadingView>
            </Container>
        );
    } else {

        return (
            <Container>
                <ListScroll>
                    <Titulo>Possiveis Treinamentos</Titulo>
                    <TreinamentoColaView>
                        <TreinamentoButton onPress={() => navigation.navigate('Cadastrar Treinamento')} >
                            <TreiText>Cadastrar Treinamentos</TreiText>
                        </TreinamentoButton>
                    </TreinamentoColaView>
                    <TreinamentoColaView>
                        <TreinamentoButton onPress={() => navigation.navigate('Inserir Treinamentos em Conhecimento')} >
                            <TreiText>Inserir</TreiText>
                        </TreinamentoButton>
                    </TreinamentoColaView>
                    {treinamentos}
                </ListScroll>
            </Container>

        );
    }
};