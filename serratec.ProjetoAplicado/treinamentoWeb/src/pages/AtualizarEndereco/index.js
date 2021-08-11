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



const AtualizarEndereco = () => {
  const history = useHistory();
  const { endereco } = React.useContext(AuthContext);
console.log(endereco)
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
          <Titulos>Atualização do endereço</Titulos>
        </DivTitulo>
        <div style={{ width: "225px", height: "10px" }}></div>
      </DivHeader>
      <Formik
        initialValues={{
          rua: endereco.endereco.rua,
          numero: endereco.endereco.numero,
          complemento: endereco.endereco.complemento,
          bairro: endereco.endereco.bairro,
          cidade: endereco.endereco.cidade,
          estado: endereco.endereco.estado,
          cep: endereco.endereco.cep,
          pais: endereco.endereco.pais
        }}
        onSubmit={async (values) => {
            console.log(values)
          await api.put(`/enderecos/${endereco.endereco.idEnderecos}`, values);
          alert("Put endereco realizado com sucesso!");
          history.push("/colaborador")
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
            <Select component="select" name="estado">
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
