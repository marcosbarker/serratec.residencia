import styled from "styled-components";
import { Form, Field, ErrorMessage } from "formik";
import MaskedInput from "react-text-mask";

export const PrincipalDiv = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
  height: 600px;
  align-items: center;
  margin-top: 50px;
  margin-bottom: 50px;
  height: fit-content;
`;
export const HeaderDiv = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 90%;
  min-height: fit-content;
  align-items: center;
  justify-content: center;
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
  font-size: 26px;
  font-weight: bold;
  text-align: center;
`;
export const Formulario = styled(Form)`
  display: flex;
  flex-direction:column;
  align-items: center;
  justify-content: center;
  width: 90%;
  min-height: fit-content;
  min-width: 400px;
  background-color: #000;
  border-radius: 15px;
  padding: 20px 0;
  margin-top: 40px;
`;
export const FormurarioDiv = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 50%;
  min-height: fit-content;
  min-width: 400px;
`;
export const Input = styled(Field)`
  color:grey;
  border: none;
  border-radius: 30px;
  width: 75%;
  font-size: 20px;
  padding:15px;
  font-weight: 700;
  &:focus {
    outline:none;
  }
`;
export const InputMask = styled(MaskedInput)`
  color:grey;
  border: none;
  border-radius: 30px;
  width: 75%;
  font-size: 20px;
  padding:15px;
  font-weight: 700;
  &:focus {
    outline:none;
  }
`;
export const TituloEndereco = styled.div`
  color:grey;
  border: none;
  border-radius: 30px;
  width: 86%;
  margin: 10px;
  font-size: 20px;
  padding:15px;
  font-weight: 700;
  background-color: white;
  color: black;
  text-align: center;
`;
export const InputDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: grey;
  width: 90%;
  margin: 10px;
  border-radius: 30px;
  padding-left: 20px;
  box-sizing: border-box;
`;
export const Select = styled(Field)`
  color:grey;
  border: none;
  border-radius: 30px;
  width: 79%;
  font-size: 20px;
  padding:15px;
  font-weight: 700;
  &:focus {
    outline:none;
  }
`;
export const Mensagem = styled(ErrorMessage)`
  color: white;
  font-weight: bold;
  font-size: 16px;
`;
export const ButtonDiv = styled.div`
  width: 90%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 10px;
`;
export const Button = styled.button`
  border: none;
  border-radius: 30px;
  width: 100%;
  font-size: 20px;
  padding: 15px;
  font-weight: 600;
  background-color: #01a999;
  color: white;
`;
export const Label = styled.label`
  width: 25%;
  height: 100%;
  font-weight: bold;
  color:black;
  font-size:20px;
`;

