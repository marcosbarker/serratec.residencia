--create database projetofinal

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

create table contato
(
    id_contato serial primary key not null,
    ddd char (2) not null,
    telefone char (9) not null,
    email varchar(50) not null,
    id_usuario integer not null,
    foreign key (id_usuario) references usuario
);

create table categoria
(
    id_categoria serial primary key not null,
    nome varchar(30) not null,
    descricao varchar(150) not null
);

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

create table pedido
(
    id_pedido serial primary key not null,
    data_realizado timestamp with time zone default current_timestamp not null,
    id_usuario integer not null,
    foreign key (id_usuario) references usuario
);

create table item_quantidade
(
    id_item_pedido serial primary key not null,
    quantidade_item integer not null,
    id_produto integer not null,
    id_pedido integer not null,
    foreign key (id_pedido) references pedido,
    foreign key (id_produto) references produto
);

INSERT INTO public.endereco (cep,estado,cidade,bairro,rua,numero) VALUES
	 ('25675160','RJ','Petrópolis','Mosela','Rua Bataillard',1179),
	 ('30620690','MG','Belo Horizonte','Milionários','Rua Mosela',153),
	 ('14060680','RJ','Rio de Janeiro','Presidente Dutra','Rua Ângelo Romano',186),
	 ('25640071','RJ','Petrópolis','Castelanea','Euclides da Cunha',247),
	 ('25635471','RJ','Petrópolis','Alto da Serra','Rua Teresa',1351),
	 ('25640020','RJ','Petrópolis','Avenida Dom Pedro I ','Centro',1650),
	 ('25685250','RJ','Petrópolis','Avenida Koeller ','Centro',265),
	 ('02181160','SP','São paulo','Parque Novo Mundo','Rua Francisco Fanganiello',127);
	
INSERT INTO public.usuario (nome,nome_usuario,cpf,data_nascimento,id_endereco) VALUES
	 ('Lucimar Macedo','lucio25','135.157.952-16','1978-05-23',5),
	 ('Valdemar Ladislau','ladisVal','122.666.548-98','1932-06-24',7),
	 ('Roberto','robertinho','132.567.891-22','0192-04-28',1),
	 ('Ronaldo Nazario','femonomeno','199.420.020-62','1976-09-22',8),
	 ('Edison Arantes','pelé','197.013.464-20','1948-10-23',4),
	 ('Julio','julioRica','135.157.657-89','1954-01-22',2),
	 ('Jaime Costa','JaiminFadi','567.987.423-36','1945-06-25',3),
	 ('Jose','zezinho','147.473.559-87','1984-10-09',6);

INSERT INTO public.contato (ddd,telefone,email,id_usuario) VALUES
	 ('24','999254158','lucimar@hotmail.com',5),
	 ('24','999357892','valdemar@gmail.com',7),
	 ('22','985741255','robertinho@gmail.com',1),
	 ('11','988651245','ronaldofenemon@copas.com.br',8),
	 ('24','988587941','pelezinhomelhordomundo@gmail.com',4),
	 ('21','999698859','jaimimfadiga@gmail.com',3),
	 ('24','999698859','zezinho@gmail.com',6),
	 ('21','998398842','jurica@hotmail.com',2);

INSERT INTO public.categoria (nome,descricao) VALUES
	 ('videogame','consoles, acessorios e jogos'),
	 ('bebidas','vinho, cerveja, refrigerante, whisky, vodka'),
	 ('pet shop','racao, brinquedos e roupas'),
	 ('eletroportáteis','automotivo, brinquedos, moveis'),
	 ('automotivo','oficina, pneus e fluidos');
	
INSERT INTO public.produto (nome,descricao,qtd_estoque,data_fabricacao,valor_unitario,id_usuario,id_categoria) VALUES
	 ('Coleira','Coleira raças pequenas',57,'2020-01-15','10,40',1,3),
	 ('Vinho tinto','Vinho top. Tão bom que bebi metade',10,'1999-05-23','245,99',2,2),
	 ('Playstation5','Console de jogos eletrônicos de nona geração e sucessor do PlayStation 4, desenvolvido pela Sony Interactive Entertainment',4,'2020-10-01','5.000,00',3,1),
	 ('pneu careca','Peneu de fusca, já no arame. Ótimo pra fazer um chinelo ',10,'2014-06-25','150,00',4,5),
	 ('Vodka','Pioneira na categoria de Vodka, sendo a principal referência no mundo',600,'2020-12-30','7,00',5,2),
	 ('Osso Roído','Osso roído por, nada mais nada menos que um vira lata caramelo. Item extremamente valioso',0,'1980-04-10','5,00',6,3),
	 ('Oficina','O Jogo oficina master 5000R possui amplo mix de chaves, soquetes e acessórios, nos diversos perfis essenciais para o dia-a-dia',0,'2021-02-22','10.000,00',7,5),
	 ('Vinho','Tinto seco',10,'2021-03-28','25,80',8,2);

--insert/update 
--populando as tabelas pedidos, item_quantidade e atualizando a quantidade do estoque do usuário(vendedor)

insert into pedido (id_usuario)
values (1), (2), (3),(4),(5),(6),(7),(8);

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(2, 5, 1);
update produto
set qtd_estoque = qtd_estoque - 2 --quantidade comprada
where id_produto = 5;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(2, 8, 2);
update produto
set qtd_estoque = qtd_estoque - 2 
where id_produto = 3;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(200, 6, 2);
update produto
set qtd_estoque = qtd_estoque - 200 
where id_produto = 2;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(1, 7, 4);
update produto
set qtd_estoque = qtd_estoque - 1
where id_produto = 3;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(5, 3, 5);
update produto
set qtd_estoque = qtd_estoque - 5 
where id_produto = 4;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(8, 1, 6);
update produto
set qtd_estoque = qtd_estoque - 8
where id_produto = 5;