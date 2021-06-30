import styled from 'styled-components';

export const Botao = styled.span`
    display: flex;
    margin: 50px 0 30px 0;
    border-radius: 10px;

    button{
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #3ec300;
        color: #ffffff;
        width: 120px;
        height: 40px;
        border-radius: 10px;
        border: 0;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
        font-weight: 700;

        &:hover{
            background-color: #46d900;
            color: #fafafa;
            cursor: pointer;
        }
    }
`;

export const Conteudo = styled.div`
    
    display: grid;
    background-color: #ffffff;
    justify-content: center;
    width:550px;
    height: 600px;
    margin: 40px auto;
    background-color: #f5f5f5;
    border-radius: 10px;
    

    .grupo{
        display: grid;
        margin: auto;
        padding: 15px;
        justify-content: center;                         
        
        label{
            margin-top: 10px;
            color: #7C7CE0;
            font-weight: 600;
            display: grid;
            justify-content: auto;
            text-align: left;   
            width: 200px;
        }

        input{
            border: none;
            border-bottom: 1px solid;
            width: 400px;
            height: 30px;
            padding: 10px;
            border-color: #7C7CE0;
            color: #696969;
            background-color: transparent;
            align-self: auto;
            flex-grow: 1;
            
            &:hover,
            &:focus{
                outline: none;
                background-color: #7C7CE0;
                opacity: 0.7;
                color: #fafafa; 
                border-radius: 10px;
            }

        }

        select{
            border: none;
            border-bottom: 1px solid;
            border-color: #7C7CE0;
            border-radius: 10px;
            background-color: transparent;
            padding: 8px 8px 0 8px;
            width: 400px;
            height: 35px;
            flex-grow: 1;
            color: #696969;

            &:hover,
            &:focus{
                outline: none;
                background-color: #7C7CE0;
                opacity: 0.6;
                color: #fafafa; 
                border-radius: 10px;
            } 
        }
        
        button{
            margin: 20px auto 0px auto;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #3ec300;
            color: #ffffff;
            width: 100%;
            height: 35px;
            border-radius: 10px;
            border: 0;
            box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
            font-weight: 600;

            &:hover{
                background-color: #46d900;
                color: #fafafa;
                cursor: pointer;    
            }
        }
    }

`;

