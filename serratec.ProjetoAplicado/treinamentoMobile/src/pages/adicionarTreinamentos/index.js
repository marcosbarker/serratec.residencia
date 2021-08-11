import React, { useEffect, useState } from 'react';
import { Container, InserirTreinaView, ProjetoArea, ProScroll, CardText, CarText, ProjetoButton, ProjetoText, InserirText, InserirView, CardView, ProjetoView } from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import { AuthContext } from '../../services/auth';
import axios from 'axios';
import { Alert, ActivityIndicator } from 'react-native';

export default function AdicionarTreinamentos({ navigation }) {
    const { conhecimento, setConhecimento } = React.useContext(AuthContext);
    const [treinamentos, setTreinamentos] = useState([]);
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        axios.get(`https://api-treinamento-t2m.herokuapp.com/treinamentos`)
            .then((response) => {
                setTreinamentos(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
            });
    }, [])

    const handleClick = async (p) => {
        try {
            await axios.put(`https://api-treinamento-t2m.herokuapp.com/consTrns/conhecimento/${conhecimento.idConhecimentos}/treinamentoAInserir/${p.idTreinamentos}`)
            Alert.alert('Treinamento inserido com sucesso!')
            const responseConhecimento = await axios.get(`https://api-treinamento-t2m.herokuapp.com/conhecimentos/${conhecimento.idConhecimentos}`);
            setConhecimento(responseConhecimento.data);
            navigation.reset({
                routes: [{ name: 'Treinamentos' }]
            })
        } catch (error) {
            console.error(error);
        }
    }

    const treinamentosMap = treinamentos.map((p, i) => {
        return (
            <ProjetoArea key={i}>
                <InserirView>
                    <CardView>
                        <CarText>Nome:</CarText>
                        <CardText>{p.nome}</CardText>
                    </CardView>
                    <CardView>
                        <CarText>Descrição:</CarText>
                        <CardText>{p.descricao}</CardText>
                    </CardView>
                    <CardView>
                        <CarText>Instituição:</CarText>
                        <CardText>{p.instituicao}</CardText>
                    </CardView>
                    <CardView>
                        <CarText>Carga Horária:</CarText>
                        <CardText>{p.cargaHoraria} Hora(s)</CardText>
                    </CardView>
                    <InserirTreinaView>
                        <ProjetoButton onPress={() => handleClick(p)}>
                            <ProjetoText>Inserir</ProjetoText>
                        </ProjetoButton>
                    </InserirTreinaView>
                </InserirView>
            </ProjetoArea>
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
                <ProScroll>
                    <ProjetoView>
                        <InserirText> Inserir Treinamento</InserirText>
                    </ProjetoView>
                    {treinamentosMap}
                </ProScroll>
            </Container>
        )
    }
}
