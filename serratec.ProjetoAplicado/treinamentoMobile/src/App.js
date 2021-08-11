import React from 'react';
import MyStack from './navegacao/MyStack';
import { NavigationContainer } from '@react-navigation/native';
import { AuthProvider } from './services/auth';

export default function App() {
    return (
        <>
        <AuthProvider>
        <NavigationContainer>
             <MyStack/>
        </NavigationContainer>
        </AuthProvider>
        </>
    );
};