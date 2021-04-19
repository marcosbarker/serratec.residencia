create table usuario
(
    id_usuario serial primary key not null,
    nome varchar not null,
    nome_usuario varchar(10) not null,
    cpf varchar(14) not null,
    data_nascimento date not null,
    id_endereco integer not null,
    foreign key (id_endereco) references endereco
);