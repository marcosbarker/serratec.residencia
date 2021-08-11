import { ErrorMessage, Field } from "formik";
import styled from "styled-components";
import MaskedInput from "react-text-mask";

export const InputDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: grey;
  width: 90%;
  margin: 0.5rem;
  border-radius: 2rem;
  padding-left: 1rem;
  box-sizing: border-box;

`;
export const Mensagem = styled(ErrorMessage)`
  color: white;
  font-weight: bold;
  font-size:max(12px,1vw);
`;
export const Label = styled.label`
  width: 25%;
  height: 100%;
  font-weight: bold;
  color:black;
  font-size:max(12px,1vw);
`;
export const InputComum = styled(Field)`
  color:black;
  border: none;
  border-radius: 2rem;
  width: 75%;
  font-size: 1rem;
  padding:1rem;
  font-weight: bold;
  &:focus {
    outline:none;
  }
`;

export const MaskInput = styled(MaskedInput)`
  color:black;
  border: none;
  border-radius: 2rem;
  width: 75%;
  font-size: 1rem;
  padding:1rem;
  font-weight: bold;
  &:focus {
    outline:none;
  }
`;