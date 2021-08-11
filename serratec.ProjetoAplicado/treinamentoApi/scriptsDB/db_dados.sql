insert into posicoes(
	nome,
	descricao
)
values
('Dev Trainee',	'Estagiario'),
('Dev Junior', 'Desenvolvedor inciante'),
('Dev Pleno', 'Desenvolvedor com autonomia para desenvolvimento de software'),
('Dev Senior', 'Desenvolvedor lider de software ');

insert into colaboradores (
	nome,
	data_nascimento,
	email,
	conta_bancaria,
	pix,
	cpf,
	rg,
	cnh,
	islider,
	id_posicao
) values
('Eloá Bruna Lúcia Nunes', '1949-07-09', 'eloa.nunes@email.com', 11111, 'eloa.nunes@email.com', '793.077.779-00', '30.603.488-8', 'B', 1, 4),
('Hugo Pedro Henrique Bernardo Martins', '1948-01-25', 'hugo.martins@email.com', 22222, 'hugo.martins@email.com', '728.512.147-99','19.393.303-2', 'B', 1, 4),
('Melissa Fátima Isabella Vieira', '1959-11-12', 'melissa.vieira@email.com', 33333, '806.492.510-08', '806.492.510-08', '12.226.154-9', 'B', 0, 3),
('Kaique Raul Oliveira', '1997-05-02', 'kaique.oliveira@email.com', 44444, '958.621.186-08', '958.621.186-08', '38.322.163-8', '', 0, 2),
('Sérgio Márcio Castro', '1995-07-02', 'sergio.castro@email.com', 55555, '402.991.554-04', '402.991.554-04', '27.057.408-6', 'A', 0, 3);


insert into enderecos (
	cep,
	rua,
	numero,
	complemento,
	bairro,
	cidade,
	estado,
	pais
) values
('13872-034', 'Rua Capitão José Gomes Guimarães', '111', '', 'Jardim Primeiro de Maio', 'São João da Boa Vista', 'SP', 'Brasil'),
('49044-502', 'Rua A8', '489', '', 'Santa Maria', 'Aracaju', 'SE', 'Brasil'),
('29114-685', 'Beco Mirandópolis', '804', '', 'Argolas', 'Vila Velha', 'ES', 'Brasil'),
('68906-842', 'Alameda Araguary', '254', '', 'Cabralzinho', 'Macapá', 'AP', 'Brasil' ),
('96825-363', 'Antônia da Silva Martins', '316', '', 'Belvedere', 'Santa Cruz do Sul', 'RS', 'Brasil');


insert into colaboradores_enderecos (
	id_colaborador,
	id_endereco
) values (1,1), (2,2), (3,3), (4,4), (5,5);

insert into usuarios (
	id_colaborador,
	usuario,
	senha,
	isadmin
) values
(1, 'eloa.nunes', '1111', 1),
(2, 'hugo.martins', '2222', 0),
(3, 'melissa.vieira', '3333', 0),
(4, 'kaique.oliveira', '4444', 0),
(5, 'sergio.castro', '5555', 0);


insert into projetos (
	nome,
	descricao,
	app_gerenciamento,
	segmento,
	equipe,
	data_entrega_esperada,
	data_entrega
) values
('Projeto 1', 'Primeiro projeto', 'Trello', 'Desenvolvimento Mobile', 4, '2021-10-11', null),
('Projeto 2', 'Segundo projeto', '', 'Desenvolvimento Web', 2, '2021-11-23', null),
('Projeto 3', 'Terceiro projeto', 'Notion', 'Desenvolvimento Mobile', 3, '2022-02-04', null);


insert into colaboradores_projetos (
	id_colaborador,
	id_projeto,
	funcao,
	data_inicio,
	data_saida
) values
(1, 1, 'Gerente do projeto', '2021-03-10', null),
(2, 2, 'Gerente do projeto', '2021-04-25', null),
(3, 3, 'Gerente do projeto', '2021-04-27', null),
(4, 2, 'Desenvolvedor mobile', '2021-04-30', '2021-08-26'),
(5, 3, 'Desenvolvedor back-end', '2021-04-28', null);

insert into formacoes (
	nome,
	nivel,
	instituicao
) values
('Sistemas da Informação', 'Superior Completo', 'UFRJ'),
('Ciência da Computação', 'Superior Completo', 'UFF'),
('Engenharia Elétrica', 'Superior Completo', 'UCP'),
('Engenharia de Computação', 'Superior Incompleto', 'UCP'),
('Engenharia de Software', 'Superior Completo', 'Estácio');

insert into colaboradores_formacoes (
	id_colaborador,
	id_formacao,
	data_entrada,
	data_conclusao
) values
(1, 1, '1994-02-08', '1999-12-16'),
(2, 2, '2011-02-01', '2016-12-11'),
(3, 3, '2009-02-03', '2014-12-12'),
(4, 4, '2018-03-05', null),
(5, 5, '2010-02-02', '2015-12-10');

insert into niveis (nivel) values
('Básico'),
('Intermediário'),
('Avançado'),
(null);

insert into competencias (
	nome,
	descricao
) values
('Framework', 'ReactJS, React Native...'),
('Banco de dados', 'PostgreSQL, DBeaver...'),
('Linguagens', 'Java, C#, JavaScript...'),
('Soft Skills', 'Proatividade, liderança...'),
('Treinamentos', 'SCRUM, Agile...');

insert into competencias_niveis  (
	id_competencia,
	id_nivel
) values
(1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,1),(4,2),(4,3),(4,4),(5,4);

insert into conhecimentos (
	nome,
	descricao
) values
('ReactJS', 'Aplicação de Hooks, componentização, responsividade, uso de Router DOM...'),
('PostgreSQL', 'Criação de tabelas, normalização, mapeamento, elaboração de diagramas ER, tratamento de dados...'),
('Java', 'Criação de API Restful, POO...'),
('Proatividade', 'Capacidade de trabalhar ativamente em grupo ou isolado sem demanda de tarefas por terceiros...'),
('SCRUM', 'Conhecimento da ideologia, denominações, método de execução...');


insert into conhecimentos_niveis (
	id_conhecimento,
	id_nivel
) values
(1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,4),(5,4);

insert into competencias_conhecimentos (
	id_competencia,
	id_conhecimento
) values
(1,1),(2,2),(3,3),(4,4),(5,5);


insert into posicoes_competencias (
	id_posicao,
	id_competencia
) values
(1,3),(1,2),(2,1),(2,2),(2,3),(2,4),(2,5),(3,1),(3,2),(3,3),(3,4),(3,5),(4,1),(4,2),(4,3),(4,4),(4,5);

insert into treinamentos (
	nome,
	instituicao,
	carga_horaria,
	descricao
) values
('React - The Complete Guide (incl Hooks, React Router, Redux)', 'Udemy Academy', 48, 'Curso sobre ReactJS'),
('PostgreSQL High Performance Tuning Guide', 'Udemy Academy', 2, 'Curso sobre PostgreSQL'),
('Java 2021 COMPLETO: Do Zero ao Profissional + Projetos!','Udemy Academy', 77, 'Curso sobre Java'),
('Soft Skills: The 11 Essential Career Soft Skills', 'Udemy Academy', 31, 'Curso sobre soft skills'),
('SCRUM Fundamentals', 't2m', 6, 'Curso sobre fundamentos de SCRUM');

insert into certificacoes (
	tempo_validade,
	id_treinamento
) values
(0, 1),(0, 2),(0, 3),(0, 4),(2, 5);

insert into colaboradores_certificacoes (
	id_colaborador,
	id_certificacao,
	data_obtencao
) values
(1, 6, '2015-07-20'), (1, 2, '2021-07-20'), (1, 3, '2021-07-20'), (1, 4, '2021-07-20'), (1, 5, '2021-07-20'),
(2, 6, '2015-04-13'), (2, 2, '2021-04-13'), (2, 3, '2021-04-13'), (2, 4, '2021-04-13'), (2, 5, '2021-04-13'),
(3, 6, '2018-02-17'), (3, 2, '2018-02-17'), (3, 3, '2018-02-17'), (3, 4, '2018-02-17'), (3, 5, '2018-02-17'),
(4, 6, '2019-08-14'), (4, 2, '2019-08-14'), (4, 3, '2019-08-14'), (4, 4, '2019-08-14'), (4, 5, '2019-08-14');

insert into colaboradores_treinamentos (
	id_colaborador,
	id_treinamento,
	status
) values
(1,1,'Concluído'),(1,2,'Concluído'),(1,3,'Concluído'),(1,4,'Concluído'),(1,5,'Concluído'),
(2,1,'Concluído'),(2,2,'Concluído'),(2,3,'Concluído'),(2,4,'Concluído'),(2,5,'Concluído'),
(3,1,'Concluído'),(3,2,'Concluído'),(3,3,'Concluído'),(3,4,'Concluído'),(3,5,'Concluído'),
(4,1,'Concluído'),(4,2,'Concluído'),(4,3,'Concluído'),(4,4,'Concluído'),(4,5,'Concluído'),
(5,1,'Em andamento'),(5,2,'Em andamento'),(5,3,'Em andamento'),(5,4,'Em andamento'),(5,5,'Em andamento');


insert into conhecimentos_treinamentos (
	id_conhecimento,
	id_treinamento
) values
(1,1),(2,2),(3,3),(4,4),(5,5);









