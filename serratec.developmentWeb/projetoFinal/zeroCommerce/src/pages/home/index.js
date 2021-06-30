import React, { useState, useEffect } from 'react';
import api from '../../services/api';
import { Produto, Title, Content } from './style';
import { Alert, AlertTitle } from '@material-ui/lab';
import { makeStyles } from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';

const Produtos = () => {
    const [Produtos, setProduto] = useState([]);
    const [ProdutoFiltrado, setProdutoFiltrado] = useState("");
    const [open, setOpen] = React.useState(false);

    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    function rand() {
        return Math.round(Math.random() * 20) - 10;
    }

    /* function getModalStyle() {
        const top = 50 + rand();
        const left = 50 + rand();
        return {
            top: `${top}%`,
            left: `${left}%`,
            transform: `translate(-${top}%, -${left}%)`,
        };
    } */

/*     const useStyles = makeStyles((theme) => ({
        paper: {
            position: 'absolute',
            width: 400,
            backgroundColor: theme.palette.background.paper,
            border: '2px solid #fff',
            boxShadow: theme.shadows[5],
            padding: theme.spacing(2, 4, 3),
        },
        root: {
            width: '100%',
            '& > * + *': {
            },
        },
    })); */

    //const classes = useStyles();
    
    const loadProdutos = async () => {
        try {
            const response = await api.get('produto');
            setProduto(response.data)
        } catch (error) {
            console.log("Erro ao buscar os produtos", error)
        }
    };
    
    useEffect(() => {
        loadProdutos();
    }, []);

    function adicionarCarrinho(produto){
           var teste = [];

           if(localStorage.getItem('@LOJA:produto')){
                var TotalProdutos = JSON.parse(localStorage.getItem('@LOJA:produto'));
                TotalProdutos.push(produto)
                localStorage.setItem('@LOJA:produto',JSON.stringify(TotalProdutos));
           }else{
                teste.push(produto)
                localStorage.setItem('@LOJA:produto',JSON.stringify(teste));
           }  
           verificarCompra();
    }

    function verificarCompra(){
        if(localStorage.getItem('@LOJA:produto')){
            handleOpen()
        }
        setTimeout(() => {
           handleClose()
        }, 3000);
    }

    return (
        <Content>
            {ProdutoFiltrado === "" ? (
                <>
                    <Title>
                        <h1>Produtos</h1>
                        <label>Filtrar</label>
                        <input value={ProdutoFiltrado} onChange={e => setProdutoFiltrado(e.target.value)} type="text" placeholder="Digite o nome do produto" />
                    </Title>
                    <Produto>
                        {Produtos.map((produto) => {
                            return (
                                <div className="cards0" key={produto.id}>
                                    <div className="cards1">
                                        <h6>{produto.nomeCategoria}</h6>
                                        <h3>{produto.nome}</h3>
                                        <div className="cards2">
                                            <p>{produto.descricao} </p>
                                        </div>
                                        <img src={produto.fotoLink} alt=""/>
                                    </div>
                                    <span className="qtd">Estoque: 
                                        {produto.qtdEstoque < 1 ?(
                                                <span> Indisponivel </span>
                                            ):(
                                                <span> {produto.qtdEstoque} </span>
                                            )}
                                    </span>
                                    <div className="cards3">
                                        <p>{produto.valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })}</p>
                                        {produto.qtdEstoque < 1 ? (
                                            <span> </span>
                                        ):(
                                            <button type="button" onClick={e => adicionarCarrinho(produto)}>Comprar
                                            </button>
                                        )}
                                    </div>
                                </div>
                            )
                        })
                        }
                        <Modal open={open} onClose={handleClose}>
                            {<div style={{margin:"25%"}}>
                                <Alert severity="success">
                                    <AlertTitle>Sucesso</AlertTitle>
                                    Produto adicionado dentro do <strong>Carrinho!</strong>
                                </Alert>
                            </div>
                            }
                        </Modal>
                    </Produto>
                                
                </>
            ) : (
                <>
                    <Title>
                        <h1>Produtos</h1>
                        <label>Filtrar</label>
                        <input value={ProdutoFiltrado} onChange={e => setProdutoFiltrado(e.target.value)} type="text" placeholder="Digite o nome ou preço" />
                    </Title>
                    <Produto>
                        {Produtos.map((produto) => {
                            if (produto.nome.toUpperCase() === ProdutoFiltrado.toUpperCase()) {
                                return (
                                <div className="cards0" key={produto.id}>
                                        <div className="cards1" >
                                            <h6>{produto.nomeCategoria}</h6>
                                            <h3>{produto.nome}</h3>
                                            <div className="cards2" >
                                                <p>{produto.descricao} </p>
                                            </div>
                                            <img src={produto.fotoLink} alt=""/>
                                        </div>
                                        <span className="qtd">Estoque:                                       
                                        {produto.qtdEstoque < 1 ?(
                                            <span> Indisponivel </span>
                                        ):(
                                            <span> {produto.qtdEstoque} </span>
                                        )}       
                                        </span>
                                        <div className="cards3">
                                            <p>R$:{produto.valor}</p>
                                            {produto.qtdEstoque < 1 ? (
                                            <span> </span>
                                            ):(
                                                <button type="button" onClick={e => adicionarCarrinho(produto)}>Comprar
                                                </button>
                                            )}
                                        </div>
                                    </div>
                                )
                            } else if (produto.valor <= ProdutoFiltrado) {
                                return (
                                    <div className="cards0" key={produto.id}>
                                        <div className="cards1" >
                                            <h6>{produto.nomeCategoria}</h6>
                                            <h3>{produto.nome}</h3>
                                            <div className="cards2" >
                                                <p>{produto.descricao} </p>
                                            </div>
                                            <img src={produto.fotoLink} alt=""/>
                                        </div>
                                        <span className="qtd">Estoque: 
                                        {produto.qtdEstoque < 1 ?(
                                                <span> Indisponivel </span>
                                            ):(
                                                <span> {produto.qtdEstoque}</span>
                                            )}
                                            </span>
                                        <div className="cards3">
                                            <p>R$:{produto.valor}</p>
                                            {produto.qtdEstoque < 1 ? (
                                                <span> </span>
                                            ):(
                                                <button type="button" onClick={e => adicionarCarrinho(produto)}>Comprar
                                                </button>
                                            )}
                                        </div>
                                    </div>
                                )
                            }
                        })
                        }
                    </Produto>
                </>
            )
            }
            <div>
        </div>        
    </Content>
    )
    
}
export default Produtos;