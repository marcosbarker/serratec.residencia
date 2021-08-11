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

const InserirProjetos = () => {
  const history = useHistory();
  const { colaborador } = React.useContext(AuthContext);
  const [projetos, setProjetos] = useState([]);

  useEffect(() => {
    api
      .get("/projetos")
      .then((response) => setProjetos(response.data))
      .catch((err) => {
        console.error("ops! ocorrei um erro" + err);
      });
  }, []);

  const handleDate = (props) => {
    const data = new Date(props);
    const dia = (data.getDate() + 1).toString().padStart(2, "0");
    const mes = (data.getMonth() + 1).toString().padStart(2, "0");
    const ano = data.getFullYear();
    const dataFormatada = `${dia}/${mes}/${ano}`;
    return dataFormatada;
  };
  const projetosMap = projetos.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.nome}
          </p>
          <p>
            <b>Descrição: </b>
            {p.descricao}
          </p>
          <p>
            <b>Gerenciamento: </b>
            {p.appGerenciamento}
          </p>
          <p>
            <b>Segmento: </b>
            {p.segmento}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Data de entrega esperada: </b>
            {handleDate(p.dataEntregaEsperada)}
          </p>
          <p>
            <b>Data de entrega: </b>
            {handleDate(p.dataEntrega)}
          </p>
          <p>
            <b>Equipe: </b>
            {p.equipe}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <Formik
        initialValues={{
          funcao: "",
          dataInicio: "",
        }}
        onSubmit={async (values) => {
          await api.put(`/colabsProjs/colaborador/${colaborador.idColaboradores}/projetoAInserir/${p.idProjetos}`,values);
          alert("Put realizado com sucesso!");
          history.push("/colaborador")
        }}
      >
        <BigForm>
          <Mensagem component="span" name="funcao" />
          <InputDiv>
            <Label for="funcao">Função</Label>
            <Input name="funcao" type="text" placeholder="Função"></Input>
          </InputDiv>
          <Mensagem component="span" name="dataInicio" />
          <InputDiv>
            <Label for="dataInicio">Data de início</Label>
            <Input
              name="dataInicio"
              type="date"
              placeholder="Data de início"
            ></Input>
          </InputDiv>
          <BotoesDiv>
          <Button type="submit">Inserir projeto</Button>
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
          <Titulos>Projetos</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <CardDiv>{projetosMap}</CardDiv>
    </DivPrincipal>
  );
};

export default InserirProjetos;
