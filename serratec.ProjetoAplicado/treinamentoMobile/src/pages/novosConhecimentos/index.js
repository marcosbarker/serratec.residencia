import React from 'react';
import axios from 'axios';
import { Container, TreinaScroll, PosiText, InputArea, InputCadastro, CertiButton, CertiText, DataView, ButtonView, CadastroText, CadastroView, MensagemArea, MensagemView, MensagemText, CertiView } from './styles';
import { Alert, Text } from 'react-native';
import { Formik } from 'formik';
import * as yup from 'yup';

export default function NovoConhecimento({ navigation }) {
    const conhecimentoValidationSchema = yup.object().shape({
        nome: yup.string().max(100, ({ max }) => `Maximo de ${max} caracteres`).required('Nome é obrigatório'),
        descricao: yup.string().max(200, ({ max }) => `Maximo de ${max} caracteres`).required('Descrição é obrigatório')
    })

    return (
        <Container>
            <TreinaScroll>
                <CadastroView>
                    <CadastroText>Cadastro de Conhecimentos</CadastroText>
                </CadastroView>
                <Formik validationSchema={conhecimentoValidationSchema}
                    initialValues={{
                        nome: '',
                        descricao: ''
                    }}
                    onSubmit={async (values) => {
                        try {
                            await axios.post(`https://api-treinamento-t2m.herokuapp.com/conhecimentos`, values)
                            Alert.alert('Conhecimento cadastrado com sucesso!')
                            navigation.reset({
                                routes: [{ name: 'Conhecimentos por competência' }]
                            })
                        } catch (error) {
                            Alert.alert('Ocorreu um erro, cheque os dados novamente.')
                            console.error(error);
                        }
                    }}>
                    {({ handleChange, handleBlur, handleSubmit, values, errors, touched, isValid }) => (
                        <>
                            <InputArea>
                                <CertiView>
                                    <PosiText>Nome do conhecimento:</PosiText>
                                    <InputCadastro name='nome' onChangeText={handleChange('nome')} onBlur={handleBlur('nome')} value={values.nome} placeholder='Nome' placeholderTextColor='#181818' />
                                    {(errors.nome && touched.nome) &&
                                            <Text style={{ fontSize: 15, color: 'red' }}>{errors.nome}</Text>
                                        }
                                </CertiView>
                                <CertiView>
                                     <PosiText>Descrição  do conhecimento:</PosiText>
                                    <InputCadastro name='descricao' onChangeText={handleChange('descricao')} onBlur={handleBlur('descricao')} value={values.descricao} placeholder='Descrição' placeholderTextColor='#181818' />
                                    {(errors.descricao && touched.descricao) &&
                                            <Text style={{ fontSize: 15, color: 'red' }}>{errors.descricao}</Text>
                                        }
                                <ButtonView>
                                    <CertiButton onPress={() => handleSubmit()}
                                                 disabled={!isValid}>
                                        <CertiText>Salvar</CertiText>
                                    </CertiButton>
                                </ButtonView>
                                </CertiView>
                            </InputArea>

                        </>
                    )}
                </Formik>
            </TreinaScroll>
        </Container>
    )
}