import React from 'react';
import Modal from 'react-modal';
import { Button } from '../Button/styles';

const Alerta = (p) => {
    return (
        <div>
            <Modal isOpen={p.isOpen} onRequestClose={() => p.func(false)}
                style={{
                    overlay: {
                        position: 'fixed',
                        top: 0,
                        left: 0,
                        right: 0,
                        bottom: 0,
                        backgroundColor: 'rgba(0, 0, 0, 0.75)'
                    },
                    content: {
                        display: 'flex',
                        flexDirection:'column',
                        alignItems:'center',
                        justifyContent:'center',
                        textAlign:'center',
                        fontSize:'max(1vw,0.6rem)',
                        fontWeight:'bold',
                        position: 'absolute',
                        width: '50%',
                        top: '35%',
                        left: '24.5%',
                        right: '10%',
                        bottom: '35%',
                        border: '1px solid #ccc',
                        background: '#fff',
                        overflow: 'auto',
                        WebkitOverflowScrolling: 'touch',
                        borderRadius: '1rem',
                        outline: 'none',
                        padding: '10px'
                    }
                }}
            >
                <h1>{p.texto}</h1>
                <Button onClick={() => p.func(false)}>OK</Button>
            </Modal>
        </div>
    );
}

export default Alerta;
