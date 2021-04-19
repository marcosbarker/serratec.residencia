create table item_quantidade
(
    id_item_pedido serial primary key not null,
    quantidade_item integer not null,
    id_produto integer not null,
    id_pedido integer not null,
    foreign key (id_pedido) references pedido,
    foreign key (id_produto) references produto
);