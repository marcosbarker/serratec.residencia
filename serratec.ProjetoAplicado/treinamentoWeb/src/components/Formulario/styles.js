import { Form } from "formik";
import styled from "styled-components";

export const Formulario = styled(Form)`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-top: 10vh;
    background-color: black;
    border-radius: 1rem;
    padding: 1rem;
    box-sizing: border-box;
    width: 50%;
    min-width: 320px;
`;