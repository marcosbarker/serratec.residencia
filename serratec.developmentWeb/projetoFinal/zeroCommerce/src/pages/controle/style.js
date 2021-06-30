import styled from 'styled-components';

export const Conteudo = styled.div`
    display: flex;
    justify-content: center;
    align-text: center;
    margin-top: 23%;
    
    div{
        a{
            display: flex;
            justify-content: center;
            margin: 50px;
            background-color: #3ec300;
            width: 270px;
            height: 70px;
            color: #fff;
            text-decoration: none;
            align-items: center;
            border-radius: 8px;
            font-size: 20px;
            box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
            transition: 0.2s;
            
            &:hover{
                background-color: #46d900;
                color: #fafafa;
                cursor: pointer;
            }

           
        }

        
        }

    }
`;
