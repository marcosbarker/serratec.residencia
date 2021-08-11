import React, { useState, useEffect } from 'react';
import {
    Container,
    ProjetoScroll,
    Titulo,
    ProjetoView,
    ProjetoText,
    ProjeText,
    ProjetoButton,
    ProjetoArea,
    DadosView,
    DadosText,
    EndView,
    EndButton,
    EndText
} from './styles';
import MenuIcon from '../../components/icon';
import { handleDate } from '../../components/dataFormatada';
import { Alert } from 'react-native';
import axios from 'axios';
import { AuthContext } from '../../services/auth';

export default function Projetos({ route, navigation }) {

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

    function handleNavProj() {
        navigation.navigate('Inserir Projetos em Colaborador', { colaborador });
    }

    async function handleRemoveProj(p) {
        await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsProjs/colaborador/${colaboradores.idColaboradores}/projetoARemover/${p.projeto.idProjetos}`);
        Alert.alert("Projeto removido com sucesso!");
        setRefresh(!refresh);
    };

    return (
        <Container>
            <ProjetoScroll>
                <MenuIcon />
                <Titulo>Projetos:</Titulo>
                {colaboradores.setColabsProjs.map((p, i) => {
                    return (
                        <ProjetoArea key={i}>
                            <ProjetoView>
                                <ProjetoText>Nome: </ProjetoText>
                            </ProjetoView>
                            <DadosView>
                                <DadosText>{p.projeto.nome}</DadosText>
                            </DadosView>
                            <ProjetoView>
                                <ProjetoText>Descrição: </ProjetoText>
                            </ProjetoView>
                            <DadosView>
                                <DadosText>{p.projeto.descricao}</DadosText>
                            </DadosView>
                            <ProjetoView>
                                <ProjetoText>App Gerenciador: </ProjetoText>
                            </ProjetoView>
                            <DadosView>
                                <DadosText>{p.projeto.appGerenciamento}</DadosText>
                            </DadosView>
                            <ProjetoView>
                                <ProjetoText>Segmento: </ProjetoText>
                            </ProjetoView>
                            <DadosView>
                                <DadosText>{p.projeto.segmento}</DadosText>
                            </DadosView>
                            <ProjetoView>
                                <ProjetoText>Entrega esperada: </ProjetoText>
                            </ProjetoView>
                            {handleDate(p.projeto.dataEntregaEsperada)}
                            <ProjetoView>
                                <ProjetoText>Data de entrega: </ProjetoText>
                            </ProjetoView>
                            {handleDate(p.projeto.dataEntrega)}
                            <ProjetoView>
                                <ProjetoText>N° de integrantes: </ProjetoText>
                            </ProjetoView>
                            <DadosView>
                                <DadosText>{p.projeto.equipe}</DadosText>
                            </DadosView>
                            <EndView>
                                <EndButton onPress={() => handleRemoveProj(p)}>
                                    <EndText>Deletar</EndText>
                                </EndButton>
                            </EndView>
                        </ProjetoArea>
                    )
                })}
                <ProjetoView>
                    <ProjetoButton onPress={() => handleNavProj()}>
                        <ProjeText>Inserir Projetos</ProjeText>
                    </ProjetoButton>
                </ProjetoView>
            </ProjetoScroll>
        </Container>
    )
}
