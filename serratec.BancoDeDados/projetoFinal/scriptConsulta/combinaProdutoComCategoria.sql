-- Inner Join Produto Categoria

select produto.nome as "Produto", categoria.nome as "Categoria" 
from produto 
inner join categoria 
on produto.id_usuario = categoria.id_categoria;