-- Inner Join Produto Vendedor 

select produto.qtd_estoque as "Dip. em Estoque",
produto.nome as "Produtos", usuario.nome as "Vendedor" 
from produto
inner join usuario
on produto.id_usuario = usuario.id_usuario;