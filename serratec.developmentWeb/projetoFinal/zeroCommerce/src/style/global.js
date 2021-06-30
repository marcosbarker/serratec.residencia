import {createGlobalStyle} from 'styled-components';

export default createGlobalStyle`
    *{
        margin: 0;
        padding: 0;
        outline: 0;
        box-sizing: border-box;
    }

    body{
        background-color: #9370DB;
    }

    html,body, #root{
        height: 100%
        
    }

    body, input, button, select{
        font: 16px 'Roboto';
    }

    body::-webkit-scrollbar {
        width: 0.30rem;
    }
      
    body::-webkit-scrollbar-track {
        background: #1e1e24;
    }
      
    body::-webkit-scrollbar-thumb {
        background: #5a5adf;
    }

    button{
        curso: pointer;
    }

    #root{
        max-width: 900px;
        margin: 0 auto;
        padding: 40px  20px;
    }
    footer {
        position:relative;
        margin-top: 1000px;
        display: block;
        width: 100%;
      }
      
      footer div a i img {
        width: 40px;
        border-radius: 5px;
      }
      
      footer div a {
        color: transparent;
    
`;