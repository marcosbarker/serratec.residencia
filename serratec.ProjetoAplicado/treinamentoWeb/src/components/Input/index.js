import React from 'react';
import { Mensagem, InputDiv, Label, InputComum } from './styles';
import { AuthContext } from "../../providers/auth";

const Input = (p) => {
    console.log(p);
    const { usuario } = React.useContext(AuthContext);
    function handlePermissao(p) {
        if (p) {
            return <option value={2}>Administrador</option>;
        }
    }
    const posicoesSelect = p?.posicoes?.map((p, i) => (
        <option key={i} value={p.idPosicoes}>
          {p.nome}
        </option>
      ));
    const selectTipo = () => {
        if (p.name == 'cnh') {
            return (
                <>
                    <option value="">Sem CNH</option>
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    <option value="E">E</option>
                </>
            )
        } else if (p.name == 'permissao') {
            return (
                <>
                    <option value={0}>Colaborador</option>
                    <option value={1}>Lider</option>
                    {handlePermissao(usuario.isAdmin)}
                </>
            )
        } else if(p.name == 'posicao'){
            return (
                posicoesSelect
            )
        } else if (p.name == 'estado') {
            return (
                <>
                    <option value="">Selecione um estado</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espírito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </>
            )
        }
    }
    return (
        <>
            <Mensagem component="span" name={p.name} />
            <InputDiv>
                <Label for={p?.name}>{p?.label}</Label>
                <InputComum name={p?.name} type={p?.type} placeholder={p?.placeholder} component={p?.component} >
                    {selectTipo()}
                </InputComum>
            </InputDiv>
        </>
    );
}

export default Input;
