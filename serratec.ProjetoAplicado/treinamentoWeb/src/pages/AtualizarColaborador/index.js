import React, { useState, useEffect } from "react";
import {
  Input,
  ButtonDiv,
  Button,
  Select,
  Mensagem,
  InputMask,
  Label,
  InputDiv,
} from "../CadastrarColaboradores/styles";
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

const AtualizarColaborador = () => {
  const history = useHistory();
  const [posicoes, setPosicoes] = useState([]);
  const { colaborador } = React.useContext(AuthContext);
  const { usuario } = React.useContext(AuthContext);

  useEffect(() => {
    api
      .get("/posicoes")
      .then((response) => setPosicoes(response.data))
      .catch((err) => {
        console.error("ops! ocorrei um erro" + err);
      });
  }, []);

  const posicoesSelect = posicoes.map((p, i) => (
    <option key={i} value={p.idPosicoes}>
      {p.nome}
    </option>
  ));

  function handlePermissao(p) {
    if (p) {
      return <option value={2}>Administrador</option>;
    }
  }
  const cpfMask = [/\d/,/\d/,/\d/,".",/\d/,/\d/,/\d/,".",/\d/,/\d/,/\d/,"-",/\d/,/\d/,];
  const rgMask = [/\d/,/\d/,".",/\d/,/\d/,/\d/,".",/\d/,/\d/,/\d/,"-",/\d/,];

  const validations = yup.object().shape({
    nome: yup.string().min(5, ({min}) => `Mínimo de ${min} caracteres`).required("Nome é obrigatório"),
    dataNascimento: yup
      .date("Inserir uma data valida")
      .required("Data de nascimento é obrigatória"),
    email: yup
      .string()
      .email("Inserir um email valido")
      .max(30, ({ max }) => `Maximo de ${max} caracteres`)
      .required("Email é obrigatório"),
    pix: yup.string().max(40, ({ max }) => `Maximo de ${max} caracteres`),
    cpf: yup.string().required("CPF é obrigatório"),
    rg: yup.string().required("*RG é obrigatório"),
    cnh: yup
      .string()
      .max(1, ({ max }) => `Maximo de ${max} caracteres`)
      .required("Categoria CHN é obrigatória"),
  });

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Atualizar Colabolador</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          nome: colaborador.nome,
          dataNascimento: colaborador.dataNascimento,
          email:colaborador.email,
          pix: colaborador.pix,
          cpf: colaborador.cpf,
          rg: colaborador.rg,
          cnh: colaborador.cnh,
          permissao: colaborador.permissao,
          idPosicoes: colaborador.posicao.idPosicoes,
        }}
        onSubmit={async (values) => {
          const colab = {
            nome: values.nome,
            dataNascimento: values.dataNascimento,
            email: values.email,
            pix: values.pix,
            cpf: values.cpf,
            rg: values.rg,
            cnh: values.cnh,
            permissao: values.permissao,
            posicao: {
              idPosicoes: values.idPosicoes,
            },
          };
          await api.put(`/colaboradores/${colaborador.idColaboradores}`,colab);
          alert("Put colaborador realizado com sucesso!");
          history.push("/colaborador")
        }}
        validationSchema={validations}
      >
        <BigForm>
            <Mensagem component="span" name="nome" />
            <InputDiv>
              <Label for="nome">Nome</Label>
              <Input name="nome" type="text" placeholder="Nome"></Input>
            </InputDiv>
            <Mensagem component="span" name="cnh" />
            <InputDiv>
              <Label for="cnh">CNH</Label>
              <Select component="select" name="cnh">
                <option value="">Sem CNH</option>
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
                <option value="E">E</option>
                <option value="AB">AB</option>
              </Select>
            </InputDiv>
            <Mensagem component="span" name="cpf" />
            <InputDiv>
              <Label for="cpf">CPF</Label>
              <Input
                name="cpf"
                render={({ field }) => (
                  <InputMask
                    {...field}
                    type="text"
                    placeholder="CPF"
                    mask={cpfMask}
                  />
                )}
              ></Input>
            </InputDiv>
            <Mensagem component="span" name="rg" />
            <InputDiv>
              <Label for="rg">RG</Label>
              <Input
                name="rg"
                render={({ field }) => (
                  <InputMask
                    {...field}
                    type="text"
                    placeholder="RG"
                    mask={rgMask}
                  />
                )}
              ></Input>
            </InputDiv>
            <Mensagem component="span" name="email" />
            <InputDiv>
              <Label for="email">Email</Label>
              <Input name="email" type="email" placeholder="Email"></Input>
            </InputDiv>
            <Mensagem component="span" name="dataNascimento" />
            <InputDiv>
              <Label for="dataNascimento">Data de nascimento</Label>
              <Input
                name="dataNascimento"
                type="date"
                placeholder="Data de nascimento"
              ></Input>
            </InputDiv>
            <InputDiv>
              <Label for="permissao">Permissão</Label>
              <Select component="select" name="permissao">
                <option value={0}>Colaborador</option>
                <option value={1}>Lider</option>
                {handlePermissao(usuario.isAdmin)}
              </Select>
            </InputDiv>
            <InputDiv>
              <Label for="posicoes">Posições</Label>
              <Select component="select" name="idPosicoes">
                {posicoesSelect}
              </Select>
            </InputDiv>
            <Mensagem component="span" name="pix" />
            <InputDiv>
              <Label for="nome">PIX</Label>
              <Input name="pix" type="text" placeholder="PIX"></Input>
            </InputDiv>
          <ButtonDiv>
            <Button type="submit">Atualizar</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default AtualizarColaborador;
