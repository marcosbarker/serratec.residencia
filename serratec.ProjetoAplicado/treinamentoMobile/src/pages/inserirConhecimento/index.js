import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container, EspacoView, ProjetoArea, ProScroll, InserirConheView, ProjetoButton, ProjetoText, InserirText, InserirView, CarText, CardText, CardView, ProjetoView } from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import { Alert, ActivityIndicator } from 'react-native';
import { AuthContext } from '../../services/auth';

export default function InserirConhecimento({ navigation }) {
    const { competencia, setCompetencia } = React.useContext(AuthContext);
    const [conhecimentos, setConhecimento] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get(`https://api-treinamento-t2m.herokuapp.com/conhecimentos`)
            .then((response) => {
                setConhecimento(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
            })
    }, []);

    const handleClick = async (p) => {
        try {
            await axios.put(`https://api-treinamento-t2m.herokuapp.com/compsCons/competencia/${competencia.idCompetencias}/conhecimentoAInserir/${p.idConhecimentos}`)
            Alert.alert('Conhecimento inserido com sucesso!')
            const responseCompetencia = await axios.get(`https://api-treinamento-t2m.herokuapp.com/competencias/${competencia.idCompetencias}`);
            setCompetencia(responseCompetencia.data);
            navigation.reset({
                routes: [{ name: 'Conhecimentos por competência' }]
            })

        } catch (error) {

        }
    };
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
                <ProScroll>
                    <ProjetoView>
                        <InserirText> Inserir Conhecimento</InserirText>
                    </ProjetoView>
                    <ProjetoArea>
                        {conhecimentos.map((p, i) => {
                            return (
                                <InserirView key={i}>
                                    <CardView>
                                        <CarText>Nome:</CarText>
                                        <CardText>{p.nome}</CardText>
                                    </CardView>
                                    <CardView>
                                        <CarText>Descrção:</CarText>
                                        <CardText>{p.descricao}</CardText>
                                    </CardView>
                                    <InserirConheView>
                                        <ProjetoButton onPress={() => handleClick(p)}>
                                            <ProjetoText>Inserir</ProjetoText>
                                        </ProjetoButton>
                                    </InserirConheView>
                                </InserirView>
                            )
                        })}
                    </ProjetoArea>
                </ProScroll>
            </Container>
        )
    }
}
