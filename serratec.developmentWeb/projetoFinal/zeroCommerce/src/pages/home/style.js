import styled from 'styled-components';

export const Produto = styled.div`
    background-color: opacity;
    margin-top: 40px;
    max-width: 900px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr; 
    gap: 20px;
    

    div{
        background-color: #F0F8FF;
        padding: 5px;
        border-radius: 8px;
        position: relative;
        

        .cards1{
            display: block;
            text-align: center;
            max-width:250px;
            margin-bottom:70px;
            height: 260px;
            
            h6{
                color: #7d7d7d;
            }
            h3{
                color: #4d4d4d;
            }
            img{
                max-width: 100%;
                max-height: 180px;
             }
        }

        .cards2{
            height: 40px;
            
             p{
                color: #7d7d7d; 
            }
        }
        .cards3{
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-weight: bold;
            color: #424242;
            font-size: 18px;

            button{
                width: 80px;
                height: 35px;
                background-color: #3ec300;
                color: #fff;
                border: 0;
                border-radius: 8px;
                cursor: pointer;

                &:hover{
                    background-color: #46d900;
                    color: #fafafa;
                }              
            }
        }

        .qtd{
            margin-left: 4px;
            color: #a1a1a1; 
        } 
    }
    .cards0{
        box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
        transition: all 0.3s cubic-bezier(.25,.8,.25,1); 
    }

    .cards0:hover{
        box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
    }

`;


export const Title = styled.div`
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    
    h1{
        color: #000;
    }
    label{
        color: #fff;
        margin-right: 7px;
        margin-top: 3px;
        justify-self: right;
    }

    input{
        height: 25px;
        border-radius: 20px;
        border: 0;
        padding: 8px;
        color:  #4d4d4d;
        justify-self: stretch;
    }

`;

export const Content = styled.div`
    margin-top: 50px;
`;

