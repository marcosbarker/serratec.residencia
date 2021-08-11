import React, { useState, useEffect } from "react";
import {
  FormurarioDiv,
  ButtonDiv,
  TituloEndereco,
} from "../CadastrarColaboradores/styles";
import { useHistory } from "react-router-dom";
import api from "../../services/api";
import { Formik } from "formik";
import * as yup from "yup";
import { Button } from "../../components/Button/styles";
import { BigForm } from "../../components/BigForm/styles";
import Header from '../../components/Header'
import Input from '../../components/Input'
import InputMask from '../../components/InputMask'
import Alerta from "../../components/Alerta";

const CadastrarColaboradores = () => {
  const history = useHistory();
  const [posicoes, setPosicoes] = useState([]);
  const [erro, setErro] = useState(false);

  useEffect(async () => {
    const responsePosicoes = await api.get("/posicoes");
    setPosicoes(responsePosicoes.data);
  }, []);

  const validations = yup.object().shape({
    nome: yup.string().min(5, ({ min }) => `Mínimo de ${min} caracteres`).max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Nome é obrigatório"),
    dataNascimento: yup.date("Inserir uma data valida").required("Data de nascimento é obrigatória"),
    email: yup.string().email("Inserir um email valido").max(30, ({ max }) => `Maximo de ${max} caracteres`).required("Email é obrigatório"),
    pix: yup.string().max(40, ({ max }) => `Maximo de ${max} caracteres`),
    cpf: yup.string().min(14, ({ min }) => `Minimo de ${min} caracteres`).required("CPF é obrigatório"),
    rg: yup.string().min(12, ({ min }) => `Minimo de ${min} caracteres`).required("RG é obrigatório"),
    rua: yup.string().max(100, ({ max }) => `Maximo de ${max} caracteres`).required("Rua é obrigatório"),
    numero: yup.string().max(10, ({ max }) => `Maximo de ${max} caracteres`).required("Numero é obrigatório"),
    complemento: yup.string().max(15, ({ max }) => `Maximo de ${max} caracteres`),
    bairro: yup.string().max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Bairro é obrigatório"),
    cidade: yup.string().max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Cidade é obrigatório"),
    estado: yup.string().required("Estado é obrigatório"),
    cep: yup.string().min(9, ({ min }) => `Minimo de ${min} caracteres`).required("CEP é obrigatório"),
    pais: yup.string().max(15, ({ max }) => `Maximo de ${max} caracteres`).required("Pais é obrigatório"),
  });

  return (
    <>
      <Alerta isOpen={erro} func={setErro} texto='Os Campos CPF, RG, email e Pix devem ter valores únicos, algum colaborador cadastrado já deve possuir algum desses valores !!!' />
      <Header titulo='Cadastro de Colaboradores' textoButton='Voltar' caminho='pesquisacolaborador' />
      <Formik
        initialValues={{
          nome: "",
          dataNascimento: "",
          email: "",
          pix: "",
          cpf: "",
          rg: "",
          cnh: "",
          permissao: 0,
          idPosicoes: 1,
          rua: "",
          numero: "",
          complemento: "",
          bairro: "",
          cidade: "",
          estado: "",
          cep: "",
          pais: "",
        }}
        onSubmit={async (values) => {
          const colaborador = {
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
          const endereco = {
            rua: values.rua,
            numero: values.numero,
            complemento: values.complemento,
            bairro: values.bairro,
            cidade: values.cidade,
            estado: values.estado,
            cep: values.cep,
            pais: values.pais,
          };
          try {
            const responseColaborador = await api.post("/colaboradores", colaborador);
            const idColaborador = responseColaborador.data.idColaboradores;

            const responseEndereco = await api.post("/enderecos", endereco);
            const idEndereco = responseEndereco.data.idEnderecos;

            await api.put(`/colabsEndrs/colaborador/${idColaborador}/enderecoAInserir/${idEndereco}`);

            const responseUsuario = await api.get(`/colaboradores/${idColaborador}`)
            alert(`
            Cadastro efetuado com sucesso !!!
            Usuario: ${responseUsuario.data.usuario.usuario}
            Senha: ${responseUsuario.data.usuario.senha}
            `)

            history.push("/pesquisacolaborador");

          } catch {
            setErro(true);
          }
        }}
        validationSchema={validations}
      >
        <BigForm>
          <FormurarioDiv>
            <Input name='nome' type='text' label='Nome' placeholder='nome' />
            <Input name='cnh' label='CNH' component='select' />
            <InputMask name='cpf' type='text' label='CPF' placeholder='cpf' />
            <InputMask name='rg' type='text' label='RG' placeholder='rg' />
            <Input name='email' type='email' label='Email' placeholder='email' />
            <Input name='dataNascimento' type='date' label='Data Nascimento' placeholder='data nascimento' />
            <Input name='permissao' label='Permissão' component='select' />
            <Input name='posicao' label='Posição' component='select' posicoes={posicoes} />
            <Input name='pix' type='text' label='PIX' placeholder='pix' />
          </FormurarioDiv>
          <FormurarioDiv>
            <TituloEndereco>
              <p style={{ margin: "0" }}>Endereço:</p>
            </TituloEndereco>
            <Input name='rua' type='text' label='Rua' placeholder='rua' />
            <Input name='numero' type='number' label='Numero' placeholder='numero' />
            <Input name='complemento' type='text' label='Complemento' placeholder='complemento' />
            <Input name='bairro' type='text' label='Bairro' placeholder='bairro' />
            <Input name='cidade' type='text' label='Cidade' placeholder='cidade' />
            <Input name='estado' label='Estado' component='select' />
            <Input name='pais' type='text' label='Pais' placeholder='pais' />
            <InputMask name='cep' type='text' label='CEP' placeholder='cep' />
          </FormurarioDiv>
          <ButtonDiv>
            <Button type="submit">Cadastrar</Button>
          </ButtonDiv>
        </BigForm>
      </Formik>
    </>
  );
};

export default CadastrarColaboradores;
