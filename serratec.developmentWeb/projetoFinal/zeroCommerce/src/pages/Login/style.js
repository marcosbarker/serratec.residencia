import styled from 'styled-components';

export const HomePage = styled.div`
        background-color: #7c7ce0;
        margin-top: 15%;
        margin-left: 32%;
        max-width: 500px;
        height: 300px;
        border-radius: 14px;
        display: flex;
        justify-content: center;
        align-items:center;
        
    div{
            
        input{
            margin-top: 5px;
            width: 250px;
            height: 40px;
            display: block;
            margin-left: auto;
            padding: 8px;
            margin-right: auto;
            border: 0;
            background-color: #7c7ce0;
            color: #fff;
            border-bottom: 1px solid #fff;

            & + input{
                margin-bottom: 0;
            }

            &::placeholder{
                color: #fff;
            }

            
        }
        button, a{
            display: block;
            width: 250px;
            height: 37px;
            background-color: #3ec300;           
            font-weight: bold;
            font-size: 16px;
            border: 0;
            color: #fff;
            border-radius: 6px;
            transition: 0.2s;
            margin: 25px;
            cursor: pointer;
            opacity: 0.9;
            margin-top: 8px;

            & + button{
                margin-top: 25px;
            }

            a{
                text-decoration: none;
                color: #fff;
            }

            &:hover{
                background-color: #46d900;
                color: #fafafa;
            }
        }

        a{
            margin-top: -20px;
            display: flex;
            justify-content:center;
            align-items:center;
        }

        span{
            display: flex;
            justify-content:center;
            margin: 5px;
            color: red;
            opacity: 0.9;
        }
    }

`;

