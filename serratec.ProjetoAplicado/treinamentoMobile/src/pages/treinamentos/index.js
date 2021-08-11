import React, { useState, useEffect } from 'react';
import { Container, TreinArea, TreinamentosText, ButtonView, TreinView, TreinText, DadosView, DadosText, Titulo, TreinScroll, TreinamentosButton, EndView, EndButton, EndText } from './styles';
import { Alert } from 'react-native';
import axios from 'axios';
import { AuthContext } from '../../services/auth';

export default function Treinamentos({ route, navigation }) {
    
    const { colaborador } = route.params

    const { colaboradores, setColaboradores } = React.useContext(AuthContext);


    const [refresh, setRefresh] = useState(false);

    const getColab = async () => {
        try {
            const responseColab = await axios.get(`https://api-treinamento-t2m.herokuapp.com/colaboradores/${colaboradores.idColaboradores}`);
            setColaboradores(responseColab.data);
        } catch (error) {
            Alert.alert('Ocorreu um erro... ' + error);
        }
    }

    useEffect(() => {
        getColab()
    }, [refresh]);

    function handleNavTrein() {
        navigation.navigate('Inserir Treinamentos em Colaborador', { colaborador })
    }

    async function handleRemoveTrein(p) {
        await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsTrns/colaborador/${colaboradores.idColaboradores}/treinamentoARemover/${p.treinamento.idTreinamentos}`);
        Alert.alert("Treinamento removido com sucesso!");
        setRefresh(!refresh);
    };

    return (
        <Container>
            <TreinScroll>
                <Titulo>Treinamentos:</Titulo>
                {colaboradores.setColabsTrns.map((p, i) => {
                    return (
                        <TreinArea key={i}>
                            <TreinView>
                                <TreinText>Nome: </TreinText>
                            </TreinView>
                            <DadosView>
                                <DadosText>{p.treinamento.nome}</DadosText>
                            </DadosView>
                            <TreinView>
                                <TreinText>Descrição: </TreinText>
                            </TreinView>
                            <DadosView>
                                <DadosText>{p.treinamento.descricao}</DadosText>
                            </DadosView>
                            <TreinView>
                                <TreinText>Caga Horária: </TreinText>
                            </TreinView>
                            <DadosView>
                                <DadosText>{p.treinamento.cargaHoraria} Hora(s)</DadosText>
                            </DadosView>
                            <TreinView>
                                <TreinText>Instituição: </TreinText>
                            </TreinView>
                            <DadosView>
                                <DadosText>{p.treinamento.instituicao}</DadosText>
                            </DadosView>
                            <EndView>
                                <EndButton onPress={() => handleRemoveTrein(p)}>
                                    <EndText>Deletar</EndText>
                                </EndButton>
                            </EndView>
                        </TreinArea>
                    )
                })}

                <ButtonView>
                    <TreinamentosButton onPress={() => handleNavTrein()}>
                        <TreinamentosText>Inserir Treinamento</TreinamentosText>
                    </TreinamentosButton>
                </ButtonView>

            </TreinScroll>
        </Container>
    )
}