import React from "react";
import {
  Input,
  FormurarioDiv,
  ButtonDiv,
  Button,
  Mensagem,
  InputMask,
  Label,
  InputDiv,
} from "./styles";
import { Link } from "react-router-dom";
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


const CadastrarColaboradores = () => {
  const { colaborador } = React.useContext(AuthContext);

  const cepMask = [/\d/,/\d/,/\d/,/\d/,/\d/,"-",/\d/,/\d/,/\d/]

  const validations = yup.object().shape({
    rua: yup.string().max(100,({max})=>`Maximo de ${max} caracteres`).required('Rua é obrigatório'),
    numero: yup.string().max(10,({max})=>`Maximo de ${max} caracteres`).required('Numero é obrigatório'),
    complemento: yup.string().max(15,({max})=>`Maximo de ${max} caracteres`),
    bairro: yup.string().max(50,({max})=>`Maximo de ${max} caracteres`).required('Bairro é obrigatório'),
    cidade: yup.string().max(50,({max})=>`Maximo de ${max} caracteres`).required('Cidade é obrigatório'),
    estado: yup.string().max(2,({max})=>`Maximo de ${max} caracteres`).required('Estado é obrigatório'),
    cep: yup.string().required('CEP é obrigatório'),
    pais: yup.string().max(15,({max})=>`Maximo de ${max} caracteres`).required('Pais é obrigatório')
  })

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Cadastro de endereços</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          rua: "",
          numero: "",
          complemento: "",
          bairro: "",
          cidade: "",
          estado: "",
          cep: "",
          pais: ""
        }}
        onSubmit={async (values) => {
          const endereco = {
            rua: values.rua,
            numero: values.numero,
            complemento: values.complemento,
            bairro: values.bairro,
            cidade: values.cidade,
            estado: values.estado,
            cep: values.cep,
            pais: values.pais
          }
          const responseEndereco = await api.post("/enderecos", endereco);
          const idEndereco = responseEndereco.data.idEnderecos;
          alert("Post endereco realizado com sucesso!");

          const response = await api.put(
            `/colabsEndrs/colaborador/${colaborador.idColaboradores}/enderecoAInserir/${idEndereco}`
          );
          console.log(response.data);
          alert("Put realizado com sucesso!");
        }}
        validationSchema={validations}
      >
        <BigForm>
          <Mensagem component="span" name="rua" />
            <InputDiv>
            <Label for="rua">Rua</Label>
            <Input
              name="rua"
              type="text"
              placeholder="Rua"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="numero" />
            <InputDiv>
            <Label for="numero">Número</Label>
            <Input
              name="numero"
              type="number"
              placeholder="Número"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="complemento"/>
            <InputDiv>
            <Label for="complemento">Complemento</Label>
            <Input
              name="complemento"
              type="text"
              placeholder="Complemento"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="bairro" />
            <InputDiv>
            <Label for="bairro">Bairro</Label>
            <Input
              name="bairro"
              type="text"
              placeholder="Bairro"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="cidade" />
            <InputDiv>
            <Label for="cidade">Cidade</Label>
            <Input
              name="cidade"
              type="text"
              placeholder="Cidade"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="estado" />
            <InputDiv>
            <Label for="estado">Estado</Label>
            <Input
              name="estado"
              type="text"
              placeholder="Estado"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="pais" />
            <InputDiv>
            <Label for="pais">País</Label>
            <Input
              name="pais"
              type="text"
              placeholder="Pais"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="cep" />
            <InputDiv>
            <Label for="cep">CEP</Label>
            <Input
              name="cep"
              render={({field})=>(
                <InputMask
                {...field}
                type="text"
                placeholder="CEP"
                mask={cepMask}
                />
              )}
            ></Input>
            </InputDiv>
          <ButtonDiv>
            <Button type="submit">Cadastrar</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default CadastrarColaboradores;
