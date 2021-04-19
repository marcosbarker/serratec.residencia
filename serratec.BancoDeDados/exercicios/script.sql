-- EXERCÍCIOS 
--1) "Listar todos os livros que não tem editora informada"
--R: Optamos por alterar a classificação da coluna “Codigoeditora” para null, 
--face o erro no cadastro de livros sem editora.
--Códigos: 
a -  alter table alter column codigoeditora drop not null;
b -  select * From Livros Where codigoeditora is null

--2) "Listar todos os livros que estão vinculados a editoras que não existem."
--R: Optamos por incluir um código para editora como “Editora não registrada” de número 150.
--Códigos:
a - Insert Into Livros (CodigoLivro, NomeLivro, CodigoISBN)
Values…
b  - select * From livros where codigoeditora = 150”

--3) "Listar todos os livros que estão sem editora, seja porque não foi informado uma editora ao cadastrar o livro, 
--seja porque ele está vinculado a uma editora que não existe."
--R: A resolução deu-se pelos mesmos códigos do exercício 01 e 02.
a - select * From livros where codigoeditora = 150 //editora não existe)
b - select * From Livros Where codigoeditora is null //sem editora)

--4)Lista pra mim todos os empréstimos feitos para alunos que não possuem CPF informado em seu cadastro.
--Código:
select alunos.numeromatriculaaluno, alunos.cpf= null, emprestimo.codigoemprestimo
from emprestimo
inner join alunos
on alunos.numeromatriculaaluno = emprestimo.numeromatriculaaluno

--5)Liste pra mim todos os empréstimos de livros, com o nome do livro e o nome do aluno que pegou o livro emprestado.
--Código:
select alunos.numeromatriculaaluno, alunos.nome, emprestimo.codigoemprestimo, emprestimo.dataemprestimo
from emprestimo
inner join alunos
on alunos.numeromatriculaaluno = emprestimo.numeromatriculaaluno

--6)Liste pra mim a quantidade de alunos cadastrados por bairro, ordernando de modo decrescente por bairro.
--código:
select numeromatriculaaluno, nome, bairro from alunos
order by  bairro desc 

--7)Lista pra mim a quantidade de livros emprestados por bairro, considerando apenas os empréstimos feitos para alunos que tem cpf.
--código:
select alunos.numeromatriculaaluno, alunos.nome, alunos.bairro, emprestimo.codigoemprestimo, alunos.cpf
from emprestimo
inner join alunos
on alunos.numeromatriculaaluno = emprestimo.numeromatriculaaluno
where cpf is not null

--8)"Lista pra mim a quantidade de livros emprestados por bairro, considerando apenas os empréstimos feitos para alunos que tem cpf e 
--considerando apenas os empréstimos de livros que possuem autor informado.
--código:
select
	alunos.numeromatriculaaluno,
	alunos.nome,
	alunos.bairro,
	emprestimo.codigoemprestimo,
	alunos.cpf,
	livros.nomeautor,
	livros.codigolivro 
from
	emprestimo
inner join alunos 
	on alunos.numeromatriculaaluno = empréstimo.numeromatricula aluno
inner join livros 
	on livros.codigolivro = alunos.numeromatriculaaluno
	 where nomeautor is not null and cpf is not null;