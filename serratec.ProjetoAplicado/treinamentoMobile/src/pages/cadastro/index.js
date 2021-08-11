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

export default function Cadastro({ navigation }) {
  const { isAdmin } = React.useContext(AuthContext);
  const [posicoes, setPosicoes] = useState([]);

  const padraoCpf = '999.999.999-99'
  const padraoRg = '99.999.999-9'
  const padraoCep = '99999-999'

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


  const cadastroValidations = yup.object().shape({
    nome: yup.string().min(5, ({ min }) => `Mínimo de ${min} caracteres`).max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Nome é obrigatório"),
    dataNascimento: yup.date("Inserir uma data valida").required("Data de nascimento é obrigatória"),
    email: yup.string().email("Inserir um email valido").max(30, ({ max }) => `Maximo de ${max} caracteres`).required("Email é obrigatório"),
    pix: yup.string().max(40, ({ max }) => `Maximo de ${max} caracteres`),
    cpf: yup.string().min(11, ({ min }) => `Minimo de ${min} caracteres`).required("CPF é obrigatório"),
    rg: yup.string().min(9, ({ min }) => `Minimo de ${min} caracteres`).required("RG é obrigatório"),
    rua: yup.string().max(100, ({ max }) => `Maximo de ${max} caracteres`).required("Rua é obrigatório"),
    numero: yup.string().max(10, ({ max }) => `Maximo de ${max} caracteres`).required("Numero é obrigatório"),
    complemento: yup.string().max(15, ({ max }) => `Maximo de ${max} caracteres`),
    bairro: yup.string().max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Bairro é obrigatório"),
    cidade: yup.string().max(50, ({ max }) => `Maximo de ${max} caracteres`).required("Cidade é obrigatório"),
    estado: yup.string().required("Estado é obrigatório"),
    cep: yup.string().min(8, ({ min }) => `Minimo de ${min} caracteres`).required("CEP é obrigatório"),
    pais: yup.string().max(15, ({ max }) => `Maximo de ${max} caracteres`).required("Pais é obrigatório"),
  });

  return (
    <Container>
      <CadastroScroll>
        <EspacoView>
          <TituloView>
            <Titulo>Cadastro de Colaboradores</Titulo>
          </TituloView>
          <Formik initialValues={{
            nome: "",
            dataNascimento: "",
            email: "",
            pix: "",
            cpf: "",
            rg: "",
            cnh: "",
            permissao: 0,
            idPosicoes: 2,
            rua: "",
            numero: "",
            complemento: "",
            bairro: "",
            cidade: "",
            estado: "",
            cep: "",
            pais: ""
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
              const endereco = {
                rua: values.rua,
                numero: values.numero,
                complemento: values.complemento,
                bairro: values.bairro,
                cidade: values.cidade,
                estado: values.estado,
                cep: mask(values.cep, padraoCep),
                pais: values.pais,
              };
              try {
                const responseColaborador = await axios.post("https://api-treinamento-t2m.herokuapp.com/colaboradores", colaborador);
                const idColaborador = responseColaborador.data.idColaboradores;

                const responseUsuario = await axios.get(`https://api-treinamento-t2m.herokuapp.com/colaboradores/${idColaborador}`);

                const responseEndereco = await axios.post("https://api-treinamento-t2m.herokuapp.com/enderecos", endereco);
                const idEndereco = responseEndereco.data.idEnderecos;

                const response = await axios.put(
                  `https://api-treinamento-t2m.herokuapp.com/colabsEndrs/colaborador/${idColaborador}/enderecoAInserir/${idEndereco}`
                );
                if (colaborador.permissao != 0) {
                  Alert.alert("Cadastro realizado com sucesso!");
                  Alert.alert(`Usuario: ${responseUsuario.data.usuario.usuario} && Senha: ${responseUsuario.data.usuario.senha}`);
                  navigation.reset({
                    routes: [{ name: 'Lista de Colaboradores' }]
                  });
                } else {
                  Alert.alert("Cadastro realizado com sucesso!");
                  navigation.reset({
                    routes: [{ name: 'Lista de Colaboradores' }]
                  });
                }
              } catch {
                Alert.alert('Envio de dados não permitido, verifique se algum colaborador ja possui esses dados!')
              }
            }}
            validationSchema={cadastroValidations}>
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
                  <DatePicker style={{ width: 225, backgroundColor: 'white', margin: 5, height: 50, borderRadius: 5 }}
                    customStyles={{
                      dateInput: {
                        borderWidth: 0,
                        borderBottomWidth: 0,

                      },
                      placeholderText: {
                        marginTop: 8,
                        fontSize: 17,
                        color: '#181818'
                      },
                      dateText: {
                        marginTop: 8,
                        fontSize: 21,
                        color: "#181818"
                      }
                    }}
                    date={values.dataNascimento}
                    placeholder='Data de Nascimento'
                    format='YYYY-MM-DD'
                    minDate='1970-01-01'
                    maxDate={new Date()}
                    onDateChange={(data) => setFieldValue('dataNascimento', data)} />
                  <CadastroText>E-mail:</CadastroText>
                  <InputCadastro name='email' onChangeText={handleChange('email')} onBlur={handleBlur('email')} keyboardType='email-address' value={(values.email)} placeholder='E-mail' placeholderTextColor='#181818' />
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
                  <CadastroText>País:</CadastroText>
                  <InputCadastro name='pais' onChangeText={handleChange('pais')} onBlur={handleBlur('pais')} value={values.pais} placeholder='País' placeholderTextColor='#181818' />
                  {(errors.pais && touched.pais) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.pais}</Text>
                  }
                  <CadastroText>Estado:</CadastroText>
                  <PickerView>
                    <Picker
                      mode='dropdown'
                      itemStyle={{ color: '#181818' }}
                      selectedValue={values.estado}
                      onValueChange={(itemValue) => setFieldValue('estado', itemValue)}>
                      <Picker.Item color='#181818' label='Escolha um Estado' value='' />
                      <Picker.Item color='#181818' value='AC' label='Acre' />
                      <Picker.Item color='#181818' value='AL' label='Alagoas' />
                      <Picker.Item color='#181818' value='AP' label='Amapá' />
                      <Picker.Item color='#181818' value='AM' label='Amazonas' />
                      <Picker.Item color='#181818' value='BA' label='Bahia' />
                      <Picker.Item color='#181818' value='CE' label='Ceará' />
                      <Picker.Item color='#181818' value='DF' label='Distrito Federal' />
                      <Picker.Item color='#181818' value='ES' label='Espírito Santo' />
                      <Picker.Item color='#181818' value='GO' label='Goiás' />
                      <Picker.Item color='#181818' value='MA' label='Maranhão' />
                      <Picker.Item color='#181818' value='MT' label='Mato Grosso' />
                      <Picker.Item color='#181818' value='MS' label='Mato Grosso do Sul' />
                      <Picker.Item color='#181818' value='MG' label='Minas Gerais' />
                      <Picker.Item color='#181818' value='PA' label='Pará' />
                      <Picker.Item color='#181818' value='PB' label='Paraíba' />
                      <Picker.Item color='#181818' value='PR' label='Paraná' />
                      <Picker.Item color='#181818' value='PE' label='Pernambuco' />
                      <Picker.Item color='#181818' value='PI' label='Piauí' />
                      <Picker.Item color='#181818' value='RJ' label='Rio de Janeiro' />
                      <Picker.Item color='#181818' value='RN' label='Rio Grande do Norte' />
                      <Picker.Item color='#181818' value='RS' label='Rio Grande do Sul' />
                      <Picker.Item color='#181818' value='RO' label='Rondônia' />
                      <Picker.Item color='#181818' value='RR' label='Roraima' />
                      <Picker.Item color='#181818' value='SC' label='Santa Catarina' />
                      <Picker.Item color='#181818' value='SP' label='São Paulo' />
                      <Picker.Item color='#181818' value='SE' label='Sergipe' />
                      <Picker.Item color='#181818' value='TO' label='Tocantins' />
                    </Picker>
                    {(errors.estado && touched.estado) &&
                      <Text style={{ fontSize: 15, color: 'red' }}>{errors.estado}</Text>
                    }
                  </PickerView>
                  <CadastroText>Cidade:</CadastroText>
                  <InputCadastro name='cidade' onChangeText={handleChange('cidade')} onBlur={handleBlur('cidade')} value={values.cidade} placeholder='Cidade' placeholderTextColor='#181818' />
                  {(errors.cidade && touched.cidade) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.cidade}</Text>
                  }
                  <CadastroText>Bairro:</CadastroText>
                  <InputCadastro name='bairro' onChangeText={handleChange('bairro')} onBlur={handleBlur('bairro')} value={values.bairro} placeholder='Bairro' placeholderTextColor='#181818' />
                  {(errors.bairro && touched.bairro) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.bairro}</Text>
                  }
                  <CadastroText>Rua:</CadastroText>
                  <InputCadastro name='rua' onChangeText={handleChange('rua')} onBlur={handleBlur('rua')} value={values.rua} placeholder='Logradouro' placeholderTextColor='#181818' />
                  {(errors.rua && touched.rua) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.rua}</Text>
                  }
                  <CadastroText>Número:</CadastroText>
                  <InputCadastro name='numero' onChangeText={handleChange('numero')} onBlur={handleBlur('numero')} value={values.numero} placeholder='Número' placeholderTextColor='#181818' />
                  {(errors.numero && touched.numero) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.numero}</Text>
                  }
                  <CadastroText>Complemento:</CadastroText>
                  <InputCadastro name='complemento' onChangeText={handleChange('complemento')} onBlur={handleBlur('complemento')} value={values.complemento} placeholder='Complemento' placeholderTextColor='#181818' />
                  {(errors.complemento && touched.complemento) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.complemento}</Text>
                  }
                  <CadastroText>CEP:</CadastroText>
                  <InputCadastro name='cep' onChangeText={handleChange('cep')} onBlur={handleBlur('cep')} value={mask(values.cep, padraoCep)} keyboardType='numeric' placeholder='CEP' placeholderTextColor='#181818' />
                  {(errors.cep && touched.cep) &&
                    <Text style={{ fontSize: 15, color: 'red' }}>{errors.cep}</Text>
                  }
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