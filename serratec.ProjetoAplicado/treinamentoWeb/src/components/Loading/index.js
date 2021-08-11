import React from 'react';
import ReactLoading from 'react-loading'

const Loading = ({type, color}) => {
    return (
        <ReactLoading type={type} color={color} height={'10vh'} with={'10vw'} />
    );
}

export default Loading;
