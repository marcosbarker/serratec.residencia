import React,{ useState, useEffect} from "react";
import Logo from "../../components/img/logo.svg";
import { useHistory } from "react-router-dom";
import api from "../../services/api";
import { AuthContext } from "../../providers/auth";
import { Formik } from "formik";
import * as yup from "yup";
import { BigLogo } from "../../components/BigLogo/styles";
import { Formulario } from "../../components/Formulario/styles";
import Input from "../../components/Input";
import { Button } from "../../components/Button/styles";
import Alerta from "../../components/Alerta";
import Loading from '../../components/Loading'

const Login = () => {
  const history = useHistory();
  const { setUsuario } = React.useContext(AuthContext);
  const [senhaErrada, setSenhaErrada] = useState(false);
  const [requisicao, setRequisicao] = useState(false);

  useEffect(() => {
    if(requisicao){
        return(
        <Loading type='bars' color='#01a999' />
        )
    }
  }, [requisicao]);

  const validations = yup.object().shape({
    usuario: yup.string().required('Insira um usuário valido'),
    senha: yup.string().required('Insira uma senha valida')
  })

  return (
    <>
      <Alerta isOpen={senhaErrada} func={setSenhaErrada} texto='Usuario ou senha errada' />
        <BigLogo src={Logo} alt="Logo" />
      <Formik initialValues={{ usuario: "", senha: "" }} onSubmit={async (values) => {
        try {
          setRequisicao(true)
          setTimeout(()=>{},5000)
          const response = await api.post("/usuarios/login", values);
          const token = response.data.isAtivo
          setUsuario(response.data);
          setRequisicao(false)
 
          if (token) {
            return (
              history.push('/home')
            )
          }
        } catch {
          setRequisicao(false);
          setSenhaErrada(true);
        }
      }} validationSchema={validations}>
            <Formulario>
              <Input name='usuario' type='text' label='Usuário' placeholder='usuário' />
              <Input name='senha' type='password' label='Senha' placeholder='senha' />
              <Button type="submit"> Confirmar </Button>
              {useEffect}
            </Formulario>
      </Formik>
    </>
  );
};

export default Login;
