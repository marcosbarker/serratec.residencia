import Login from './pages/Login';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import PesquisaColaborador from './pages/PesquisaColaborador'
import PesquisaTreinamento from './pages/PesquisaTreinamento'
import Treinamentos from './pages/Treinamentos';
import CadastrarColaboradores from './pages/CadastrarColaboradores';
import AtualizarColaborador from './pages/AtualizarColaborador'
import CadastrarCertificacoes from './pages/CadastrarCertificacoes'
import InserirCertificacao from './pages/InserirCertificacao'
import CadastrarEnderecos from './pages/CadastrarEnderecos'
import AtualizarEndereco from './pages/AtualizarEndereco'
import AtualizarPosicao from './pages/AtualizarPosicao'
import CadastrarFormacoes from './pages/CadastrarFormacoes'
import InserirFormacao from './pages/InserirFormacao'
import AtualizarFormacao from './pages/AtualizarFormacao'
import CadastrarProjetos from './pages/CadastrarProjetos'
import InserirProjetos from './pages/InserirProjetos'
import CadastrarTreinamentos from './pages/CadastrarTreinamentos'
import InserirTreinamento from './pages/InserirTreinamento'
import InserirCompetencia from './pages/InserirCompetencia'
import CadastrarCompetencias from './pages/CadastrarCompetencias'
import Colaborador from './pages/Colaborador';
import Competencias from './pages/Competencias'
import Conhecimentos from './pages/Conhecimentos'
import CadastrarPosicoes from './pages/CadastrarPosicoes'
import CadastrarConhecimentos from './pages/CadastrarConhecimentos'
import InserirConhecimento from './pages/InserirConhecimento'
import { AuthProvider } from './providers/auth';
import RoutesPrivate from './components/Routes/Private';
import { Container } from './components/Container/styles';

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Switch>
          <Container>
            <Route path="/" exact component={Login} />
            <RoutesPrivate path="/home" exact component={Home} />
            <RoutesPrivate path="/pesquisacolaborador" exact component={PesquisaColaborador} />
            <RoutesPrivate path="/pesquisatreinamento" exact component={PesquisaTreinamento} />
            <RoutesPrivate path="/treinamentos" exact component={Treinamentos} />            
            <RoutesPrivate path="/colaborador" exact component={Colaborador} />
            <RoutesPrivate path="/competencias" exact component={Competencias} />
            <RoutesPrivate path="/inserircompetencia" exact component={InserirCompetencia} />
            <RoutesPrivate path="/cadastrarcompetencias" exact component={CadastrarCompetencias} />
            <RoutesPrivate path="/conhecimentos" exact component={Conhecimentos} />
            <RoutesPrivate path="/cadastrarcolaboradores" exact component={CadastrarColaboradores} />
            <RoutesPrivate path="/atualizarcolaborador" exact component={AtualizarColaborador} />
            <RoutesPrivate path="/atualizarposicao" exact component={AtualizarPosicao} />
            <RoutesPrivate path="/cadastrarcertificacoes" exact component={CadastrarCertificacoes} />
            <RoutesPrivate path="/cadastrarposicoes" exact component={CadastrarPosicoes} />
            <RoutesPrivate path="/inserircertificacao" exact component={InserirCertificacao} />
            <RoutesPrivate path="/cadastrarenderecos" exact component={CadastrarEnderecos} />
            <RoutesPrivate path="/atualizarendereco" exact component={AtualizarEndereco} />
            <RoutesPrivate path="/atualizarformacao" exact component={AtualizarFormacao} />
            <RoutesPrivate path="/cadastrarformacoes" exact component={CadastrarFormacoes} />
            <RoutesPrivate path="/inserirformacao" exact component={InserirFormacao} />
            <RoutesPrivate path="/cadastrarprojetos" exact component={CadastrarProjetos} />
            <RoutesPrivate path="/inserirprojetos" exact component={InserirProjetos} />
            <RoutesPrivate path="/cadastrartreinamentos" exact component={CadastrarTreinamentos} />
            <RoutesPrivate path="/inserirtreinamento" exact component={InserirTreinamento} />
            <RoutesPrivate path="/cadastrarconhecimentos" exact component={CadastrarConhecimentos} />
            <RoutesPrivate path="/inserirconhecimento" exact component={InserirConhecimento} />
          </Container>
        </Switch>
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;
