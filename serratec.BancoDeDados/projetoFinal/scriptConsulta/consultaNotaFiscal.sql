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