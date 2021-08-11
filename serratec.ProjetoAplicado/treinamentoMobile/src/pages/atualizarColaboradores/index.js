import React, { useState, useEffect } from 'react';
import {
    CadastroButton,
    InputCadastro,
    CadastroText,
    CadastroScroll,
    InputArea,
    Container,
    ButtonView,
    EspacoView,
    PickerView,
    Titulo,
    TituloView
} from './styles';
import axios from 'axios';
import { Picker } from '@react-native-picker/picker';
import { Alert, Text } from 'react-native';
import { AuthContext } from '../../services/auth';
import { mask } from 'remask';
import { Formik } from 'formik';
import * as yup from 'yup';
import DatePicker from 'react-native-datepicker';

export default function AtualizarColaboradores({ route, navigation }) {
    const { isAdmin } = React.useContext(AuthContext);
    const [posicoes, setPosicoes] = useState([]);
    const { colaboradores } = route.params

    const padraoCpf = '999.999.999-99'
    const padraoRg = '99.999.999-9'

    const getPosicao = async () => {
        try {
            const response = await axios.get('https://api-treinamento-t2m.herokuapp.com/posicoes')
            setPosicoes(response.data);
        } catch (error) {
            console.error(error);
        }
    }

    useEffect(() => {
        getPosicao()
    }, []);

    const handlePermissao = (p) => {
        if (p) {
            return <Picker.Item color='#181818' label='Administrador' value={2} />
        }
    }

    const updateValidations = yup.object().shape({
        nome: yup.string().min(5, ({ min }) => `Mínimo de ${min} caracteres`).max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Nome é obrigatório"),
        dataNascimento: yup.date("Inserir uma data valida").required("Data de nascimento é obrigatória"),
        email: yup.string().email("Inserir um email valido").max(30, ({ max }) => `Maximo de ${max} caracteres`).required("Email é obrigatório"),
        pix: yup.string().max(40, ({ max }) => `Maximo de ${max} caracteres`),
        cpf: yup.string().min(14, ({ min }) => `Minimo de ${min} caracteres`).required("CPF é obrigatório"),
        rg: yup.string().min(9, ({ min }) => `Minimo de ${min} caracteres`).required("RG é obrigatório")
    });

    return (
        <Container>
            <CadastroScroll>
                <EspacoView>
                    <TituloView>
                        <Titulo>Atualizar Colaboradores</Titulo>
                    </TituloView>
                    <Formik initialValues={{
                        nome: colaboradores.nome,
                        dataNascimento: colaboradores.dataNascimento,
                        email: colaboradores.email,
                        pix: colaboradores.pix,
                        cpf: colaboradores.cpf,
                        rg: colaboradores.rg,
                        cnh: colaboradores.cnh,
                        permissao: colaboradores.permissao,
                        idPosicoes: colaboradores.idPosicoes
                    }}
                        onSubmit={async (values) => {
                            const colaborador = {
                                nome: values.nome,
                                dataNascimento: values.dataNascimento,
                                email: values.email,
                                pix: values.pix,
                                cpf: mask(values.cpf, padraoCpf),
                                rg: mask(values.rg, padraoRg),
                                cnh: values.cnh,
                                permissao: values.permissao,
                                posicao: {
                                    idPosicoes: values.idPosicoes,
                                },
                            };
                            try {
                                const response = await axios.put(`https://api-treinamento-t2m.herokuapp.com/colaboradores/${colaboradores.idColaboradores}`, colaborador);
                                Alert.alert("Colaborador atualizado com sucesso!");
                                navigation.reset({
                                    routes: [{ name: 'Lista de Colaboradores' }]
                                });
                            } catch {
                                Alert.alert('Envio de dados nao permitidos...')
                                Alert.alert('Os Campos CPF, RG, email e Pix devem ter valores únicos, cheque se algum colaborador cadastrado ja possui esses dados!')
                            }
                        }}
                        validationSchema={updateValidations}>
                        {({ handleChange, handleBlur, handleSubmit, setFieldValue, values, errors, touched, isValid }) => (
                            <>
                                <InputArea>
                                    <CadastroText>Nome Completo:</CadastroText>
                                    <InputCadastro name='nome' onChangeText={handleChange('nome')} onBlur={handleBlur('nome')} value={values.nome} autoCapitalize='words' placeholder='Nome' placeholderTextColor='#181818' />
                                    {(errors.nome && touched.nome) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.nome}</Text>
                                    }
                                    <CadastroText>RG:</CadastroText>
                                    <InputCadastro name='rg' onChangeText={handleChange('rg')} onBlur={handleBlur('rg')} value={mask(values.rg, padraoRg)} keyboardType='numeric' placeholder='RG' placeholderTextColor='#181818' />
                                    {(errors.rg && touched.rg) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.rg}</Text>
                                    }
                                    <CadastroText>CPF:</CadastroText>
                                    <InputCadastro name='cpf' onChangeText={handleChange('cpf')} onBlur={handleBlur('cpf')} value={mask(values.cpf, padraoCpf)} keyboardType='numeric' placeholder='CPF' placeholderTextColor='#181818' />
                                    {(errors.cpf && touched.cpf) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.cpf}</Text>
                                    }
                                    <CadastroText>Data de Nascimento:</CadastroText>
                                    <DatePicker style={{ width: 259, backgroundColor: 'white', margin: 5, height: 50, borderRadius: 5 }}
                                        customStyles={{
                                            dateInput: {
                                                borderWidth: 0,
                                                borderBottomWidth: 0,

                                            },
                                            dateText: {
                                                marginTop: 8,
                                                fontSize: 21,
                                                color: "#181818"
                                            }
                                        }}
                                        date={values.dataNascimento}
                                        format='YYYY-MM-DD'
                                        minDate='1970-01-01'
                                        maxDate={new Date()}
                                        onDateChange={(data) => setFieldValue('dataNascimento', data)} />
                                    <CadastroText>E-mail:</CadastroText>
                                    <InputCadastro name='email' onChangeText={handleChange('email')} onBlur={handleBlur('email')} value={(values.email)} keyboardType='email-address' placeholder='E-mail' placeholderTextColor='#181818' />
                                    {(errors.email && touched.email) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.email}</Text>
                                    }
                                    <CadastroText>Pix:</CadastroText>
                                    <InputCadastro name='pix' onChangeText={handleChange('pix')} onBlur={handleBlur('pix')} value={values.pix} autoCapitalize='none' placeholder='Pix' placeholderTextColor='#181818' />
                                    {(errors.pix && touched.pix) &&
                                        <Text style={{ fontSize: 15, color: 'red' }}>{errors.pix}</Text>
                                    }
                                    <CadastroText>CNH:</CadastroText>
                                    <PickerView>
                                        <Picker
                                            mode='dropdown'
                                            itemStyle={{ color: '#181818' }}
                                            selectedValue={values.cnh}
                                            onValueChange={(itemValue) => setFieldValue('cnh', itemValue)}>
                                            <Picker.Item color='#181818' label='Sem CNH' value='' />
                                            <Picker.Item color='#181818' label='A' value='A' />
                                            <Picker.Item color='#181818' label='B' value='B' />
                                            <Picker.Item color='#181818' label='C' value='C' />
                                            <Picker.Item color='#181818' label='D' value='D' />
                                            <Picker.Item color='#181818' label='E' value='E' />
                                        </Picker>
                                    </PickerView>
                                    <CadastroText>Posição:</CadastroText>
                                    <PickerView>
                                        <Picker
                                            mode='dropdown'
                                            itemStyle={{ color: '#181818' }}
                                            selectedValue={values.idPosicoes}
                                            onValueChange={(itemValue) => setFieldValue('idPosicoes', itemValue)}>
                                            {posicoes.map((p, i) => (
                                                <Picker.Item color='#181818' key={i} label={p.nome} value={p.idPosicoes} />
                                            )
                                            )}
                                        </Picker>
                                    </PickerView>
                                    <CadastroText>Permissão:</CadastroText>
                                    <PickerView>
                                        <Picker
                                            mode='dropdown'
                                            itemStyle={{ color: '#181818' }}
                                            selectedValue={values.permissao}
                                            onValueChange={(itemValue) => setFieldValue('permissao', itemValue)}>
                                            <Picker.Item color='#181818' label='Colaborador' value={0} />
                                            <Picker.Item color='#181818' label='Líder' value={1} />
                                            {handlePermissao(isAdmin)}
                                        </Picker>
                                    </PickerView>
                                </InputArea>
                                <ButtonView>
                                    <CadastroButton onPress={() => handleSubmit()}
                                        disabled={!isValid}>
                                        <CadastroText>SALVAR</CadastroText>
                                    </CadastroButton>
                                </ButtonView>
                            </>
                        )}
                    </Formik>
                </EspacoView>
            </CadastroScroll>
        </Container>
    )
}
