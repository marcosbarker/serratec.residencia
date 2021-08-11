import { Form } from "formik";
import styled from "styled-components";

export const BigForm = styled(Form)`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  min-height: fit-content;
  width: 70vw;
  min-width: 320px;
  background-color: #000;
  border-radius: 1rem;
  padding: 20px 0;
`;
