import React from 'react';
import { DivPrincipal, DivLateral, DivLink, DivTitulo, Titulo } from './styles';
import { LogoSmall } from '../LogoSmall/styles';
import Logo from '../img/logo.svg';
import {LinkButton} from '../LinkButton/styles'

const Header = ({titulo,caminho,textoButton}) => {
    return (
        <DivPrincipal>
            <DivLink to='home'>
                <LogoSmall src={Logo} alt='Logo' />
            </DivLink>
            <DivTitulo>
                <Titulo>
                    {titulo}
                </Titulo>
            </DivTitulo>
            <DivLateral>
                <LinkButton to={caminho}>
                    {textoButton}
                </LinkButton>
            </DivLateral>
        </DivPrincipal>
    );
}

export default Header;

