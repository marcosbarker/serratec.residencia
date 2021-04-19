create table contato
(
    id_contato serial primary key not null,
    ddd char (2) not null,
    telefone char (9) not null,
    email varchar(50) not null,
    id_usuario integer not null,
    foreign key (id_usuario) references usuario
);