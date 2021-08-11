import React, { useEffect, useState } from 'react';
import {
  ContainerHome,
  HomeView,
  HomeButton,
  ButtonText,
  IconArea,
  ButtonView,
  LogoView,
  Logo,
  HoView,
  HomeText,
  HoText
} from './styles';
export default function Home({ navigation }) {

  return (
    <ContainerHome>
      <IconArea>
      </IconArea>
      <HomeView>
      <LogoView>
          <Logo source={require('../../../assets/logo.png')} />
          <HoText>Provendo competência em qualidade de software</HoText>
      </LogoView>
      <HoView>
              <HomeText>Bem Vindo!</HomeText>
        </HoView>
        <ButtonView>
          <HomeButton onPress={() => { navigation.navigate('Lista de Colaboradores') }}>
            <ButtonText>Colaboradores</ButtonText>
          </HomeButton>
          <HomeButton onPress={() => { navigation.navigate('Lista de Posições') }}>
            <ButtonText>Treinamentos</ButtonText>
          </HomeButton>
          <HomeButton onPress={() => { navigation.navigate('Login') }}>
            <ButtonText>Sair</ButtonText>
          </HomeButton>
        </ButtonView>
      </HomeView>
    </ContainerHome>
  );
}

