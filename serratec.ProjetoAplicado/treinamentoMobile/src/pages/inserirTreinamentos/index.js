import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container, TreinamentoArea, CarText, ProScroll, TreinaView,TreinamentoButton, TreinamentoText, InserirText, InserirView, CardText, CardView, PickerView} from './styles';
import { LoadingView, LoadingText } from '../../components/loadingStyle/loading';
import { Alert, ActivityIndicator } from 'react-native';
import { Picker } from '@react-native-picker/picker';

export default function CadastroTreinamentos({ route, navigation }) {
    const { colaborador } = route.params

    const [treinamentos, setTreinamentos] = useState([]);
    const [linkTreina, setLinkTreina] = useState({
        status: ''
    })

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        axios.get('https://api-treinamento-t2m.herokuapp.com/treinamentos')
            .then((response) => {
                setTreinamentos(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);


    const LinkarTreinamento = async (p) => {
        try {
            await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsTrns/colaborador/${colaborador.idColaboradores}/treinamentoAInserir/${p.idTreinamentos}`, linkTreina)
            Alert.alert('Treinamento Inserido com sucesso!')
            navigation.reset({
                routes: [{ name: 'Lista de Colaboradores' }]
            })
        } catch (error) {
            Alert.alert('Ocorreu um erro. Cheque se o "status" foi passado...')
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
    } else {

        return (
            <Container>
                <ProScroll>
                    <TreinaView>
                        <InserirText> Inserir Treinamento </InserirText>
                    </TreinaView>
                    <TreinamentoArea>
                        {treinamentos.map((p, i) => {
                            return (
                                <InserirView key={i}>
                                    <CardView>
                                        <CardText>Nome:</CardText>
                                        <CarText>{p.nome}</CarText>
                                    </CardView>
                                    <CardView>
                                        <CardText>Descrição:</CardText>
                                        <CarText>{p.descricao}</CarText>
                                    </CardView>
                                    <CardView>
                                        <CardText>Carga Horária:</CardText>
                                        <CarText>{p.cargaHoraria} Hora(s)</CarText>
                                    </CardView>
                                    <CardView>
                                        <CardText>instituição:</CardText>
                                        <CarText>{p.instituicao}</CarText>
                                    </CardView>
                                    <CardView>
                                        <PickerView>
                                            <Picker
                                                mode='dropdown'
                                                itemStyle={{ color: '#181818' }}
                                                selectedValue={linkTreina}
                                                onValueChange={(itemValue) => setLinkTreina({ ...linkTreina, status: itemValue })}>
                                                <Picker.Item color='#181818' label='Status' value='' />
                                                <Picker.Item color='#181818' label='Em andamento' value='Em andamento' />
                                                <Picker.Item color='#181818' label='Concluído' value='Concluído' />
                                            </Picker>
                                        </PickerView>
                                    </CardView>
                                        <TreinamentoButton onPress={() => LinkarTreinamento(p)}>
                                            <TreinamentoText>Inserir</TreinamentoText>
                                        </TreinamentoButton>
                                </InserirView>
                            )
                        })}
                    </TreinamentoArea>
                </ProScroll>
            </Container>
        )
    }
}