import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
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

const Competencias = () => {
  const history = useHistory();
  const { posicao, setPosicao, setCompetencia } = React.useContext(AuthContext);
  const [refresh, setRefresh] = useState(false);
  console.log(posicao);

  const handleConhecimentos = (p) => {
    setCompetencia(p.competencia)
    history.push('/conhecimentos')
  };

  async function handleRemoverCompetencia(p) {
    await api.put(`/posComps/posicao/${posicao.idPosicoes}/competenciaARemover/${p.competencia.idCompetencias}`);
    alert("Competencia removida com sucesso!");
    setRefresh(!refresh);
  };

  useEffect(async () => {
    const responsePosicao = await api.get(`/posicoes/${posicao.idPosicoes}`)
    setPosicao(responsePosicao.data)
  }, [refresh]);

  const posicaoMap = posicao.setPosComps.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.competencia.nome}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
        <p>
            <b>Descrição: </b>
            {p.competencia.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleConhecimentos(p)}>Conhecimentos</Button>
        <Button onClick={() => handleRemoverCompetencia(p)}>Remover</Button>
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
          <Titulos>{posicao.nome}: Competências</Titulos>
        </DivTitulo>
        <LinkButton to='/inserircompetencia'>Inserir competência</LinkButton>
        <LinkButton to='/cadastrarcompetencias'>Cadastrar competências</LinkButton>
      </DivHeader>
      <CardDiv>{posicaoMap}</CardDiv>
    </DivPrincipal>
  );
};

export default Competencias;
