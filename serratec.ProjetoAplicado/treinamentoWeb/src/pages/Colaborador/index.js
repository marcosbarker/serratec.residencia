import React, { useEffect, useState } from "react";
import { AuthContext } from "../../providers/auth";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
import {
  CardColaboradorDiv,
  CardColaboradorDivInterna,
  ColaboradorTituloDiv,
  Titulo,
  BotoesDiv,
  ButtonLink,
  Button,
  CardDiv,
  BotaoIns,
  LinkButton,
  LinkButtonIns,
} from "./styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";

const Colaborador = () => {
  const history = useHistory();
  const { colaborador, setColaborador, setEndereco, setFormacao } = React.useContext(AuthContext);

  const [refresh, setRefresh] = useState(false);

  useEffect(() => {  
    console.log(colaborador);  
    api.get(`/colaboradores/${colaborador.idColaboradores}`)
    .then((response) => setColaborador(response.data))
    .catch((err) => {
      console.error("ops! ocorrei um erro" + err);
    });
  }, [refresh]);

  const handleDate = (props) => {
    const data = new Date(props);
    const dia = (data.getDate() + 1).toString().padStart(2, "0");
    const mes = (data.getMonth() + 1).toString().padStart(2, "0");
    const ano = data.getFullYear();
    const dataFormatada = `${dia}/${mes}/${ano}`;
    return dataFormatada;
  };

  const handlePermissao = (props) => {
    if (props === 2) {
      return (
        <p>
          <b>Permissão: </b>
          Administrador
        </p>
      );
    } else if (props === 1) {
      return (
        <p>
          <b>Permissão: </b>
          Líder
        </p>
      );
    } else {
      return (
        <p>
          <b>Permissão: </b>
          Colaborador
        </p>
      );
    }
  };
  function handleAtualizarEndereco(p) {
    setEndereco(p);
  };
  function handleAtualizarFormacao(p) {
    setFormacao(p);
  };
  async function handleDeleteColab(){
    await api.delete(`/colaboradores/${colaborador.idColaboradores}`);
    alert("Delete colaborador realizado com sucesso!");
    history.push("/pesquisacolaborador")
  };
  async function handleRemoveProj(p){
    await api.put(`/colabsProjs/colaborador/${colaborador.idColaboradores}/projetoARemover/${p.projeto.idProjetos}`);
    alert("Projeto removido com sucesso!");
    setRefresh(!refresh);
  };
  async function handleRemoveEnd(p){
    await api.put(`/colabsEndrs/colaborador/${colaborador.idColaboradores}/enderecoARemover/${p.endereco.idEnderecos}`);
    alert("Endereço removido com sucesso!");
    setRefresh(!refresh);
  };
  async function handleRemoveForm(p){
    await api.put(`/colabsForms/${colaborador.idColaboradores}/formacaoARemover/${p.formacao.idFormacoes}`);
    alert("Formação removida com sucesso!");
    setRefresh(!refresh);
  };
  async function handleRemoveTrein(p){
    await api.put(`/colabsTrns/colaborador/${colaborador.idColaboradores}/treinamentoARemover/${p.treinamento.idTreinamentos}`);
    alert("Treinamento removido com sucesso!");
    setRefresh(!refresh);
  };
  async function handleRemoveCert(p){
    await api.put(`/colabsCerts/colaborador/${colaborador.idColaboradores}/certificacaoARemover/${p.certificacao.idCertificacoes}`);
    alert("Certificação removida com sucesso!");
    setRefresh(!refresh);
  };
  const enderecos = colaborador?.setColabsEndrs?.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Rua: </b>
            {p.endereco.rua}
          </p>
          <p>
            <b>Número: </b>
            {p.endereco.numero}
          </p>
          <p>
            <b>Complemento: </b>
            {p.endereco.complemento}
          </p>
          <p>
            <b>Bairro: </b>
            {p.endereco.bairro}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Cidade: </b>
            {p.endereco.cidade}
          </p>
          <p>
            <b>Estado: </b>
            {p.endereco.estado}
          </p>
          <p>
            <b>País: </b>
            {p.endereco.pais}
          </p>
          <p>
            <b>CEP: </b>
            {p.endereco.cep}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <LinkButtonIns
          to="atualizarendereco"
          onClick={() => handleAtualizarEndereco(p)}
        >
          <ButtonLink>Atualizar</ButtonLink>
        </LinkButtonIns>
        <Button onClick={() => handleRemoveEnd(p)}>Remover</Button>
      </BotoesDiv>
    </CardDiv>
  ));
  const projetos = colaborador?.setColabsProjs?.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.projeto.nome}
          </p>
          <p>
            <b>Descrição: </b>
            {p.projeto.descricao}
          </p>
          <p>
            <b>Gerenciamento: </b>
            {p.projeto.appGerenciamento}
          </p>
          <p>
            <b>Segmento: </b>
            {p.projeto.segmento}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Data de entrega esperada: </b>
            {handleDate(p.projeto.dataEntregaEsperada)}
          </p>
          <p>
            <b>Data de entrega: </b>
            {handleDate(p.projeto.dataEntrega)}
          </p>
          <p>
            <b>Equipe: </b>
            {p.projeto.equipe}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleRemoveProj(p)}>Remover projeto</Button>
      </BotoesDiv>
    </CardDiv>
  ));
  const formacoes = colaborador?.setColabsForms?.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.formacao.nome}
          </p>
          <p>
            <b>Nível: </b>
            {p.formacao.nivel}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Instituição: </b>
            {p.formacao.instituicao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <LinkButtonIns to="atualizarformacao" 
        onClick={() => handleAtualizarFormacao(p)}>
          <ButtonLink>Atualizar</ButtonLink>
        </LinkButtonIns>
        <Button onClick={() => handleRemoveForm(p)}>Remover</Button>
      </BotoesDiv>
    </CardDiv>
  ));
  const treinamentos = colaborador?.setColabsTrns?.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.treinamento.nome}
          </p>
          <p>
            <b>Instituição: </b>
            {p.treinamento.instituicao}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Carga horária: </b>
            {p.treinamento.cargaHoraria} hora(s)
          </p>
          <p>
            <b>Descrição: </b>
            {p.treinamento.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleRemoveTrein(p)}>Remover</Button>
      </BotoesDiv>
    </CardDiv>
  ));
  const certificacoes = colaborador?.setColabsCerts?.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.certificacao.nomeCertificado}
          </p>
          <p>
            <b>Instituição: </b>
            {p.certificacao.instituicaoCertificado}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Validade: </b>
            {p.certificacao.tempoValidade} ano(s)
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleRemoveCert(p)}>Remover</Button>
      </BotoesDiv>
    </CardDiv>
  ));

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Informações do Colaborador(a)</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <CardDiv>
        <CardColaboradorDiv>
          <ColaboradorTituloDiv>
            <h2> Dados Cadastrais </h2>
          </ColaboradorTituloDiv>
          <CardColaboradorDivInterna>
            <p>
              <b>Nome: </b>
              {colaborador.nome}
            </p>
            <p>
              <b>CPF: </b>
              {colaborador.cpf}
            </p>
            <p>
              <b>CNH: </b>
              {colaborador.cnh}
            </p>
            <p>
              <b>RG: </b>
              {colaborador.rg}
            </p>
            <p>
              <b>PIX: </b>
              {colaborador.pix}
            </p>
          </CardColaboradorDivInterna>
          <CardColaboradorDivInterna>
            <p>
              <b>Email: </b>
              {colaborador.email}
            </p>
            <p>
              <b>Data de nascimento: </b>
              {handleDate(colaborador.dataNascimento)}
            </p>
            {handlePermissao(colaborador.permissao)}
            <p>
              <b>Posição: </b>
              {colaborador?.posicao?.nome}
            </p>
          </CardColaboradorDivInterna>
        </CardColaboradorDiv>
        <BotoesDiv>
          <LinkButtonIns to="atualizarcolaborador">
            <ButtonLink>Atualizar</ButtonLink>
          </LinkButtonIns>
          <Button onClick={() => handleDeleteColab()}>Remover</Button>
        </BotoesDiv>
      </CardDiv>
      <Titulo>Endereço:</Titulo>
      {enderecos}
      <BotoesDiv>
        <LinkButtonIns to="/cadastrarenderecos">
          <BotaoIns>Inserir endereço</BotaoIns>
        </LinkButtonIns>
      </BotoesDiv>
      <Titulo>Projetos:</Titulo>
      {projetos}
      <BotoesDiv>
        <LinkButtonIns to="inserirprojetos">
          <BotaoIns>Inserir projeto</BotaoIns>
        </LinkButtonIns>
        {/* <LinkButtonIns to="cadastrarprojetos">
          <BotaoIns>Criar projeto</BotaoIns>
        </LinkButtonIns> */}
      </BotoesDiv>
      <Titulo>Formações:</Titulo>
      {formacoes}
      <BotoesDiv>
        <LinkButtonIns to="inserirformacao">
          <BotaoIns>Inserir formação</BotaoIns>
        </LinkButtonIns>
      </BotoesDiv>
      <Titulo>Treinamentos:</Titulo>
      {treinamentos}
      <BotoesDiv>
        <LinkButtonIns to="inserirtreinamento">
          <BotaoIns>Inserir treinamento</BotaoIns>
        </LinkButtonIns>
      </BotoesDiv>
      <Titulo>Certificações:</Titulo>
      {certificacoes}
      <BotoesDiv>
        <LinkButtonIns to="inserircertificacao">
          <BotaoIns>Inserir certificação</BotaoIns>
        </LinkButtonIns>
      </BotoesDiv>
    </DivPrincipal>
  );
};

export default Colaborador;
