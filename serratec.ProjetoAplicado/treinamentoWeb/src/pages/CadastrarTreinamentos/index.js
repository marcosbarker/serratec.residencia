import React from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import api from "../../services/api";
import { Formik } from "formik";
import * as yup from "yup";
import Input from "../../components/Input";
import { Button } from "../../components/Button/styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";
import { BigForm } from "../../components/BigForm/styles";


const CadastrarPosicoes = () => {
  const history = useHistory();

  const validations = yup.object().shape({
    nome: yup.string().max(100,({max})=>`Maximo de ${max} caracteres`).required('Nome é obrigatório'),
    instituicao: yup.string().max(200,({max})=>`Maximo de ${max} caracteres`).required('Descrição é obrigatório'),
    cargaHoraria: yup.number().max(100,({max})=>`Maximo de ${max} caracteres`).required('Nome é obrigatório'),
    descricao: yup.string().max(200,({max})=>`Maximo de ${max} caracteres`).required('Descrição é obrigatório')
  })

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Casdastrar treinamentos</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          nome: "",
          instituicao:"",
          cargaHoraria:"",
          descricao: "",
        }}
        onSubmit={async (values) => {
            await api.post("/treinamentos", values);
            alert("Cadastro realizado com sucesso!")
            history.push('/treinamentos')
        }}
        validationSchema={validations}
      >
        <BigForm>
            <Input name='nome' type='text' label='Nome' placeholder='nome' />
            <Input name='instituicao' type='text' label='Instituicao' placeholder='instituicao' />
            <Input name='cargaHoraria' type='number' label='Carga Horaria' placeholder='carga horaria' />
            <Input name='descricao' type='text' label='Descrição' placeholder='descrição' />
            <Button type="submit">Cadastrar</Button>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default CadastrarPosicoes;
