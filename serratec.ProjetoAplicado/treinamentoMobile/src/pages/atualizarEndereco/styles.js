import styled from "styled-components/native";

export const Container = styled.SafeAreaView`
  height: 100%;
  background-color: #a0c8c3;
`;

export const InputArea = styled.View`
  background-color: black;
  width:80%;
  align-items: center;
  justify-content: center;
  border-radius: 15px;
  flex-direction: column;
  margin: 40px;
  justify-content: center;
  border: white;
  padding: 20px 0;
`;

export const InputView = styled.View`
  width: 100%;
  align-items: center;
`;

export const InputCadastro = styled.TextInput`
  font-size: 18px;
  margin-top: 3%;
  border: black;
  width: 80%;
  background-color: white;
  height: 50px;
  border-radius: 10px;
  color: #181818;
  flex-direction:column;
  
`;

export const ButtonView = styled.View`
  margin-top: 5%;
  align-items: center;
`;

export const CadastroButton = styled.TouchableOpacity`
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
  margin: 4%;
`;

export const CadastroText = styled.Text`
  text-align: center;
  color: white;
  font-size: 15px;
  font-weight: bold;
`;

export const PickerView = styled.View`
  background-color: white;
  width: 80%;
  margin-top: 10px;
  border-radius: 10px;
  border: black;
`;

export const MensagemArea = styled.View`
  border-color: black;
  align-items: center;
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
  font-size: 18px;
  font-weight: bold;
  `;
   export const InserirView = styled.View`
  
   `;
   export const InserirText = styled.Text`
   text-align: center;
   color: black;
   font-size: 30px;
   font-weight: bold;
   margin-top: 20px;
 
 `;
 export const EspacoView = styled.View`

`;

export const ProScroll = styled.ScrollView`

`;