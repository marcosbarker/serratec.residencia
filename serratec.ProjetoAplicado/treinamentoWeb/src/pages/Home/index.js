import React from "react";
import Logo from "../../components/img/logo.svg";
import { DivPrincipal } from '../../components/DivPrincipal/styles';
import { BigLogo } from '../../components/BigLogo/styles'
import { LinkButton } from '../../components/LinkButton/styles';
import { DivBotoesHome } from "../../components/DivBotoesHome/styles";

const Home = () => {
  return (
    <DivPrincipal>
          <BigLogo src={Logo} alt="Logo" />
      <DivBotoesHome>
        <LinkButton to="/pesquisacolaborador">Colaboradores</LinkButton>
        <LinkButton to="/pesquisatreinamento">Treinamentos</LinkButton>
        <LinkButton to="/">Sair</LinkButton>
      </DivBotoesHome>
    </DivPrincipal>
  );
};

export default Home;
