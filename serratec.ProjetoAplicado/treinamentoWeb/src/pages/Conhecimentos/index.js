import React,{ useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import Logo from "../../components/img/logo.svg";
import { LinkButton } from "../../components/LinkButton/styles";
import { AuthContext } from "../../providers/auth";
import api from "../../services/api";
import {
  CardColaboradorDiv,
  CardColaboradorDivInterna,
  CardDiv,
  BotoesDiv,
  Button
} from "./styles";
import { DivPrincipal } from "../../components/DivPrincipal/styles";
import { DivHeader } from "../../components/DivHeader/styles"
import { DivTitulo } from "../../components/DivTitulo/styles";
import { Titulos } from "../../components/Titulos/styles";

const Conhecimentos = () => {
  const history = useHistory();
  const { competencia, setCompetencia, setConhecimento } = React.useContext(AuthContext);
  const [refresh, setRefresh] = useState(false);
  console.log(competencia);

  const handleClick = (p) => {
    setConhecimento(p.conhecimento);
    history.push('/treinamentos')
  };

  async function handleRemoverConhecimento(p) {
    await api.put(`/compsCons/competencia/${competencia.idCompetencias}/conhecimentoARemover/${p.conhecimento.idConhecimentos}`);
    alert("Conhecimento removido com sucesso!");
    setRefresh(!refresh)
  };

  useEffect(async () => {
    const responseCompetencia = await api.get(`/competencias/${competencia.idCompetencias}`)
    setCompetencia(responseCompetencia.data)
  }, [refresh]);

  const competenciasMap = competencia.setCompsCons.map((p, i) => (
    <CardDiv key={i}>
      <CardColaboradorDiv>
        <CardColaboradorDivInterna>
          <p>
            <b>Nome: </b>
            {p.conhecimento.nome}
          </p>
        </CardColaboradorDivInterna>
        <CardColaboradorDivInterna>
          <p>
            <b>Descrição: </b>
            {p.conhecimento.descricao}
          </p>
        </CardColaboradorDivInterna>
      </CardColaboradorDiv>
      <BotoesDiv>
        <Button onClick={() => handleClick(p)}>Possiveis Treinamentos</Button>
        <Button onClick={() => handleRemoverConhecimento(p)}>Remover</Button>
      </BotoesDiv>
    </CardDiv>
  ));
  return (
    <DivPrincipal>
      <DivHeader>
        <Link to="/home" style={{ width: "225px" }}>
          <img src={Logo} alt="Logo" style={{ width: "100%" }} />
        </Link>
        <DivTitulo>
          <Titulos>{competencia.nome}: Conhecimentos </Titulos>
        </DivTitulo>
        <LinkButton to='/cadastrarconhecimentos'>Cadastrar conhecimentos</LinkButton>
        <LinkButton to='/inserirconhecimento'>Inserir conhecimentos</LinkButton>
      </DivHeader>
      <CardDiv>{competenciasMap}</CardDiv>
    </DivPrincipal>
  );
};

export default Conhecimentos;
