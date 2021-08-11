import React, { useState } from 'react';
import axios from 'axios';
import { Container, CadastroText, InputArea, InputCadastro, FormacaoText, FormaText, FormaView, FormaButton } from './styles';
import { Alert, Text } from 'react-native';
import DatePicker from 'react-native-datepicker';
import { Formik } from 'formik';
import * as yup from 'yup';

export default function CadastroFormacoes({ route, navigation }) {

    const { colaborador } = route.params

    const formValidationSchema = yup.object().shape({
        nome: yup.string().max(50, ({ max }) => `Máximo de ${max} caracteres`).required('Nome é obrigatório'),
        nivel: yup.string().max(50, ({ max }) => `Máximo de ${max} caracteres`).required('Nivel é obrigatório'),
        instituicao: yup.string().max(30, ({ max }) => `Máximo de ${max} caracteres`).required('O nome da Instituição é obrigatório')
    })

    return (
        <Container>
            <FormaView>
                <FormacaoText> Inserir Formações </FormacaoText>
            </FormaView>
            <Formik validationSchema={formValidationSchema}
                initialValues={{
                    nome: '',
                    nivel: '',
                    instituicao: '',
                    dataEntrada: '',
                    dataConclusao: ''
                }}
                onSubmit={async (values) => {
                    const formacao = {
                        nome: values.nome,
                        nivel: values.nivel,
                        instituicao: values.instituicao
                    }
                    const datas = {
                        dataEntrada: values.dataEntrada,
                        dataConclusao: values.dataConclusao
                    }
                    try {

                        const responseFormacao = await axios.post('https://api-treinamento-t2m.herokuapp.com/formacoes', formacao)
                        const idFormacao = responseFormacao.data.idFormacoes

                        await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsForms/colaborador/${colaborador.idColaboradores}/formacaoAInserir/${idFormacao}`, datas)
                        Alert.alert('Formação inserida com sucesso!');
                        navigation.reset({
                            routes: [{ name: 'Lista de Colaboradores' }]
                        })
                    } catch (error) {
                        Alert.alert('Envio de dados nao permitido, cheque as informações passadas');
                        console.error(error);
                    }
                }}>
                {({ handleChange, handleBlur, handleSubmit, setFieldValue, values, errors, touched, isValid }) => (
                    <>
                        <InputArea>
                            <CadastroText>Formação:</CadastroText>
                            <InputCadastro name='nome' onChangeText={handleChange('nome')} onBlur={handleBlur('nome')} value={values.nome} placeholder='Nome' placeholderTextColor='#181818' />
                            {(errors.nome && touched.nome) &&
                                <Text style={{ fontSize: 15, color: 'red' }}>{errors.nome}</Text>
                            }
                            <CadastroText>Nível de Formação:</CadastroText>
                            <InputCadastro name='nivel' onChangeText={handleChange('nivel')} onBlur={handleBlur('nivel')} value={values.nivel} placeholder='Nível' placeholderTextColor='#181818' />
                            {(errors.nivel && touched.nivel) &&
                                <Text style={{ fontSize: 15, color: 'red' }}>{errors.nivel}</Text>
                            }
                            <CadastroText>Instituição:</CadastroText>
                            <InputCadastro name='instituicao' onChangeText={handleChange('instituicao')} onBlur={handleBlur('instituicao')} value={values.instituicao} placeholder='Instituição' placeholderTextColor='#181818' />
                            {(errors.instituicao && touched.instituicao) &&
                                <Text style={{ fontSize: 15, color: 'red' }}>{errors.instituicao}</Text>
                            }
                            <CadastroText>Data de entrada:</CadastroText>
                            <DatePicker style={{ width: 270, margin: 10, backgroundColor: "#eaeaea", borderRadius: 8, }}
                                customStyles={{
                                    dateInput: {
                                        borderWidth: 0,
                                        borderBottomWidth: 0,

                                    },
                                    placeholderText: {
                                        fontSize: 17,
                                        color: '#181818'
                                    },
                                    dateText: {
                                        fontSize: 21,
                                        color: "#181818"
                                    }
                                }}
                                date={values.dataEntrada}
                                placeholder='Data de Entrada'
                                format='YYYY-MM-DD'
                                minDate='1990-01-01'
                                maxDate={new Date()}
                                onDateChange={(data) => setFieldValue('dataEntrada', data)} />
                            <CadastroText>Data de Conclusao:</CadastroText>

                            <DatePicker style={{ width: 270, margin: 10, backgroundColor: "#eaeaea", borderRadius: 8 }}
                                customStyles={{
                                    dateInput: {
                                        borderWidth: 0,
                                        borderBottomWidth: 0,

                                    },
                                    placeholderText: {
                                        fontSize: 17,
                                        color: '#181818'
                                    },
                                    dateText: {
                                        fontSize: 21,
                                        color: "#181818"
                                    }
                                }}
                                date={values.dataConclusao}
                                placeholder='Data de Conclusão'
                                format='YYYY-MM-DD'
                                minDate='1990-07-07'
                                maxDate={new Date()}
                                onDateChange={(data) => setFieldValue('dataConclusao', data)} />

                        </InputArea>
                        <FormaView>
                            <FormaButton onPress={() => handleSubmit()}
                                disabled={!isValid}>
                                <FormaText>Salvar</FormaText>
                            </FormaButton>
                        </FormaView>
                    </>
                )}
            </Formik>
        </Container>
    )

}
