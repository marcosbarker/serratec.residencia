-- Group By Usuario Por Localização

select endereco.bairro, count(usuario.id_usuario) as "Usuario por localização"
from usuario 
join endereco 
on usuario.id_endereco = endereco.id_endereco
group by (endereco .bairro);