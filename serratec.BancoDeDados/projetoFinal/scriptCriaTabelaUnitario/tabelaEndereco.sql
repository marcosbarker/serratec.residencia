create table endereco
(
    id_endereco serial primary key not null,
    cep char(8) not null,
    estado char(2) not null,
    cidade varchar(40) not null,
    bairro varchar(30) not null,
    rua varchar(40) not null,
    numero int not null
);