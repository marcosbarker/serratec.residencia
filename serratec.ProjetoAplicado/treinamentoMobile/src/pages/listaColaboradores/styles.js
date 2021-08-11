import styled from 'styled-components/native';

export const Container = styled.SafeAreaView`
    background-color:  #A0C8C3;
    height: 100%;
`;

export const ButtonInserir = styled.TouchableOpacity`
    margin: 40px;
    height: 40px;
    background-color: #01a999;
    font-size: 18px;
    width: 300px;
    align-items: center;
    justify-content: center;
    border-radius: 30px;
    border: white;
`;

export const ButtonText = styled.Text`
    text-align: center;
    color: white;
    font-weight: bold;
    font-size: 18px;
`;

export const ButtonView = styled.View`
    display: flex;
    align-items: center;
   
    
`;

export const InfoButton = styled.TouchableOpacity`
    border-radius: 20px;
    background-color: #DEDEDE;
    width: 80%;
    height: 50px;
    justify-content: center;
    margin:5px;
    border:#01a999;
    margin-bottom: 3px;
`;

export const InfoButtonText = styled.Text`
    font-size: 18px;
    color: black;
    text-align: center;
    font-weight: bold;
    
`;

export const InfoView = styled.View`
    width: 100%;
    margin-top: 35px;
    align-items: center;
  
    
`;

export const ContentView = styled.View`
    margin:20px
`;

export const ListScroll = styled.ScrollView`

`;
