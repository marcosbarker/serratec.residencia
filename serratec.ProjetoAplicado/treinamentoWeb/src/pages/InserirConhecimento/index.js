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
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";

const InserirConhecimentos = () => {
  const history = useHistory();
  const { competencia, setCompetencia } = React.useContext(AuthContext);
  const [conhecimentos, setConhecimentos] = useState([]);

  useEffect(() => {
    api
      .get("/conhecimentos")
      .then((response) => setConhecimentos(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);

  async function handleClick(p) {
    await api.put(`/compsCons/competencia/${competencia.idCompetencias}/conhecimentoAInserir/${p.idConhecimentos}`)
    alert('Conhecimento inserido com sucesso!')
    const responseCompetencia = await api.get(`/competencias/${competencia.idCompetencias}`);
    setCompetencia(responseCompetencia.data)
    console.log(competencia);
    history.push('/conhecimentos')
  };

  const conhecimentosMap = conhecimentos.map((p, i) => (
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
        <Button onClick={() => handleClick(p)}>Inserir conhecimento</Button>
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
          <Titulos>Conhecimentos</Titulos>
        </DivTitulo>
      </DivHeader>
      <CardDiv>{conhecimentosMap}</CardDiv>
    </DivPrincipal>
  );
};

export default InserirConhecimentos;
