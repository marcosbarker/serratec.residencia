import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
import { AuthContext } from "../../providers/auth";
import { Formik } from "formik";
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


const PesquisaTreinamento = () => {
  const history = useHistory();
  const { setPosicao } = React.useContext(AuthContext);
  const [posicoes, setPosicoes] = useState([]);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    api
      .get("/posicoes")
      .then((response) => {setPosicoes(response.data); console.log(response.data)})
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, [refresh]);

  const handleCompetencia = (p) => {
    setPosicao(p)
    history.push('/competencias')
  };

  const handleAtualizarPosicao = (p) => {
    setPosicao(p)
    history.push('/atualizarposicao')
  };

  async function handleRemoverPosicao(p) {
    await api.delete(`/posicoes/${p.idPosicoes}`);
    alert("Posição removida com sucesso!");
    setRefresh(!refresh);
  };

  const posicoesMap = posicoes.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.nome}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
        <p>
            <b>Descrição: </b>
            {p.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleCompetencia(p)}>Requisitos para ocupação</Button>
        <Button onClick={() => handleAtualizarPosicao(p)}>Atualizar</Button>
        <Button onClick={() => handleRemoverPosicao(p)}>Remover</Button>
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
          <Titulos>Posições</Titulos>
        </DivTitulo>
        <LinkButton to='/cadastrarposicoes'>Cadastrar posição</LinkButton>
      </DivHeader>
      <CardDiv>{posicoesMap}</CardDiv>
    </DivPrincipal>
  );
};

export default PesquisaTreinamento;
