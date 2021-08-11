import styled from "styled-components/native";

export const Container = styled.SafeAreaView`
  height: 100%;
  background-color: #A0C8C3;
`;

export const ProScroll = styled.ScrollView`

`;

export const TreinamentoArea = styled.View`

`;

export const TreinaView = styled.View`

`;

export const TreinamentoButton = styled.TouchableOpacity`
  height:50px;
  background-color: #01a999;
  width: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-top: 5px;
  border: white;
  margin:15px
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

export const TreinamentoText = styled.Text`
  text-align: center;
  color:white;
  font-size:18px;
  font-weight: bold;
  
`;
export const CardText = styled.Text`
  text-align: center;
  color:black;
  font-size: 20px;
  font-weight: bold;
`;
export const CarText = styled.Text`
  text-align: center;
  color:black;
  font-size: 20px;
  font-family:italic;
  
`;
export const CardView = styled.View`
  align-items: center;
  justify-content: center;
  width: 100%;
`;
export const InserirView = styled.View`
  align-items: center;
  justify-content: center;
  width: 80%;
  justify-content: center;
  background-color: lightgray;
  margin: 40px; 
  flex-direction: column;
  border-radius: 20px;
  border:#01a999;
 
  `;
export const InserirText = styled.Text`
  text-align: center;
  color: black;
  font-size: 30px;
  font-weight: bold;
  margin-top: 20px;

`;
export const PickerView = styled.View`
  background-color: white;
  width: 70%;
  margin-top: 10px;
  border-radius: 10px;
  border: black;
`;