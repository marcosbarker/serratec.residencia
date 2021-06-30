import React, { useState, useEffect } from 'react';
import api from '../../../services/api';
import { makeStyles } from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';
import { Table } from './style';
import { FiTrash2, FiEdit } from 'react-icons/fi';
import { ClienteModal} from './style';


const ControleCliente = () => {
    const [modalStyle] = React.useState(getModalStyle);
    const [open, setOpen] = React.useState(false);
    const [cliente, setCliente] = useState([]);
    const [IdClient,setIdClient] = useState();
    const [novoNomeCliente, setNovoNomeCliente] = useState();
    const [novoCpf, setNovoCpf] = useState();
    const [novoEmail, setNovoEmail] = useState();
    const [novoUsuario, setNovoUsuario] = useState();

    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    function rand() {
        return Math.round(Math.random() * 20) - 10;
    }

    function getModalStyle() {
        const top = 50 + rand();
        const left = 50 + rand();

        return {
            top: `${top}%`,
            left: `${left}%`,
            transform: `translate(-${top}%, -${left}%)`,
        };
    }

    const useStyles = makeStyles((theme) => ({
        paper: {
            position: 'absolute',
            width: 400,
            backgroundColor: theme.palette.background.paper,
            border: '2px solid #000',
            boxShadow: theme.shadows[5],
            padding: theme.spacing(2, 4, 3),
        },
    }));

    const classes = useStyles();

    const loadCliente = async () => {
        try {
            const response = await api.get('cliente');
            setCliente(response.data)
        } catch (error) {
            console.log("Erro load Cliente", error)
        }
    };


    useEffect(() => {
        loadCliente();
    }, []);



    const removeCliente = async (client) => {
        await api.delete(`cliente/${client.id}`)
        loadCliente();
    };


    async function alterarCliente(e) {
        e.preventDefault();

        const params = {
            nome:novoNomeCliente,
            usuario:novoUsuario,
            cpf: novoCpf,
            email: novoEmail,
            dataNascimento: "1992-02-01T00:00:00Z",
                endereco: {
                rua: "Rua dos Bobos",
                numero: "0",
                complemento: "",
                bairro: "Castanheira",
                cidade: "Metropolis",
                estado: "SP",
                cep: "23451234"
            }
        }

        try {
            await api.put(`cliente/${IdClient}`, params);
            loadCliente();
            handleClose();
        } catch (error) {
            console.log('Erro ao alterar Cliente', error);
        }
    }

    function OpenModal(client) {
        setIdClient(client)
        handleOpen();
    }

    return (
        <>
        <Table >     
            <tr >
                <th style={{textAlign:"left"}}>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Usuario</th>
                <th>Alterar</th>
                <th>Excluir</th>
            </tr>
                {cliente.map((client) => {
                    return (                       
                        <tr key={client.id}  >                       
                            <td style={{width:"10000px",textAlign:"left"}}>{client.nome}</td> 
                            <td>{client.cpf}</td>
                            <td>{client.email}</td>
                            <td>{client.usuario}</td>
                            <td className="btnEdit" style={{textAlign:"center"}}><FiEdit size={20} onClick={e => OpenModal(client.id)} /></td>
                            <td className="btnDel" style={{textAlign:"center"}}><FiTrash2 size={20} onClick={() => removeCliente(client)} /></td>                       
                        </tr>                        
                    )
                })}           
        </Table>

            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                >
                {<ClienteModal>
                    <form className="formCliente" onSubmit={alterarCliente}>
                    <label id="nome">Nome</label>
                    <input type="text" id="nome" value={novoNomeCliente} onChange={e => setNovoNomeCliente(e.target.value)} placeholder="Digite o seu nome" autoComplete="off"/>

                    <label id="cpf">CPF</label>
                    <input type="text" id="cpf" value={novoCpf} onChange={e => setNovoCpf(e.target.value)} placeholder="Digite o seu CPF de 11 dígitos" autoComplete="off" maxlength="11"/>

                    <label id="email">Email</label>
                    <input type="text" id="email" value={novoEmail} onChange={e => setNovoEmail(e.target.value)} placeholder="digite o seu endereço de e-mail" autoComplete="off"/>

                    <label id="usuario">Usuario</label>
                    <input type="text" id="usuario" value={novoUsuario} onChange={e => setNovoUsuario(e.target.value)} placeholder="Nome de usuário" autoComplete="off"/>

                    <button type="submit">Alterar</button>
                    </form>
                </ClienteModal>
            }
            </Modal>
        </>
    )
}
export default ControleCliente;
