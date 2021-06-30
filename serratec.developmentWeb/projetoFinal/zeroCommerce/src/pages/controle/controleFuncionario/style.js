import styled from 'styled-components';

export const Funcionario = styled.div`
    background-color: #7c7ce0;
    margin-top: 40px;
    max-width: 900px;
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px;

    div{
        display: block;
        text-align: center;
        max-width: auto;
        padding: 10px;
        border-radius: 8px;
        background-color: #fff;

        &:hover{
            opacity: 0.9;
        }


        h3{
            color: #4d4d4d;
        }
        
        p{
            font-size: 18px;
            color: #a1a1a1; 
        }
        div{
            display:block;
        }
        span{
            display: flex;
            justify-content: space-between;
            }
        }
    }
    .cards0 {
        box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
        transition: all 0.3s cubic-bezier(.25,.8,.25,1);
      }
      
    .cards0:hover {
        box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
      }


`;

export const Title = styled.div`
    margin-top: 50px;
    display: flex;
    justify-content: space-between;
    
    h1{
        color: #fff;
    }

    button{
        width: 120px;
        height: 40px;
        background-color: #3ec300;
        color: #fff;
        border: 0;
        border-radius: 8px;
        transition: 0.2s;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);

        &:hover{
            background-color: #46d900;
            color: #fafafa;
        }

    }

`;

export const Form = styled.div`
    margin-bottom: 25%;
    margin-top: 25%;
    margin-left: 30%;

    input{
        width: 200px;
        border:0;
        color: #4d4d4d;
        padding: 10px;
        height: 40px;
        border-radius: 8px;
        font-size: 18px;

         & + input{
            margin-left: 5px; 
        }

        &::placeholder{
            color: #b0b0b0;
        }
    }

    button{
        width: 120px;
        height: 40px;
        margin-left: 5px;
        background-color: #3ec300;
        color: #fff;
        border: 0;
        border-radius: 8px;
        transition: 0.2s;

        &:hover{
            background-color: #46d900;
            color: #fafafa;
        }

    }

    @media(max-width:750px){
        display: block;

        input{
            margin-left: 5px;
            margin-top: 5px;
            display: block;
        }

        button{
            display: block;
            margin-top: 10px;
            width: 200px;
        }
    }

`;
