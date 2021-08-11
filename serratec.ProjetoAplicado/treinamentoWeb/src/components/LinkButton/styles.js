import { Link } from "react-router-dom";
import styled from "styled-components";

export const LinkButton = styled(Link)`
  border-radius: 2rem;
  height: 3rem;
  width: 90%;
  margin: 0.5rem;
  font-size: max(12px,1vw);
  font-weight: bold;
  background-color: #01a999;
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  text-decoration: none;
`;