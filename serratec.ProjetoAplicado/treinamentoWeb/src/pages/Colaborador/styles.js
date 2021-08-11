import styled from "styled-components";
import { Link } from "react-router-dom";

export const PrincipalDiv = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
  height: 90%;
  align-items: center;
  margin-top: 50px;
  margin-bottom: 50px;
`;
export const HeaderDiv = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 90%;
  min-height: fit-content;
  align-items: center;
  justify-content: center;
  margin-bottom: 25px;
`;
export const TituloDiv = styled.div`
  width: 70%;
  min-width: 400px;
  min-height: fit-content;
  color: black;
  font-size: 26px;
  font-weight: bold;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
`;
export const Texto = styled.h1`
  color: black;
  font-size: 40px;
  font-weight: bold;
  text-align: center;
`;
export const Titulo = styled.h2`
  color: black;
  font-size: 40px;
  font-weight: bold;
  text-align: center;
`;
export const CardColaboradorDiv = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 70%;
  height: 70%;
  border:solid;
  align-items: center;
  justify-content: center;
  margin-top: 50px;
  margin-bottom: 5px;
  border-radius: 15px;
  background-color: white;
  box-sizing:border-box;
  padding:10px 0;
`;
export const ColaboradorTituloDiv = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
  height: 90%;
  align-items: center;
  margin-top: 10px;
`;
export const CardColaboradorDivInterna = styled.div`
width: 45%;
height: 90%;
font-size: 25px;
line-height: 1;
`;
export const BotoesDiv = styled.div`
display: flex;
align-items: center;
justify-content: flex-end;
width: 70%;
margin:5px;
`;
export const Button = styled.button`
  border: none;
  border-radius: 30px;
  width: 22%;
  height: 45px;
  font-size: 18px;
  padding: 5px 15px;
  font-weight: 600;
  background-color: #222;
  color: white;
  &:hover {
    border:white 2px solid;
  }
  `;
  export const BotaoIns = styled.button`
  border: none;
  border-radius: 30px;
  width: 100%;
  height: 45px;
  font-size: 18px;
  padding: 5px 15px;
  font-weight: 600;
  background-color: #01a999;
  color: white;
  &:hover {
    border:white 2px solid;
  }
  `;
export const ButtonLink = styled.button`
border: none;
border-radius: 30px;
width: 100%;
height: 45px;
font-size: 18px;
padding: 5px 15px;
font-weight: 600;
background-color: #222;
color: white;
&:hover {
  border:white 2px solid;
}
`;
export const CardDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  width: 100%;
`;
export const LinkButton = styled(Link)`
  width: 42.5%;
`;
export const LinkButtonIns = styled(Link)`
  width: 22%;
  margin-left: 5px;
`;




