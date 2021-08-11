import React, { useState } from 'react';
import {
    ContainerLogin,
    LoginView,
    LoginButton,
    InputLogin,
    ButtonText,
    InputArea,
    BorderArea,
    LoginView2,
    Logo,
    LogoView
} from './styles';
import axios from 'axios';
import { Alert, Text, ActivityIndicator } from 'react-native';
import { Formik } from 'formik';
import * as yup from 'yup';
import { AuthContext } from '../../services/auth';

export default function Login({ navigation }) {
    const [loading, setLoading] = useState(false);
    const { setIsAdmin } = React.useContext(AuthContext);

    const loginValidationSchema = yup.object().shape({
        usuario: yup.string().required('Campo obrigatório *'),
        senha: yup.string().min(4, ({ min }) => `Senha deve ter no mínimo ${min} caracteres`).required('Campo obrigatório *'),
    })

    return (
        <ContainerLogin>
            <LoginView>
                <LogoView>
                    <Logo source={require('../../../assets/logo.png')} />
                </LogoView>
                <LoginView2>
                    <BorderArea>
                        <Formik
                            validationSchema={loginValidationSchema}
                            initialValues={{ usuario: '', senha: '' }}
                            onSubmit={async (values) => {
                                const login = {
                                    usuario: values.usuario,
                                    senha: values.senha
                                }

                                setLoading(true)
                                await axios.post('https://api-treinamento-t2m.herokuapp.com/usuarios/login', login)
                                    .then((response) => {
                                        navigation.navigate('Home');
                                        setLoading(false);
                                        setIsAdmin(response.data.isAdmin)

                                    }).catch(() => {
                                        Alert.alert('Dados inválidos, tente novamente!')
                                        setLoading(false);
                                    })
                            }}>
                            {({ handleChange, handleBlur, handleSubmit, values, errors, touched, isValid }) => (
                                <>
                                    <InputArea>
                                        <InputLogin name='Nome de Usuario' autoCapitalize='none' onChangeText={handleChange('usuario')} onBlur={handleBlur('usuario')} value={values.usuario} placeholder='nome de usuario' />
                                        {(errors.usuario && touched.usuario) &&
                                            <Text style={{ fontSize: 15, color: 'red' }}>{errors.usuario}</Text>
                                        }
                                    </InputArea>
                                    <InputArea>
                                        <InputLogin name='Senha' autoCapitalize='none' onChangeText={handleChange('senha')} onBlur={handleBlur('senha')} value={values.senha} secureTextEntry={true} placeholder='senha' />
                                        {(errors.senha && touched.senha) &&
                                            <Text style={{ fontSize: 15, color: 'red' }}>{errors.senha}</Text>
                                        }
                                    </InputArea>
                                    <LoginButton onPress={() => { handleSubmit(); }}
                                        disabled={!isValid}>
                                        {
                                            loading ? (
                                                <ActivityIndicator animating={loading} color='white' />
                                            ) : (
                                                <ButtonText>Entrar</ButtonText>

                                            )}
                                    </LoginButton>
                                </>
                            )}
                        </Formik>
                    </BorderArea>
                </LoginView2>
            </LoginView>
        </ContainerLogin>
    );
};

