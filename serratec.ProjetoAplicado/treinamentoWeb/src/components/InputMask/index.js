import React from 'react';
import { Mensagem, InputDiv, Label, InputComum, MaskInput } from './styles';

const InputMask = (p) => {
    const cpfMask = [/\d/, /\d/, /\d/, ".", /\d/, /\d/, /\d/, ".", /\d/, /\d/, /\d/, "-", /\d/, /\d/,];
    const rgMask = [/\d/, /\d/, ".", /\d/, /\d/, /\d/, ".", /\d/, /\d/, /\d/, "-", /\d/,];
    const cepMask = [/\d/, /\d/, /\d/, /\d/, /\d/, "-", /\d/, /\d/, /\d/];

    const mascara = (field) => {
        if (p?.name == 'cpf') {
            return (
                <MaskInput
                    {...field}
                    type="text"
                    placeholder={p?.placeholder}
                    mask={cpfMask}
                />
            )
        } else if (p?.name == 'rg') {
            return (
                <MaskInput
                    {...field}
                    type="text"
                    placeholder={p?.placeholder}
                    mask={rgMask}
                />
            )
        } else if (p.name == 'cep') {
            return(
                <MaskInput
                    {...field}
                    type="text"
                    placeholder={p?.placeholder}
                    mask={cepMask}
                />
            )
        }

    }
    return (
        <>
            <Mensagem component="span" name={p.name} />
            <InputDiv>
                <Label for={p?.name}>{p?.label}</Label>
                <InputComum name={p?.name} type={p?.type} placeholder={p?.placeholder}
                    render={({ field }) => (
                        mascara(field)
                    )}
                />
            </InputDiv>
        </>
    );
}

export default InputMask;
