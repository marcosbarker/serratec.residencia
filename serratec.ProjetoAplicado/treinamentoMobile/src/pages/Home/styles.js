import { Animated } from 'react-native';
import styled from 'styled-components/native';

export const ContainerHome = styled.SafeAreaView`
  align-items: center;
  justify-content: flex-start;
  flex-direction: column;
  background-color: #A0C8C3;
  height: 100%;
`;

export const HomeView = styled.View`
  width: 100%;
  height: 100%;
  align-items: center;
  justify-content: center;
`;

export const HomeButton = styled.TouchableOpacity`
  margin: 10px;
  height: 40px;
  background-color: #01a999;
  font-size: 18px;
  width: 200px;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  border: white;

`;

export const ButtonText = styled.Text`  
  text-align: center;
  color: white;
  font-size: 18px;
`;

export const IconArea = styled.View`
  width: 100%;
  
`;

export const ButtonView = styled.View`
  margin-bottom: 130px;
`;
export const Logo = styled.Image`
    width:300px;
    height:135px;
    margin-right: 28px;

`;
export const LogoView = styled.View`
    width:100%;
    align-items: flex-end;
    justify-content: center;
    margin-bottom: 50px;
    
    
`;
export const HoView= styled.View`
  
`;
export const HomeText = styled.Text`
text-align: center;
color: black;
font-size: 30px;
font-weight: bold;
margin-top: 20px;

`;
export const HoText = styled.Text`
text-align: center;
align-items: center;
justify-content: center;
color: black;
font-size: 18px;
font-weight: bold;
margin-top: 20px;
font-family:Italic;
margin:30px
`