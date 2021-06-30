import { Alert } from '@material-ui/lab';
import styled from 'styled-components';

export const Conteudo = styled.div`
    margin: 20%;

    #btnTotal{
        width: 75px;
        height: 20px;
        font-size: 14px;
        float: left;
        padding-top: 5px;
    }

    #btnComprar{
        width: 90px;
        background: #4bcf15;
        float: right;
        border-radius: 5px;
    }

    #btnLimpar{
        width: 90px;
        float: right;
        margin-left: 3px;
    }

    #msgLog{
        font-size: 20px;
        background: red;
        text-align: center;
        margin-bottom: 10px;
    }

    .txt{
        color: #fff;
        font-size: 20px;
    }
`;

export const Table = styled.div`
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 5px;
    border: 1px solid #ddd;
    background: whitesmoke;
    box-align:  auto;
    vertical-align:middle;
    border-radius: 5px;
    box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);

    th{
        padding: 10px;
        text-align: center;
        background-color: #7c7ce0;
        color: whitesmoke;
    }

    td{
        display: table-cell;
        text-align: center;
        width: 33.3%;
        color: #303030;  
    }

    tr{
        transition: 0.2s;
    }

    tr:hover {
        background-color: #ddd;
    }

`;




