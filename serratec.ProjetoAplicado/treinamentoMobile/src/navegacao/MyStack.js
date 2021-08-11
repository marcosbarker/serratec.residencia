import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import Login from '../pages/login';
import Home from '../pages/Home';
import ListaColaboradores from '../pages/listaColaboradores';
import ListaPosicao from '../pages/ListaPosicao';
import InformacoesColaboradores from '../pages/informacoesColaboradores';
import Cadastro from '../pages/cadastro';
import CadastroEndereco from '../pages/inserirEndereco';
import InserirCertificados from '../pages/inserirCertificacao';
import InserirTreinamentos from '../pages/inserirTreinamentos';
import InserirFormacoes from '../pages/inserirFormacoes';
import InserirProjetos from '../pages/inserirProjetos';
import AtualizarEndereco from '../pages/atualizarEndereco';
import Projetos from '../pages/projetos';
import Formacoes from '../pages/formacoes';
import Certificacoes from  '../pages/certificacao';
import Treinamentos from '../pages/treinamentos';
import PossiveisTreinamentos from '../pages/possiveisTreinamentos';
import AtualizarColaboradores from '../pages/atualizarColaboradores';
import Competencia from '../pages/competencias';
import Conhecimento from '../pages/conhecimento'
import InserirConhecimento from '../pages/inserirConhecimento';
import NovasPosicao from '../pages/novasPosicao';
import InserirCompetencia from '../pages/InserirCompetencia';
import NovasCompetencias from '../pages/novasCompetencias';
import AdicionarTreinamentos from '../pages/adicionarTreinamentos';
import NovoConhecimento from '../pages/novosConhecimentos';
import NovosTreinamentos from '../pages/novosTreinamentos';

const Stack = createStackNavigator();

export default function MyStack() {
    return (
        <Stack.Navigator
            initialRouteName='Login'
            screenOptions={{ headerTransparent: true, headerShown: false }}>
            <Stack.Screen name='Login' component={Login} />
            <Stack.Screen name='Home' component={Home} />
            <Stack.Screen name='Lista de Colaboradores' component={ListaColaboradores} />
            <Stack.Screen name='Lista de Posições' component={ListaPosicao} />
            <Stack.Screen name='Informações Colaboradores' component={InformacoesColaboradores} />
            <Stack.Screen name='Cadastro' component={Cadastro} />
            <Stack.Screen name='Atualizar Colaborador' component={AtualizarColaboradores} />
            <Stack.Screen name='Atualizar Endereço' component={AtualizarEndereco} />
            <Stack.Screen name='Inserir Endereço em Colaborador' component={CadastroEndereco} />
            <Stack.Screen name='Inserir Certificações em Colaborador' component={InserirCertificados} />
            <Stack.Screen name='Inserir Treinamentos em Colaborador' component={InserirTreinamentos} />
            <Stack.Screen name='Inserir Treinamentos em Conhecimento' component={AdicionarTreinamentos} />
            <Stack.Screen name='Inserir Formações em Colaborador' component={InserirFormacoes} />
            <Stack.Screen name='Inserir Projetos em Colaborador' component={InserirProjetos} />
            <Stack.Screen name='Inserir Conhecimento' component={InserirConhecimento} />
            <Stack.Screen name='Inserir Competência' component={InserirCompetencia} />
            <Stack.Screen name='Treinamentos de um colaborador' component={Treinamentos} />
            <Stack.Screen name='Treinamentos' component={PossiveisTreinamentos} />
            <Stack.Screen name='Certificações de um colaborador' component={Certificacoes} />
            <Stack.Screen name='Formações de um colaborador' component={Formacoes} />
            <Stack.Screen name='Projetos de um colaborador' component={Projetos} />
            <Stack.Screen name='Competências por posição' component={Competencia} />
            <Stack.Screen name='Conhecimentos por competência' component={Conhecimento} />
            <Stack.Screen name='Cadastrar Posições' component={NovasPosicao} />
            <Stack.Screen name='Cadastrar Competência' component={NovasCompetencias} />
            <Stack.Screen name='Cadastrar Conhecimento' component={NovoConhecimento} />
            <Stack.Screen name='Cadastrar Treinamento' component={NovosTreinamentos} />
        </Stack.Navigator>
    );
};
