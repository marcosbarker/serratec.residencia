import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { AuthContext } from '../../../providers/auth';

const RoutesPrivate = ({component:Component, ...rest}) => {
    const { usuario} = React.useContext(AuthContext);
    return (
       <Route
       {...rest}
       render={()=> usuario.isAtivo
        ? <Component {...rest} />
        : <Redirect to="/" />
       }
       />
    );
}

export default RoutesPrivate;
