import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import Modal from '@material-ui/core/Modal';
import Login from '../../pages/Login';
import { BotaoNav } from './style';
import { BarraNav } from './style';
import {FaUserCircle} from 'react-icons/fa'
import createHistory from 'history/createBrowserHistory'
import SvgIcon from '@material-ui/core/SvgIcon';
import { AiTwotoneShop } from 'react-icons/ai';
import { TiShoppingCart } from 'react-icons/ti';


const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
  paper: {
    position: 'absolute',
    width: 400,
    backgroundColor: theme.palette.background.paper,
    border: '2px solid #000',
    boxShadow: theme.shadows[5],
    padding: theme.spacing(2, 4, 3),
  },
  root: {
    '& > *': {
      margin: theme.spacing(1),
    },
  },
}));


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

function ButtonAppBar() {
  const history = createHistory();
  const classes = useStyles();
  //const [modalStyle] = React.useState(getModalStyle);
  const [open, setOpen] = React.useState(false);
  const [clienLog, setclienLog] = useState();
  const [funcioLog, setFuncioLog] = useState();
  const [login, setLogin] = useState();
 
  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  function verificarLogin(){
    if(localStorage.getItem('@LOJA:user')){
      setLogin(JSON.parse(localStorage.getItem('@LOJA:user')))
      setclienLog(true)
    }else if(localStorage.getItem('@LOJA:funcionario')){
      setLogin(JSON.parse(localStorage.getItem('@LOJA:funcionario')))
      setFuncioLog(true)
    }
  }

  useEffect(()=>{
    verificarLogin()
  },[])

  function LogOut(){
    if(localStorage.getItem('@LOJA:user')){
      localStorage.removeItem('@LOJA:user')
      history.go(0)
    }else if(localStorage.getItem('@LOJA:funcionario')){
      localStorage.removeItem('@LOJA:funcionario')
      history.go(0)
    }
  }

  function HomeIcon(props) {
    return (
      <SvgIcon {...props}>
        <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />
      </SvgIcon>
    );
  }
 
  return (
    <div className={classes.root}>
      <BarraNav>
      <AppBar position="fixed" style={{backgroundColor: "#252833", boxShadow: "0 4px 4px -4px rgb(0,0,0)" }} >
        
        <Toolbar>          
        
          <AiTwotoneShop/>
          <Button variant="outlined" color="inherit" href="/">ZeroCommerce</Button>
        
          <Typography style={{ flex: 1 }} />
          {login && 
            <span sytle={{marginLeft:"-50px"}}>
             Salve,  {login.nome } !!!
            </span>
          }
          
          {clienLog || funcioLog ?(
                <FaUserCircle size={24} style={{marginTop: "0px"}}/>
          ):(
            <Button color="inherit" onClick={handleOpen}>Entrar</Button>
          )}
        <BotaoNav>
          {funcioLog &&
              <Button id="btnGer" color="inherit" href="/controle" >
                Portal Funcionario
              </Button>
          }
          </BotaoNav>
          <Button color="inherit" onClick={e => LogOut() }>Sair</Button>
          <IconButton href="/carrinho" style={{textDecoration:"none", color: "#fff"}} color="#primary" aria-label="add to shopping cart"><TiShoppingCart size={24}/></IconButton>
        </Toolbar>
      </AppBar>
      </BarraNav>    
      <div>
        <Modal
          open={open}
          onClose={handleClose}>
          {<Login/>}
        </Modal>
      </div>
      </div>
  );
    
}

export default ButtonAppBar;
