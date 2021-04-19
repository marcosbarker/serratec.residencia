insert into pedido (id_usuario)
values (1), (2), (3),(4),(5),(6),(7),(8);

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(2, 5, 1);
update produto
set qtd_estoque = qtd_estoque - 2 
where id_produto = 5;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(2, 8, 2);
update produto
set qtd_estoque = qtd_estoque - 2 
where id_produto = 3;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(200, 6, 2);
update produto
set qtd_estoque = qtd_estoque - 200 --quantidade comprada
where id_produto = 2;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(1, 7, 4);
update produto
set qtd_estoque = qtd_estoque - 1 --quantidade comprada
where id_produto = 3;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(5, 3, 5);
update produto
set qtd_estoque = qtd_estoque - 5 
where id_produto = 4;

insert into item_quantidade (quantidade_item, id_produto, id_pedido)
values(8, 1, 6);
update produto
set qtd_estoque = qtd_estoque - 8 --quantidade comprada
where id_produto = 5;