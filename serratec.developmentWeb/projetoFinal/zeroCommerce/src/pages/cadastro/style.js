


import styled from 'styled-components';

export const Conteudo = styled.div`
    background-color: #7c7ce0;

    max-width: 900px;
    display: grid;
    place-items: center;

    form {
        background-color: #fff;
        margin-top: 100px;
        padding: 30px;
        border-radius: 10px;
        align-items:center;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
        opacity: 0.9;
    }

    form input {
        width: 100%;
        margin: 10px 0;
        border: 0;
        margin-bottom: 10px;
        border-bottom: 1px solid #7c7ce0;
        padding: 6px;
        color: #303030;

        &:hover,
        &:focus{
            outline: none;
            background-color: #7C7CE0;
            opacity: 0.7;
            color: #fff;  
            border-radius: 8px;
        }    

        &::placeholder{
            color: #cdcdcd;
        }
    }

    form label{
        text-align: center;
        font-weight: bold;
        color: #7c7ce0;
        width: 1000px;
    }

    form button{
        width: 100%;
        height: 30px;
        background-color: #3ec300;
        color: #fff;
        border: 0;
        border-radius: 6px;
        transition: 0.2s;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
        text-align: center;
        margin: 10px 0;
        padding: 5px;
        font-size: 16px;
        font-weight: bold;

        &:hover{
            background-color: #46d900;
            color: #fafafa;
        }
}
  
`;




