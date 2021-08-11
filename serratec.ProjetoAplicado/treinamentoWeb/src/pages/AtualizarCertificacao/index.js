import React from "react";
import {
  Input,
  ButtonDiv,
  Button,
  Mensagem,
  InputMask,
  Label,
  InputDiv,
  Select,
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


const AtualizarEndereco = () => {
  const { endereco } = React.useContext(AuthContext);
console.log(endereco)
  const cepMask = [/\d/,/\d/,/\d/,/\d/,/\d/,"-",/\d/,/\d/,/\d/]

  const validations = yup.object().shape({
    nomeCertificacao: yup.string().max(100,({max})=>`Maximo de ${max} caracteres`).required('Nome é obrigatório'),
    instituicaoCertificacao: yup.string().max(10,({max})=>`Maximo de ${max} caracteres`).required('Numero é obrigatório'),
    tempoValidade: yup.string().max(15,({max})=>`Maximo de ${max} caracteres`),
  })

  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>Atualização da certificação</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
            nomeCertificacao: "",
            instituicaoCertificacao: "",
            tempoValidade:"",
        }}
        onSubmit={async (values) => {
            console.log(values)
          await api.put(`/enderecos/${endereco.endereco.idEnderecos}`, values);
          alert("Put endereco realizado com sucesso!");
        }}
        validationSchema={validations}
      >
        <BigForm>
          <Mensagem component="span" name="nomeCertificacao" />
            <InputDiv>
            <Label for="nomeCertificacao">Nome da certificacao</Label>
            <Input
              name="nomeCertificacao"
              type="text"
              placeholder="Nome da certificacao"
            ></Input>
            </InputDiv>
            <Mensagem component="span" name="instituicaoCertificacao" />
            <InputDiv>
            <Label for="instituicaoCertificacao">Instituição de certificação</Label>
            <Input
              name="instituicaoCertificacao"
              type="number"
              placeholder="Instituição de certificação"
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
            <Select as="select" name="estado">
                <option value="">Selecione um estado</option>
                <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amapá</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Ceará</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Espírito Santo</option>
                <option value="GO">Goiás</option>
                <option value="MA">Maranhão</option>
                <option value="MT">Mato Grosso</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MG">Minas Gerais</option>
                <option value="PA">Pará</option>
                <option value="PB">Paraíba</option>
                <option value="PR">Paraná</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piauí</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RO">Rondônia</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SP">São Paulo</option>
                <option value="SE">Sergipe</option>
                <option value="TO">Tocantins</option>
              </Select>
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
            <Button type="submit">Atualizar</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </DivPrincipal>
  );
};

export default AtualizarEndereco;
