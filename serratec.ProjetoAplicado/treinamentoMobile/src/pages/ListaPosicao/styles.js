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
 
`;
export const PosicaoView = styled.View`
 border-color: black;
  align-items: center;
  width: 100%;
  display: flex;
  flex-direction: column;
 
`;
export const TreinaColaView = styled.View`
  margin-top: 5px;
  justify-content: center;
  align-items: flex-end;
  height: 35px;
  width: 98%;
  padding-left: 10px;
  margin:0px;
`;
export const TreinamentoColaView = styled.View`
  flex-direction: column;
  border-radius: 20px;
  justify-content: center;
  background-color: lightgray;
  border:  #01a999;
  margin: 15px;
  align-items: center;
  width: 93%;
  display: flex;
`;
export const TreinamenText = styled.Text`
  text-align: center;
  color: black;
  font-size: 20px;
  font-weight: bold;
`;
export const PosicaoText = styled.Text`
  text-align: center;
  color: white;
  font-size: 20px;
  font-weight: bold;
`;
export const TreinamentoButton = styled.TouchableOpacity`
  height:55px;
  background-color: #01a999;
  width: 55%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  margin-bottom: 20px;
  margin-top: 10px;
  border: white;
`;
export const PosicaoButton = styled.TouchableOpacity`
  height:100%;
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