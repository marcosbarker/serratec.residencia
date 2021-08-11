import { Link } from "react-router-dom";
import styled from "styled-components";

export const DivPrincipal = styled.div`
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: center;
    margin-bottom: 20px;
`;
export const DivLink = styled(Link)`
    margin-left: 7vh;
`;
export const DivTitulo = styled.div`
    width: 50vw;
    min-width: fit-content;
`;
export const Titulo = styled.h1`
    font-size: max(16px, 3vw)  ;
    text-align: center;
`;
export const DivLateral = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    width: 310px;
`;



