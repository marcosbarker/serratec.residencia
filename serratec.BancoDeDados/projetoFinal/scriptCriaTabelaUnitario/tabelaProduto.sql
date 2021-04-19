create table produto 
(
    id_produto serial primary key not null,
    nome varchar(30) not null,
    descricao varchar(150),
    qtd_estoque integer not null,
    data_fabricacao date not null,
    valor_unitario money not null,
    id_usuario integer not null,
    id_categoria integer not null,
    foreign key (id_categoria) references categoria,
    foreign key (id_usuario) references usuario
);