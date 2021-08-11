import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { AuthContext } from "../../providers/auth";
import MaterialTable from "material-table";
import Header from '../../components/Header'
import { useHistory } from "react-router";
import { DivMaterialTable } from "../../components/DivMaterialTable/styles";

const PesquisaColaborador = () => {
  const history = useHistory();
  const [colaboradores, setColaboradores] = useState([]);
  const { colaborador, setColaborador } = React.useContext(AuthContext);

  useEffect(async () => {
    const response = await api.get('/colaboradores');
    setColaboradores(response.data);
  }, []);

  const columns = [
    { title: "Nome", field: "nome" },
    { title: "Usuario", field: "usuario.usuario" },
    { title: "Email", field: "email" },
    { title: 'Permissão', field: 'permissao', lookup: { 0: 'Colab', 1: 'Lider', 2: 'Admin' } },
    { title: "Posicao", field: "posicao.nome" },
    { title: "Projeto", field: "setColabsProjs[0].projeto.nome" },
    { title: "Função", field: "setColabsProjs[0].funcao" },
  ]

  const actions = [{
    field: 'idColaboradores',
    icon: 'person',
    tooltip: 'Detalhes Colaborador',
    onClick: (event, rowData) => (
      setColaborador({ idColaboradores: rowData.idColaboradores }),
      history.push('/colaborador')
    )
  }]

  return (
    <>
      <Header titulo='Lista de Colaboradores' textoButton='Cadastrar Colaborador' caminho='cadastrarcolaboradores' />
      <DivMaterialTable>
        <MaterialTable
          style={{width:'100%'}}
          title="Pesquisa Colaboradores"
          data={colaboradores}
          columns={columns}
          actions={actions}
          options={{ filtering: true }}
        />
      </DivMaterialTable>
    </>
  );
};

export default PesquisaColaborador;