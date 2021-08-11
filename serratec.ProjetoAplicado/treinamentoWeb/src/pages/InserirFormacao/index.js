import React from "react";
import {
  Input,
  ButtonDiv,
  Mensagem,
  InputMask,
  Label,
  InputDiv,
  Select,
} from "./styles";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
import { AuthContext } from "../../providers/auth";
import { Formik } from "formik";
import * as yup from "yup";
import { Button } from "../../components/Button/styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";
import { BigForm } from "../../components/BigForm/styles";


const CadastrarEnderecos = () => {
  const history = useHistory();
  const { colaborador } = React.useContext(AuthContext);

  const validations = yup.object().shape({
    nome: yup.string().max(100,({max})=>`Maximo de ${max} caracteres`).required('Nome é obrigatório'),
    nivel: yup.string().max(30,({max})=>`Maximo de ${max} caracteres`).required('Nivel é obrigatório'),
    instituicao: yup.string().max(30,({max})=>`Maximo de ${max} caracteres`).required('Instituição é obrigatório'),
    dataEntrada: yup.date(),
    dataConclusao: yup.date(),
  })

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Inserir Formação</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          nome: "",
          nivel: "",
          instituicao: "",
          dataEntrada:"",
          dataConclusao: "",
        }}
        onSubmit={async (values) => {
          const formacao = {
            nome:values.nome,
            nivel:values.nivel,
            instituicao:values.instituicao
          }
          const datas = {
            dataEntrada:values.dataEntrada,
            dataConclusao:values.dataConclusao
          }
          const responseFormacao = await api.post("/formacoes", formacao);
          const idFormacoes = responseFormacao.data.idFormacoes;
          alert("Post formações realizado com sucesso!");

          const response = await api.put(`/colabsForms/colaborador/${colaborador.idColaboradores}/formacaoAInserir/${idFormacoes}`,datas);
          console.log(response.data);
          alert("Put realizado com sucesso!");
          history.push("/colaborador")
        }}
        validationSchema={validations}
      >
        <BigForm>
          <Mensagem component="span" name="nome" />
            <InputDiv>
            <Label for="nome">Nome</Label>
            <Input
              name="nome"
              type="text"
              placeholder="Nome"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="nivel" />
            <InputDiv>
            <Label for="nivel">Nível</Label>
            <Input
              name="nivel"
              type="text"
              placeholder="Nível"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="instituicao"/>
            <InputDiv>
            <Label for="instituicao">Instituição</Label>
            <Input
              name="instituicao"
              type="text"
              placeholder="Instituição"
            ></Input>
            </InputDiv>
            <InputDiv>
            <Label for="dataEntrada">Data de entrada</Label>
            <Input
              name="dataEntrada"
              type="date"
              placeholder="Data de entrada"
            ></Input>
            </InputDiv>
            <InputDiv>
            <Label for="dataConclusao">Data de conclusão</Label>
            <Input
              name="dataConclusao"
              type="date"
              placeholder="Data de conclusão"
            ></Input>
            </InputDiv>
          <ButtonDiv>
            <Button type="submit">Inserir Formação</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default CadastrarEnderecos;
