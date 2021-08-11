import React from 'react';
import { DadosView, DadosText, InformacoesText } from './styles';



export const handleDate = (props) => {
    if (props != null) {
        
        const data = new Date(props)
        const dia = (data.getDate() + 1).toString().padStart(2, '0')
        const mes = (data.getMonth() + 1).toString().padStart(2, '0')
        const ano = data.getFullYear()
        const dataFormatada = `${dia}/${mes}/${ano}`
        return (
            <DadosText>{dataFormatada}</DadosText>
            
            )
        }else{
            return(
                <DadosText></DadosText>
            )
        }
  }