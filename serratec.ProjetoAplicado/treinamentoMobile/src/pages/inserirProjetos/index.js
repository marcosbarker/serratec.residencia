import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container, EspacoView, ProjetoArea, CarText, ProScroll, ButtonView, InputCadastro, ProjetoButton, ProjetoText, InserirText, InserirView, CardText, CardView, ProjetoView, DateView } from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import { Alert, ActivityIndicator } from 'react-native';
import { handleDate } from '../../components/dataFormatada';
import DatePicker from 'react-native-datepicker';

export default function CadastroProjetos({ route, navigation }) {

    const { colaborador } = route.params

    const [projetos, setProjetos] = useState([]);
    const [linkProj, setLinkProj] = useState({
        funcao: '',
        dataInicio: ''
    });

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get('https://api-treinamento-t2m.herokuapp.com/projetos')
            .then((response) => {
                setProjetos(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);


    const LinkarProjeto = async (p) => {
        try {
            await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsProjs/colaborador/${colaborador.idColaboradores}/projetoAInserir/${p.idProjetos}`, linkProj)
            Alert.alert('Projeto Inserido com sucesso!')
            navigation.reset({
                routes: [{ name: 'Lista de Colaboradores' }]
            })
        } catch (error) {
            Alert.alert('Envio de dados nao permitido, cheque as informações passadas');
            console.error(error);
        }
    }

    if (loading) {
        return (
            <Container>
                <LoadingView>
                    <ActivityIndicator size='large' color='white' />
                    <LoadingText>Carregando...</LoadingText>
                </LoadingView>
            </Container>
        )
    }

    return (
        <Container>
            <ProScroll>
                <EspacoView></EspacoView>
                <ProjetoView>
                    <InserirText> Inserir Projeto </InserirText>
                </ProjetoView>
                <ProjetoArea>
                    {projetos.map((p, i) => {
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
                                <CardView>
                                    <CarText>App Gerenciador:</CarText>
                                    <CardText>{p.appGerenciamento}</CardText>
                                </CardView>
                                <CardView>
                                    <CarText>Segmento:</CarText>
                                    <CardText>{p.segmento}</CardText>
                                </CardView>
                                <CardView>
                                    <CarText>Data de entrega esperada:</CarText>
                                    <CardText>{handleDate(p.dataEntregaEsperada)}</CardText>
                                </CardView>
                                <CardView>
                                    <CarText>Data de entrega:</CarText>
                                    <CardText>{handleDate(p.dataEntrega)}</CardText>
                                </CardView>
                                <CardView>
                                    <CarText>N° de integrantes:</CarText>
                                    <CardText>{p.equipe}</CardText>
                                </CardView>
                                <ButtonView>
                                    <InputCadastro onChangeText={(text) => setLinkProj({ ...linkProj, funcao: text })} placeholder='Função' placeholderTextColor='#181818' />
                                    <DateView>
                                        <DatePicker style={{ width: 200, fontSize: 20 }}
                                            customStyles={{
                                                dateInput: {
                                                    borderWidth: 0,
                                                    borderBottomWidth: 0,

                                                },
                                                placeholderText: {
                                                    fontSize: 17,
                                                    color: '#181818'
                                                },
                                                dateText: {
                                                    fontSize: 21,
                                                    color: "#181818"
                                                }
                                            }}
                                            placeholder='Data de Início'
                                            date={linkProj.dataInicio}
                                            format='YYYY-MM-DD'
                                            minDate='2001-01-01'
                                            maxDate={new Date()}
                                            onDateChange={(data) => setLinkProj({ ...linkProj, dataInicio: data })} />
                                    </DateView>
                                    <ProjetoButton onPress={() => LinkarProjeto(p)}>
                                        <ProjetoText>Inserir</ProjetoText>
                                    </ProjetoButton>
                                </ButtonView>
                            </InserirView>
                        )
                    })}
                </ProjetoArea>
            </ProScroll>
        </Container>
    )
}