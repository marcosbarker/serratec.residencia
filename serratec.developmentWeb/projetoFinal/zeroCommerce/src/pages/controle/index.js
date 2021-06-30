import React from 'react';
import { Conteudo } from './style'
import { useHistory } from 'react-router-dom';


const Controle = () => {
    const history = useHistory();

    return (
        <Conteudo>
            <div>
                <a onClick={e => history.push("controle/funcionario")}>Funcionario</a>
                <a onClick={e => history.push("controle/produto")}>Produto</a>
            </div>
           
            <div> 
                <a onClick={e => history.push("controle/Categoria")}>Categoria</a>
                <a onClick={e => history.push("controle/Cliente")}>Cliente</a>
            </div>
        </Conteudo>
    )
}
export default Controle;
