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
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";

const InserirConpetencia = () => {
  const history = useHistory();
  const { posicao, setPosicao } = React.useContext(AuthContext);
  const [competencias, setCompetencias] = useState([]);

  useEffect(() => {
    api
      .get("/competencias")
      .then((response) => setCompetencias(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);

  async function handleClick(p) {
    console.log(p);
    await api.put(`/posComps/posicao/${posicao.idPosicoes}/competenciaAInserir/${p.idCompetencias}`)
    alert('Competência inserida com sucesso!')
    const responsePosicao = await api.get(`/posicoes/${posicao.idPosicoes}`);
    setPosicao(responsePosicao.data)
    history.push('/competencias')
  };

  const competenciasMap = competencias.map((p, i) => (
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
        <Button onClick={() => handleClick(p)}>Inserir competência</Button>
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
          <Titulos>Competências</Titulos>
        </DivTitulo>
      </DivHeader>
      <CardDiv>{competenciasMap}</CardDiv>
    </DivPrincipal>
  );
};

export default InserirConpetencia;
