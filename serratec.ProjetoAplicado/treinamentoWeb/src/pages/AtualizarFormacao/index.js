import React from "react";
import {
  Input,
  ButtonDiv,
  Button,
  Mensagem,
  Label,
  InputDiv,
} from "./styles";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
import { AuthContext } from "../../providers/auth";
import { Formik } from "formik";
import * as yup from "yup";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";
import { BigForm } from "../../components/BigForm/styles";


const AtualizarFormacao = () => {
  const history = useHistory();
  const { formacao } = React.useContext(AuthContext);

  const validations = yup.object().shape({
    nome: yup.string().max(100,({max})=>`Maximo de ${max} caracteres`).required('Rua é obrigatório'),
    nivel: yup.string().max(30,({max})=>`Maximo de ${max} caracteres`).required('Numero é obrigatório'),
    instituicao: yup.string().max(15,({max})=>`Maximo de ${max} caracteres`),
  })

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Atualização do endereço</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          nome: formacao.formacao.nome,
          nivel: formacao.formacao.nivel,
          instituicao: formacao.formacao.instituicao,
        }}
        onSubmit={async (values) => {
          await api.put(`/formacoes/${formacao.formacao.idFormacoes}`, values);
          alert("Put formação realizado com sucesso!");
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
          <ButtonDiv>
            <Button type="submit">Atualizar</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default AtualizarFormacao;
