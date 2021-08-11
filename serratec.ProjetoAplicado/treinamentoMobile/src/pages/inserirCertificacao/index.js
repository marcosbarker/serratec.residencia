import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Container, TreinaScroll,CertText, EspacoView, InputArea, CertiButton, CertiText, DataView, ButtonView, CadastroText, CadastroView, MensagemArea, MensagemView, MensagemText, CertiView } from './styles';
import { Alert } from 'react-native';
import DateField from 'react-native-datefield';

export default function InserirCertificados({ route, navigation }) {
        const { colaborador } = route.params

        const [certificados, setCertificados] = useState([]);
        const [date, setDate] = useState({
            dataObtencao: ''
        });


        useEffect(() => {
            axios.get('https://api-treinamento-t2m.herokuapp.com/certificacoes')
                .then((response) => setCertificados(response.data))
                .catch((error) => {
                    console.error(error);
                });
        }, []);


        const putCertificacoes = async (p) => {
            try {
                await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsCerts/colaborador/${colaborador.idColaboradores}/certificacaoAInserir/${p.idCertificacoes}​`, date);
                Alert.alert('Certificação inserida com sucesso!')
                navigation.reset({
                    routes: [{ name: 'Lista de Colaboradores' }]
                })
            } catch (error) {
                Alert.alert('Envio de dados nao permitido, cheque as informações passadas');
                console.error(error);
            }
            
        }


        return (
            <Container>
                <TreinaScroll>
                    <CadastroView>
                        <CadastroText> Cadastro de Certificados </CadastroText>
                    </CadastroView>
                    {certificados.map((p, i) => {
                        return (
                            <InputArea key={i}>
                                <CertiView>
                                    <CertText>Nome:</CertText>
                                    <CertiText>{p.nomeCertificado}</CertiText>
                                </CertiView>
                                <CertiView>
                                    <CertText>Instituição:</CertText>
                                    <CertiText>{p.instituicaoCertificado}</CertiText>
                                </CertiView>
                                <CertiView>
                                    <CertText>Validade:</CertText>
                                    <CertiText>{p.tempoValidade}</CertiText>
                                    <CertText>Data de Obtenção:</CertText>
                                </CertiView>
                                <DataView>
                                    <DateField labelDate='Dia' labelMonth='Mês' labelYear='Ano' onSubmit={(value) => setDate({dataObtencao: value})} styleInput={{ fontSize: 22, paddingLeft: 5 }} />
                                </DataView>
                                <ButtonView>
                                    <CertiButton onPress={() => putCertificacoes(p)}>
                                        <CertiText>Salvar</CertiText>
                                    </CertiButton>
                                </ButtonView>
                            </InputArea>
                        )
                    })}
                   
                </TreinaScroll>
            </Container>
        )
}