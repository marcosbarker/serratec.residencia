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
  const { conhecimento, setConhecimento } = React.useContext(AuthContext);
  const [treinamentos, setTreinamentos] = useState([]);

  useEffect(() => {
    api
      .get("/treinamentos")
      .then((response) => setTreinamentos(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);

  async function handleClick(p) {
    await api.put(`/consTrns/conhecimento/${conhecimento.idConhecimentos}/treinamentoAInserir/${p.idTreinamentos}`)
    alert('Conhecimento inserido com sucesso!')
    const responseConhecimento = await api.get(`/conhecimentos/${conhecimento.idConhecimentos}`);
    setConhecimento(responseConhecimento.data)
    history.push('/treinamentos')
  };

  const treinamentosMap = treinamentos.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.nome}
          </p>
          <p>
            <b>Instituição: </b>
            {p.instituicao}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
        <p>
            <b>Carga Horaria: </b>
            {p.cargaHoraria}
          </p>
        <p>
            <b>Descrição: </b>
            {p.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleClick(p)}>Inserir treinamento</Button>
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
          <Titulos>Treinamentos</Titulos>
        </DivTitulo>
      </DivHeader>
      <CardDiv>{treinamentosMap}</CardDiv>
    </DivPrincipal>
  );
};

export default InserirConhecimentos;
