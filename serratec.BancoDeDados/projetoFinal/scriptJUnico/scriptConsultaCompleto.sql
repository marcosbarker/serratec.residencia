-- Delete 

delete from produto where id_produto = 2;

-- Update

update contato set telefone = '998888998', email = 'jaimimfadigando@gmail.com'
where id_usuario = 7;

-- Inner Join Produto Categoria

select produto.nome as "Produto", categoria.nome as "Categoria" 
from produto 
inner join categoria 
on produto.id_usuario = categoria.id_categoria;

-- Inner Join Produto Vendedor 

select produto.qtd_estoque as "Dip. em Estoque",
produto.nome as "Produtos", usuario.nome as "Vendedor" 
from produto
inner join usuario
on produto.id_usuario = usuario.id_usuario;

-- Count Quantidade de Pedidos

select count(id_pedido) as "Quantidade de pedidos gerados"
from pedido;

-- Group By Usuario Por Localização

select e.bairro, count(usuario.id_usuario) as "Usuario por localizção"
from usuario 
join endereco 
on usuario.id_endereco = endereco.id_endereco
group by (endereco .bairro);

-- Nota Fiscal

select pedido.id_pedido as "Nº Pedido", produto.nome as "Produto", produto.valor_unitario as "Valor unitário", item_quantidade.quantidade_item as "Quantidade",
pedido.data_realizado as "Data Emissão", usuario.nome as "Comprador(a)", usuario.cpf, produto.valor_unitario * item_quantidade.quantidade_item as "total", usuario.nome as "Vendedor(a)"
from produto 
inner join usuario 
on produto.id_usuario = usuario.id_usuario 
inner join item_quantidade 
on produto.id_produto = item_quantidade.id_produto
inner join pedido 
on item_quantidade.id_pedido = pedido.id_pedido 
inner join usuario 
on pedido.id_usuario = usuario.id_usuario 
where pedido.id_pedido = 6;