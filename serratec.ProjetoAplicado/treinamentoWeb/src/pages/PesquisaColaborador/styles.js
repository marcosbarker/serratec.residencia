import styled from "styled-components";

export const Principal = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
  height: 90%;
  align-items: center;
`;
export const Input = styled.input`
  color:transparent;
  border-radius: 30px;
  width: 50%;
  height: 30px;
  margin: 10px;
  font-size: 18px;
  padding: 5px 15px;
  font-weight: 700;
  &:focus {
    outline:none;
  }
  border: black 2px solid;
`;
export const Imagem = styled.div`
  width: 92%;
  margin-top:30px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  `;
export const Select = styled.select`
  color:grey;
  border: none;
  border-radius: 30px;
  height: 40px;
  width: 48%;
  margin: 10px;
  font-size: 18px;
  padding: 5px 15px;
  font-weight: 700;
  &:focus {
    outline:none;
  }
  appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background: url(../../components/img/seta.png) no-repeat center right #FFF;
    border: 1px solid #333;
    font-size: 15px;
    padding-right: 20px;
    `;
export const Button = styled.button`
  border: none;
  border-radius: 30px;
  width: 97%;
  height: 45px;
  margin: 10px;
  font-size: 18px;
  padding: 5px 15px;
  font-weight: 600;
  background-color: #01a999;
  color: white;
  &:hover {
    border:white 2px solid;
  }
  `;
  export const Botoes = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-top: 60px;
  width: 20%;
  align-items: center;
`;
export const Texto = styled.h2`
  color: black;
  font-size: 26px;
  font-weight: bold;
  text-align: center;
  `;
  export const Card = styled.div`
  background-color: white;
  border-radius: 15px;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 40px;
  text-align: center;
  font-size: 22px;
  margin: 0;
  color:black;
  &:hover {
    font-size:28px;
    transform:scale(1.05);
    transition: all 100ms ease-in;
  }
  `;
  export const Cards = styled.div`
  width: 90%;
  height: 500px;
  margin-top:50px;
  background-color: #01a999;
  border-radius: 15px;
  display: flex;
  flex-direction:row;
  align-items: center;
  justify-content: center;
  flex-wrap:wrap;
  overflow-y:auto;
  padding:30px 0;
  `;