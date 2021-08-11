import styled from 'styled-components/native';

export const Container = styled.SafeAreaView`
  background-color: #a0c8c3;
  height: 100%;
`;

export const ListScroll = styled.ScrollView`
`;

export const Titulo = styled.Text`
  font-size: 30px;
  text-align: center;
  font-weight: bold;
  font-style: italic;
`;

export const FormacoesArea = styled.View`
  flex-direction: column;
  border-radius: 20px;
  justify-content: center;
  background-color: lightgray;
  border: #01a999;
  margin: 15px;
`;

export const FormacoesView = styled.View`
  border-color: black;
  align-items: center;
  width: 100%;
  display: flex;
  flex-direction: column;
`;

export const FormacoesText = styled.Text`
  text-align: center;
  color: black;
  font-size: 20px;
  font-weight: bold;
`;

export const DadosView = styled.View`
  flex-direction: row;
  flex-wrap: wrap;
  margin: 10px;
  justify-content: center;
  align-content: center;
`;

export const DadosText = styled.Text`
  font-size: 20px;
  text-align: center;
  font-style: italic;
`;

export const FormaText = styled.Text`
  text-align: center;
  color: white;
  font-size: 20px;
  
`;
export const FormacoesButton = styled.TouchableOpacity`
  height:50px;
  background-color: #01a999;
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
`;

export const EndButton = styled.TouchableOpacity`
  height: 35px;
  background-color: #01a999;
  width: 50%;
  display: flex;
  align-items: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
 
`;

export const EndText = styled.Text`
  text-align: center;
  color: white;
  font-size: 15px;
  margin-top: 5px;
`;

export const EndView = styled.View`
  align-items: center;
  justify-content: center;
  margin-left: 20px;
  height: 35px;
  width: 90%;
  margin-top:15px
`;
