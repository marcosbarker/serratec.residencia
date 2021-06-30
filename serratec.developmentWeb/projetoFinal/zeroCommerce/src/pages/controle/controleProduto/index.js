import React, { useState, useEffect } from 'react';
import api from '../../../services/api';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { FiTrash2, FiEdit } from 'react-icons/fi'
import Modal from '@material-ui/core/Modal';
import { Conteudo } from './style'
import { Botao } from './style'
import { TabUnselectedSharp, TrafficRounded } from '@material-ui/icons';


/*import Cliente from '../../models/Cliente';*/
const ControleProduto = () => {
    const [produto, setProduto] = useState([]);
    //const [modalStyle] = React.useState(getModalStyle);
    const [open, setOpen] = React.useState(false);
    const [categoria, setCategoria] = useState([]);
    const [funcionario, setFuncionario] = useState([]);
    const [novoNome, setNovoNome] = useState('');
    const [novaDescricao, setNovaDescricao] = useState('');
    const [novoEstoque, setNovoEstoque] = useState();
    const [novoValor, setNovoValor] = useState();
    const [novoIDCategoria, setNovoIDCategoria] = useState();
    const [novoIDFuncionario, setNovoIDFuncionario] = useState();
    const [novoDataFabricao, setNovoDataFabricao] = useState();
    const [novoImagem, setNovaImagem] = useState('');
    const [status, setStatus] = useState();
    const [idFuncionario, setIdFuncionario] = useState();


    const loadProduto = async () => {
        try {
            const response = await api.get('produto');
            setProduto(response.data)
        } catch (error) {
            console.log("loadProduto", error)
        }
    };

    const loadCategoria = async () => {
        try {
            const response = await api.get('categoria');
            setCategoria(response.data)
        } catch (error) {
            console.log("loadCategoria", error)
        }
    };

    const loadFuncionario = async () => {
        try {
            const response = await api.get('funcionario');
            setFuncionario(response.data)
        } catch (error) {
            console.log("loadFuncionario", error)
        }
    };

    useEffect(() => {
        loadProduto();
        loadCategoria();
        loadFuncionario();
    }, []);

    const StyledTableCell = withStyles((theme) => ({
        head: {
            backgroundColor: theme.palette.common.light,
            color: theme.palette.common.black,
        },
        body: {
            fontSize: 14,
        },
    }))(TableCell);

    const StyledTableRow = withStyles((theme) => ({
        root: {
            '&:nth-of-type(odd)': {
                backgroundColor: theme.palette.action.hover,
            },
        },
    }))(TableRow);


    const useStyles = makeStyles({
        table: {
            minWidth: 700,
        },
    });

    function rand() {
        return Math.round(Math.random() * 20) - 10;
    }

   /*  function getModalStyle() {
        const top = 50 + rand();
        const left = 50 + rand();

        return {
            top: `${top}%`,
            left: `${left}%`,
            transform: `translate(-${top}%, -${left}%)`,
        };
    } */

    const useStylesModel = makeStyles((theme) => ({
        paper: {
            position: 'absolute',
            width: 400,
            backgroundColor: theme.palette.background.paper,
            border: '2px solid #000',
            boxShadow: theme.shadows[5],
            padding: theme.spacing(2, 4, 3),
        },
    }));
    //const classesModel = useStylesModel();

    const classes = useStyles();


    const handleOpen = () => {
        setStatus(true)
        setOpen(true);
    };

    const handleOpenCadastrar = () => {
        setStatus(false)
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const removeProduto = async (produto) => {
        await api.delete(`produto/${produto.id}`)
        loadProduto();
    }

    async function cadastrarProduto(e) {
        e.preventDefault();

        

        const params = {
            nome: novoNome,
            descricao: novaDescricao,
            qtdEstoque: novoEstoque,
            valor: novoValor,
            idCategoria: novoIDCategoria,
            idFuncionario: novoIDFuncionario,
            dataFabricao: novoDataFabricao,
            fotoLink: novoImagem
        }

        try {
            await api.post(`produto`, params);
            loadProduto();
            handleClose();

        } catch (error) {
            console.log('Erro ao cadastra o produto', error);
        }
    }

    async function alterarProduto(e) {
        e.preventDefault();

        const params = {
            nome: novoNome,
            descricao: novaDescricao,
            qtdEstoque: novoEstoque,
            valor: novoValor,
            idCategoria: novoIDCategoria,
            idFuncionario: novoIDFuncionario,
            dataFabricao: novoDataFabricao,
            fotoLink: novoImagem
        }

        try {
            await api.put(`produto/${idFuncionario}`, params);
            loadProduto();
            handleClose();

        } catch (error) {
            console.log('Erro ao alterar', error);
        }
    }

    function teste(row) {
        setIdFuncionario(row)
        handleOpenCadastrar();

    }

    function handleBlur(event) {
        this.setState({ msg: event.target.value });
    }

    return (
        <>
            <Botao>
            <button type="button" onClick={handleOpen}>
                Novo Produto
            </button>
            </Botao>
            <div>
                <TableContainer component={Paper}>
                    <Table className={classes.table} aria-label="customized table">
                        <TableHead >
                            <TableRow style={{backgroundColor: "#FFFFFF !important" }}>
                                <StyledTableCell>Nome</StyledTableCell>
                                <StyledTableCell align="center">Valor</StyledTableCell>
                                <StyledTableCell align="center">Categoria</StyledTableCell>
                                <StyledTableCell align="center">Estoque</StyledTableCell>
                                <StyledTableCell align="center">Gerenciar</StyledTableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {produto.map((row) => (
                                <StyledTableRow key={row.id} >
                                    <StyledTableCell component="th" scope="row">
                                        {row.nome}
                                    </StyledTableCell>
                                    <StyledTableCell align="center">{row.valor}</StyledTableCell>
                                    <StyledTableCell align="center">{row.nomeCategoria}</StyledTableCell>
                                    <StyledTableCell align="center">{row.qtdEstoque}</StyledTableCell>
                                    <StyledTableCell align="center"> <FiTrash2 size={20} onClick={() => removeProduto(row)} />
                                        <FiEdit size={20} onClick={e => teste(row.id)} /></StyledTableCell>

                                </StyledTableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
                <div>

                    <Modal
                        open={open}
                        onClose={handleClose}
                    >
                        {
                            <Conteudo>
                                {status ? (
                                    <form className="produtoModal" onSubmit={cadastrarProduto}>
                                        <div className="grupo">
                                            <label id="nome" value={novoNome} onChange={e => setNovoNome(e.target.value)} > Nome </label>
                                            <input type="text" id="nome" />

                                            <label id="descricao"> Descrição </label>
                                            <input type="text" value={novaDescricao} onChange={e => setNovaDescricao(e.target.value)} id="descricao" />

                                            <label id="qtdEstoque"> Estoque </label>
                                            <input type="text" value={novoEstoque} onChange={e => setNovoEstoque(e.target.value)} id="qtdEstoque" />

                                            <label id="valor"> Valor </label>
                                            <input type="text" value={novoValor} onChange={e => setNovoValor(e.target.value)} id="valor" />

                                            <label id="categoria"> Categoria </label>
                                            <select id="categoria"  onChange={e => setNovoIDCategoria(e.target.value)}>
                                                
                                                {categoria.map((categ) => {
                                                    return (
                                                        <option key={categ.id} value={categ.id}>{categ.nome}</option>
                                                    )
                                                })}
                                            </select>

                                            <label id="funcionario"> Funcionario </label>
                                            <select id="funcionario" onChange={e => setNovoIDFuncionario(e.target.value)}>
                                              
                                                {funcionario.map((funcio) => {
                                                    return (
                                                        <option key={funcio.id} value={funcio.id}>{funcio.nome}</option>
                                                    )
                                                })}
                                            </select>

                                            <label id="dtfabricacao"> Fabricação </label>
                                            <input type="text" value={novoDataFabricao} onChange={e => setNovoDataFabricao(e.target.value)} id="dtfabricacao" />

                                            <label id="img"> Imagem </label>
                                            <input type="url" value={novoImagem} onChange={e => setNovaImagem(e.target.value)} id="img" />

                                            <button type="submit" > Cadastrar</button>

                                        </div>
                                    </form>
                                ) : (
                                        <form className="produtoModal" onSubmit={alterarProduto}>
                                            <div className="grupo">
                                                <label id="nome" > Nome </label>
                                                <input type="text" value={novoNome} onChange={e => setNovoNome(e.target.value)} id="nome" />

                                                <label id="descricao"> Descrição </label>
                                                <input type="text" value={novaDescricao} onChange={e => setNovaDescricao(e.target.value)} id="descricao" />

                                                <label id="qtdEstoque"> Estoque </label>
                                                <input type="text" value={novoEstoque} onChange={e => setNovoEstoque(e.target.value)} id="qtdEstoque" />

                                                <label id="valor"> Valor </label>
                                                <input type="text" value={novoValor} onChange={e => setNovoValor(e.target.value)} id="valor" />

                                                <label id="categoria"> Categoria </label>
                                                <select id="categoria" onChange={e => setNovoIDCategoria(e.target.value)}>

                                                    {categoria.map((categ) => {
                                                        return (
                                                            <option key={categ.id} value={categ.id}>{categ.nome}</option>
                                                        )
                                                    })}
                                                </select>

                                                <label id="funcionario"> Funcionario </label>
                                                <select id="funcionario" onChange={e => setNovoIDFuncionario(e.target.value)}>

                                                    {funcionario.map((funcio) => {
                                                        return (
                                                            <option key={funcio.id} value={funcio.id}>{funcio.nome}</option>
                                                        )
                                                    })}
                                                </select>

                                                <label id="dtfabricacao"> Fabricação </label>
                                                <input type="text" value={novoDataFabricao} onChange={e => setNovoDataFabricao(e.target.value)} id="dtfabricacao" />

                                                <label id="img"> Imagem </label>
                                                <input type="url" value={novoImagem} onChange={e => setNovaImagem(e.target.value)} id="img" />
                                                <button type="submit" >Alterar</button>
                                            </div>
                                        </form>
                                    )}
                            </Conteudo>
                        }
                    </Modal>
                </div>

            </div>
        </>
    )
}
export default ControleProduto;