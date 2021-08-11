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
  Input,
  InputDiv,
  Mensagem,
  Label,
} from "./styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";
import { BigForm } from "../../components/BigForm/styles";

const InserirTreinamentos = () => {
  const history = useHistory();
  const { colaborador } = React.useContext(AuthContext);
  const [certificacoes, setCertificacoes] = useState([]);

  useEffect(() => {
    api
      .get("/certificacoes")
      .then((response) => setCertificacoes(response.data))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);

  const certificacoesMap = certificacoes.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.nomeCertificado}
          </p>
          <p>
            <b>Instituição: </b>
            {p.instituicaoCertificado}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Validade: </b>
            {p.tempoValidade}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <Formik
        initialValues={{
          dataObtencao: "",
        }}
        onSubmit={async (values) => {
            await api.put(`/colabsCerts/colaborador/${colaborador.idColaboradores}/certificacaoAInserir/${p.idCertificacoes}`,values);
            alert("Atualização realizada com sucesso!");
            history.push("/colaborador")
        }}
      >
        <BigForm>
          <Mensagem component="span" name="dataObtencao" />
          <InputDiv>
            <Label for="dataObtencao">Data de obtenção</Label>
            <Input
              name="dataObtencao"
              type="date"
              placeholder="Data de obtenção"
            ></Input>
          </InputDiv>
          <BotoesDiv>
          <Button type="submit">Inserir certificação</Button>
        </BotoesDiv>
        </BigForm>   
      </Formik>
    </CardDiv>
  ));
  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Certificações</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <CardDiv>{certificacoesMap}</CardDiv>
    </DivPrincipal>
  );
};

export default InserirTreinamentos;
