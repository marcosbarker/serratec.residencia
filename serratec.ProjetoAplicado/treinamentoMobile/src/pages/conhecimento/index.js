import React, { useEffect, useState } from 'react';
import { Container, ListScroll, TreinaText, TreText, TreinaButton, TreinaColaView, Titulo, TreinamentoButton, TreinamentoColaArea, TreinamentoColaView, TreinamenText } from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import { AuthContext } from '../../services/auth';
import { Alert, ActivityIndicator } from 'react-native';
import axios from 'axios';

export default function Conhecimento({ navigation }) {

    const { competencia, setConhecimento, setCompetencia } = React.useContext(AuthContext);
    const [refresh, setRefresh] = useState(false);
    const [loading, setLoading] = useState(true);

    const handleClick = (p) => {
        setConhecimento(p.conhecimento);
        navigation.navigate('Treinamentos');
    }

    async function handleRemoverConhecimento(p) {
        await axios.put(`https://api-treinamento-t2m.herokuapp.com/compsCons/competencia/${competencia.idCompetencias}/conhecimentoARemover/${p.conhecimento.idConhecimentos}`);
        Alert.alert("Conhecimento removido com sucesso!");
        setRefresh(!refresh)
    };

    useEffect(async () => {
        const responseCompetencia = await axios.get(`https://api-treinamento-t2m.herokuapp.com/competencias/${competencia.idCompetencias}`)
        setCompetencia(responseCompetencia.data);
        setLoading(false);
    }, [refresh]);

    const posicaoMap = competencia.setCompsCons.map((p, i) => {
        return (
            <TreinamentoColaArea key={i} >
                <TreinamentoColaView>
                    <TreinaText>Nome: </TreinaText>
                    <TreinamenText>{p.conhecimento.nome}</TreinamenText>
                </TreinamentoColaView>
                <TreinamentoColaView>
                    <TreinaText>Descrição: </TreinaText>
                    <TreinamenText>{p.conhecimento.descricao}</TreinamenText>
                </TreinamentoColaView>
                <TreinamentoColaView>
                    <TreinamentoButton onPress={() => handleClick(p)}>
                        <TreText>Possiveis Treinamentos</TreText>
                    </TreinamentoButton>
                </TreinamentoColaView>
                <TreinaColaView>
                    <TreinaButton onPress={() => handleRemoverConhecimento(p)}>
                        <TreText>Remover</TreText>
                    </TreinaButton>
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
                    <Titulo>Conhecimentos</Titulo>
                    <TreinamentoColaView>
                        <TreinamentoButton onPress={() => navigation.navigate('Cadastrar Conhecimento')}>
                            <TreText>Cadastar Conhecimento</TreText>
                        </TreinamentoButton>
                    </TreinamentoColaView>
                    <TreinamentoColaView>
                        <TreinamentoButton onPress={() => navigation.navigate('Inserir Conhecimento')}>
                            <TreText>Inserir Conhecimento</TreText>
                        </TreinamentoButton>
                    </TreinamentoColaView>
                    {posicaoMap}
                </ListScroll>
            </Container>

        );
    }
};