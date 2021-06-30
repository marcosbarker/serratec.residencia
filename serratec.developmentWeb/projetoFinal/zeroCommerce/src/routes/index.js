import React from 'react';
import {Switch, Route} from 'react-router-dom';
import Produtos from '../pages/home';
import Funcionarios from '../pages/controle/controleFuncionario';
import ControleProduto from '../pages/controle/controleProduto';
import ControleCategoria from '../pages/controle/controleCategoria';
import ControleCliente from '../pages/controle/controleCliente';
import Cadastro from '../pages/cadastro'
import Carrinho from '../pages/carrinho'
import Controle from '../pages/controle'
import Sucesso from '../pages/sucesso'

const Routes = ()=>(
    <Switch>
        <Route path="/" component={Produtos} exact/> 
        <Route path="/carrinho" component={Carrinho}/> 
        <Route path="/cadastro" component={Cadastro}/>   
        <Route path="/sucesso" component={Sucesso}/> 
        <Route path="/controle" component={Controle} exact/> 
        <Route path="/controle/funcionario" component={Funcionarios}/> 
        <Route path="/controle/produto" component={ControleProduto}/>
        <Route path="/controle/categoria" component={ControleCategoria}/>
        <Route path="/controle/cliente" component={ControleCliente}/>
    </Switch>
)

export default Routes;