import React, { useState, useEffect } from 'react';
import { CertificacaoScroll, Container, CertiText, CertifiArea, CertiView, DadosView, DadosText, Titulo, EndText, EndButton, EndView, } from './styles';
import axios from 'axios';
import { Alert } from 'react-native';
import { AuthContext } from '../../services/auth';

export default function certificacao({ route, navigation }) {

  const { colaborador } = route.params

  const { colaboradores, setColaboradores } = React.useContext(AuthContext);


  const [refresh, setRefresh] = useState(false);

  const getColab = async () => {
    try {
      const responseColab = await axios.get(`https://api-treinamento-t2m.herokuapp.com/colaboradores/${colaboradores.idColaboradores}`);
      setColaboradores(responseColab.data);
    } catch (error) {
      Alert.alert('Ocorreu um erro... ' + error);
    }
  }

  useEffect(() => {
    getColab()
  }, [refresh]);

  function handleCadasCert() {
    navigation.navigate('Inserir Certificações em Colaborador', { colaborador })
  }

  async function handleRemoveCert(p) {
    await axios.put(`https://api-treinamento-t2m.herokuapp.com/colabsCerts/colaborador/${colaboradores.idColaboradores}/certificacaoARemover/${p.certificacao.idCertificacoes}`);
    Alert.alert("Certificação removida com sucesso!");
    setRefresh(!refresh);
  };

  return (
    <Container>
      <CertificacaoScroll>
        <Titulo>Certificações: </Titulo>
        {colaboradores.setColabsCerts.map((p, i) => {
          return (
            <CertifiArea key={i}>
              <CertiView>
                <CertiText>Nome: </CertiText>
              </CertiView>
              <DadosView>
                <DadosText>{p.certificacao.nomeCertificado}</DadosText>
              </DadosView>
              <CertiView>
                <CertiText>Instituição: </CertiText>
              </CertiView>
              <DadosView>
                <DadosText>{p.certificacao.instituicaoCertificado}</DadosText>
              </DadosView>
              <EndView>
                <EndButton onPress={() => handleRemoveCert(p)}>
                  <EndText>Deletar</EndText>
                </EndButton>
              </EndView>
            </CertifiArea>
          )
        })}
      </CertificacaoScroll>
    </Container>

  )

}