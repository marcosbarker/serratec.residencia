import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import { AuthContext } from "../../providers/auth";
import {
  CardColaboradorDiv,
  CardColaboradorDivInterna,
  BotoesDiv,
  Button,
  CardDiv,
} from "./styles";
import { LinkButton } from "../../components/LinkButton/styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";
import api from "../../services/api";

const Treinamentos = () => {
  const history = useHistory();
  const { conhecimento, setConhecimento } = React.useContext(AuthContext);
  const [refresh, setRefresh] = useState(false);
  console.log(conhecimento);

  async function handleRemoverTreinamento(p) {
    await api.put(`/consTrns/conhecimento/${conhecimento.idConhecimentos}/treinamentomentoARemover/${p.treinamento.idTreinamentos}`);
    alert("Conhecimento removido com sucesso!");
    setRefresh(!refresh)
  };

  useEffect(async () => {
    const responseConhecimento = await api.get(`/conhecimentos/${conhecimento.idConhecimentos}`)
    setConhecimento(responseConhecimento.data)
  }, [refresh]);

  const treinamentos = conhecimento.setConsTrns.map((p, i) => (
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
            <b>Carga Horaria: </b>
            {p.treinamento.cargaHoraria}h
          </p>
          <p>
            <b>Descricao: </b>
            {p.treinamento.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={()=>handleRemoverTreinamento} >Remover</Button>
      </BotoesDiv>
      {/* <BotoesDiv>
        <Button onClick={() => handleRequisitos(p)}>Requisitos para ocupação</Button>
      </BotoesDiv> */}
    </CardDiv>
  ));
  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Treinamentos</Titulos>
        </DivTitulo>
        <LinkButton to='/cadastrartreinamentos'>Cadastrar treinamentos</LinkButton>
        <LinkButton to='/inserirtreinamento'>Inserir treinamento</LinkButton>
      </DivHeader>
      <CardDiv>{treinamentos}</CardDiv>
    </DivPrincipal>
  );
};

export default Treinamentos;
