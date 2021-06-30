import React, { Component } from 'react';
import ButtonAppBar from './components/Header';
import {BrowserRouter} from 'react-router-dom';
import Routes from './routes';
import GlobalStyle from './style/global'




function App() {
  return (
    <>
      <ButtonAppBar />
      <BrowserRouter>
      <Routes/>
      </BrowserRouter>
      <GlobalStyle/>
    </>
  );
}
export default App;



