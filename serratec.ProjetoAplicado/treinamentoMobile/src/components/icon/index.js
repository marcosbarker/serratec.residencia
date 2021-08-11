import React from 'react';
import MenuIcon from 'react-native-vector-icons/Ionicons';
import { ButtonIcon } from './styles'
import { DrawerActions } from '@react-navigation/native';
import {useNavigation} from '@react-navigation/native'

export default function Icon() {
    const navigation = useNavigation();
    return(
    <ButtonIcon onPress={() => navigation.dispatch(DrawerActions.openDrawer())}>
    <MenuIcon name='md-menu' size={40}/>
    </ButtonIcon>
    );
};