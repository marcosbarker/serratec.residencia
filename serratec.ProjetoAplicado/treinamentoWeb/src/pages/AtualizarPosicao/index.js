import React from "react";
import {
    Input,
    ButtonDiv,
    Button,
    Mensagem,
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

const AtualizarPosicao = () => {
    const history = useHistory();
    const { posicao } = React.useContext(AuthContext);

    const validations = yup.object().shape({
        nome: yup.string().min(5, ({ min }) => `Mínimo de ${min} caracteres`).required("Nome é obrigatório"),
        descricao: yup.string().max(40, ({ max }) => `Maximo de ${max} caracteres`),
    });

    return (
        <DivPrincipal>
            <DivHeader>
                <Link to="/home" style={{ width: "225px" }}>
                    <img src={Logo} alt="Logo" style={{ width: "100%" }} />
                </Link>
                <DivTitulo>
                    <Titulos>Atualizar Posição</Titulos>
                </DivTitulo>
                <div style={{ width: "225px", height: "10px" }}></div>
            </DivHeader>
            <Formik
                initialValues={{
                    nome: posicao.nome,
                    descricao: posicao.descricao,
                }}
                onSubmit={async (values) => {

                    await api.put(`/posicoes/${posicao.idPosicoes}`, values);
                    alert("Put colaborador realizado com sucesso!");
                    history.push("/pesquisatreinamento")
                }}
                validationSchema={validations}
            >
                <BigForm>
                    <Mensagem component="span" name="nome" />
                    <InputDiv>
                        <Label for="nome">Nome</Label>
                        <Input name="nome" type="text" placeholder="Nome"></Input>
                    </InputDiv>
                    <Mensagem component="span" name="descricao" />
                    <InputDiv>
                        <Label for="descricao">Descrição</Label>
                        <Input name="descricao" type="text" placeholder="descricao"></Input>
                    </InputDiv>
                    <ButtonDiv>
                        <Button type="submit">Atualizar</Button>
                    </ButtonDiv>
                </BigForm>
            </Formik>
        </DivPrincipal>
    );
};

export default AtualizarPosicao;
