import React, { useState } from 'react';
import axios from 'axios';
import { Container, TreinaScroll, InputArea, InputCadastro, CertiButton, CertiText, ButtonView, CadastroText, CadastroView, CertiView } from './styles';
import { Alert } from 'react-native';

export default function NovosTreinamentos({ navigation }) {
    const [treinamento, setTreinamento] = useState({
        nome: '',
        descricao: '',
        instituicao: '',
        cargaHoraria: 0
    })

    const postTreinamento = async () => {
        try {
            await axios.post(`https://api-treinamento-t2m.herokuapp.com/treinamentos`, {
                nome: treinamento.nome,
                descricao: treinamento.descricao,
                instituicao: treinamento.instituicao,
                cargaHoraria: parseInt(treinamento.cargaHoraria)
            })
            Alert.alert('Treinamento cadastrado com sucesso!')
            navigation.reset({
                routes: [{ name: 'Treinamentos' }]
            })
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <Container>
            <TreinaScroll>
                <CadastroView>
                    <CadastroText>Novos Treinamentos </CadastroText>
                </CadastroView>
                <InputArea>
                    <CertiView>
                        <CertiText>Nome do treinamento:</CertiText>
                        <InputCadastro onChangeText={(text) => setTreinamento({ ...treinamento, nome: text })} placeholder='Nome' placeholderTextColor='#181818' />
                    </CertiView>
                    <CertiView>
                        <CertiText>Descrição do treinamento:</CertiText>
                        <InputCadastro onChangeText={(text) => setTreinamento({ ...treinamento, descricao: text })} placeholder='Descrição' placeholderTextColor='#181818' />
                    </CertiView>
                    <CertiView>
                        <CertiText>Instituição:</CertiText>
                        <InputCadastro onChangeText={(text) => setTreinamento({ ...treinamento, instituicao: text })} placeholder='Instituição' placeholderTextColor='#181818' />
                    </CertiView>
                    <CertiView>
                        <CertiText>Carga Horária:</CertiText>
                        <InputCadastro onChangeText={(text) => setTreinamento({ ...treinamento, cargaHoraria: text })} keyboardType='numeric' placeholder='Carga Horaria' placeholderTextColor='#181818' />
                    </CertiView>
                    <ButtonView>
                        <CertiButton onPress={() => postTreinamento()}>
                            <CertiText>Salvar</CertiText>
                        </CertiButton>
                    </ButtonView>
                </InputArea>
            </TreinaScroll>
        </Container>
    )
}