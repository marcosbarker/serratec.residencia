import styled from 'styled-components'

export const Botao = styled.span`
    display: flex;
    margin: 50px 0 30px 0;

    button{
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #3ec300;
        color: #fff;
        margin-top: 20px;
        width: 150px;
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
    background-color: #fff;
    justify-content: center;
    width: 300px;
    height: 250px;
    margin: 150px auto;
    background-color: #f5f5f5;
    border-radius: 10px;     

   
    form{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 10px;
        margin: 20px;
        

        label{
            color: #7C7CE0;
            font-weight: 600;
        }

        input{
            width: 100%;
            margin: 10px 0;
            border: 0;
            border-bottom: 1px solid #7c7ce0;
            padding: 5px;
            color: #303030;
            background-color: transparent;

            &:hover,
            &:focus{
                outline: none;
                background-color: #7C7CE0;
                opacity: 0.7;
                color: #fff; 
                border-radius: 10px;
            } 
        }
        
        button{
            margin: 10px auto 10px auto;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #3ec300;
            color: #fff;
            width: 100%;
            height: 30px;
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
    }
`;
