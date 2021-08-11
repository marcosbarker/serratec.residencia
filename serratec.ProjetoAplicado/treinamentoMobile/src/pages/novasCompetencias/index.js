import React from 'react';
import { Container, TreinaScroll, EspacoView, InputArea, InputCadastro, CertiButton, CertiText, DataView, ButtonView, CadastroText, CadastroView, MensagemArea, MensagemView, MensagemText, CertiView } from './styles';
import { Alert, Text } from 'react-native';
import { Formik } from 'formik';
import * as yup from 'yup';
import axios from 'axios';

export default function NovasCompetencias({ navigation }) {

    const competenciaValidations = yup.object().shape({
        nome: yup.string().max(100, ({ max }) => `Maximo de ${max} caracteres`).required('Nome é obrigatório'),
        descricao: yup.string().max(200, ({ max }) => `Maximo de ${max} caracteres`).required('Descrição é obrigatório'),
    })

    return (
        <Container>
            <TreinaScroll>
                <CadastroView>
                    <CadastroText>Cadastrar Competências</CadastroText>
                </CadastroView>
                <Formik validationSchema={competenciaValidations}
                    initialValues={{
                        nome: '',
                        descricao: ''
                    }}
                    onSubmit={async (values) => {
                        await axios.post('https://api-treinamento-t2m.herokuapp.com/competencias', values);
                        Alert.alert('Competência inserida com sucesso!')
                        navigation.reset({
                            routes: [{ name: 'Competências por posição' }]
                        })
                    }}>
                    {({ handleChange, handleBlur, handleSubmit, values, errors, touched, isValid }) => (
                        <>
                            <InputArea>
                                <CertiView>
                                    <CertiText>Nome da competência:</CertiText>
                                    <InputCadastro name='nome' onChangeText={handleChange('nome')} onBlur={handleBlur('nome')} value={values.nome} placeholder='Nome' placeholderTextColor='#C0C0C0' />
                                    {(errors.nome && touched.nome) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.nome}</Text>
                                    }
                                </CertiView>
                                <CertiView>
                                    <CertiText>Descrição da competência:</CertiText>
                                    <InputCadastro name='descricao' onChangeText={handleChange('descricao')} onBlur={handleBlur('descricao')} value={values.descricao} placeholder='Descrição' placeholderTextColor='#C0C0C0' />
                                    {(errors.descricao && touched.descricao) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.descricao}</Text>
                                    }
                                </CertiView>
                                <ButtonView>
                                    <CertiButton onPress={() => handleSubmit()}
                                        disabled={!isValid}>
                                        <CertiText>Salvar</CertiText>
                                    </CertiButton>
                                </ButtonView>
                            </InputArea>
                        </>
                    )}
                </Formik>
            </TreinaScroll>
        </Container>
    )
}