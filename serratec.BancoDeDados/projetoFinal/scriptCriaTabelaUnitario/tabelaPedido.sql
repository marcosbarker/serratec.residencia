create table pedido
(
    id_pedido serial primary key not null,
    data_realizado timestamp with time zone default current_timestamp not null,
    id_usuario integer not null,
    foreign key (id_usuario) references usuario
);