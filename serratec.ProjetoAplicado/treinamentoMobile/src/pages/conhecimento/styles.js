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
export const TreinamentoColaArea = styled.View`
  flex-direction: column;
  border-radius: 20px;
  justify-content: center;
  background-color: lightgray;
  border: #01a999;
  margin: 15px;
`;
export const TreinamentoColaView = styled.View`
  border-color: black;
  align-items: center;
  width: 100%;
  display: flex;
  flex-direction: column;
`;
export const TreinamenText = styled.Text`
  text-align: center;
  color: black;
  font-size: 20px;
  font-style: italic
`;
export const TreinamentoButton = styled.TouchableOpacity`
  height:50px;
  background-color: #01a999;
  width: 70%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
`;
export const TreinaButton = styled.TouchableOpacity`
  height:40px;
  background-color: #01a999;
  width: 45%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
`;
export const TreinaText = styled.Text`
  text-align: center;
  color: black;
  font-size: 20px;
  font-weight: bold;
`;
export const TreinaColaView = styled.View`
  margin-top: 5px;
  justify-content: center;
  align-items: flex-end;
  height: 35px;
  width: 98%;
  padding-left: 10px;
`;
export const TreText = styled.Text`
  text-align: center;
  color: white;
  font-size: 20px;
  font-weight: bold;
`;