import styled from "styled-components/native";

export const Container = styled.SafeAreaView`
  height: 100%;
  background-color: #A0C8C3;
`;

export const TreinaScroll = styled.ScrollView`

`;

export const InputArea = styled.View`
    width:80%;
    height: 400px;
    align-items: center;
    border-radius: 15px;
    margin: 40px;
    justify-content: center;
    border:white;
    background-color:black;
`;

export const InputCadastro = styled.TextInput`
  font-size: 18px;
  margin-top: 10px;
  border: white;
  width: 220px;
  background-color: white;
  height: 50px;
  border-radius: 10px;
  color: #181818;
  margin: 5%;
  margin-bottom: 3%;
`;
export const CadastroText = styled.Text`
  text-align: center;
  color: black;
  font-size: 30px;
  font-weight: bold;
  margin-top: 20px;

`;
export const CadastroView = styled.View`

`;


export const EspacoView = styled.View`
  height: 40px;
`;
export const ButtonView = styled.View`

  align-items: center;
`;
export const CertiButton = styled.TouchableOpacity`
  height:50px;
  background-color: #01a999;
  width: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
  margin: 10%;
`;

export const CertiView = styled.View`

`;

export const CertiText = styled.Text`
  text-align: center;
  color:white;
  font-size:18px;
  font-weight: bold;
`;
export const MensagemArea = styled.View`
    border-color: black;
    align-items:center;
    justify-content: center;
    width: 100%;
    display: flex;
    flex-direction: column;
    height: 800px;
`;

export const MensagemView = styled.View`
    margin-bottom: 200px;
`;

export const MensagemText = styled.Text`
    text-align: center;
    color: black;
    font-size:18px;
    font-weight: bold;
`;

export const DataView = styled.View`
  width: 70%;
  background-color: white;
  margin-top: 10px;
  border-radius: 10px;
`;