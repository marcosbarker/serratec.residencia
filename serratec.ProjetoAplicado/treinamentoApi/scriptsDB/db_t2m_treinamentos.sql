-- public.certificacoes definition

-- Drop table

-- DROP TABLE public.certificacoes;

CREATE TABLE public.certificacoes (
	id serial NOT NULL,
	tempo_validade numeric NOT NULL,
	id_treinamento int4 NULL,
	CONSTRAINT certificacoes_pkey PRIMARY KEY (id)
);


-- public.certificacoes foreign keys

ALTER TABLE public.certificacoes ADD CONSTRAINT certificacoes_id_treinamento_fkey FOREIGN KEY (id_treinamento) REFERENCES public.treinamentos(id);

-- public.colaboradores definition

-- Drop table

-- DROP TABLE public.colaboradores;

CREATE TABLE public.colaboradores (
	id serial NOT NULL,
	nome varchar(50) NOT NULL,
	data_nascimento date NULL,
	email varchar(30) NULL,
	conta_bancaria numeric NULL,
	pix varchar(40) NULL,
	cpf varchar(14) NOT NULL,
	rg varchar(12) NOT NULL,
	cnh varchar(1) NOT NULL,
	id_posicao int4 NULL,
	islider int4 NOT NULL,
	CONSTRAINT colaboradores_cpf_key UNIQUE (cpf),
	CONSTRAINT colaboradores_pix_key UNIQUE (pix),
	CONSTRAINT colaboradores_pkey PRIMARY KEY (id),
	CONSTRAINT colaboradores_rg_key UNIQUE (rg),
	CONSTRAINT islider CHECK (((islider = 0) OR (islider = 1)))
);


-- public.colaboradores foreign keys

ALTER TABLE public.colaboradores ADD CONSTRAINT colaboradores_id_posicao_fkey FOREIGN KEY (id_posicao) REFERENCES public.posicoes(id);

-- public.colaboradores_certificacoes definition

-- Drop table

-- DROP TABLE public.colaboradores_certificacoes;

CREATE TABLE public.colaboradores_certificacoes (
	id_colaborador int4 NULL,
	id_certificacao int4 NULL,
	data_obtencao date NOT NULL
);


-- public.colaboradores_certificacoes foreign keys

ALTER TABLE public.colaboradores_certificacoes ADD CONSTRAINT colaboradores_certificacoes_id_certificacao_fkey FOREIGN KEY (id_certificacao) REFERENCES public.certificacoes(id);
ALTER TABLE public.colaboradores_certificacoes ADD CONSTRAINT colaboradores_certificacoes_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);

-- public.colaboradores_enderecos definition

-- Drop table

-- DROP TABLE public.colaboradores_enderecos;

CREATE TABLE public.colaboradores_enderecos (
	id_colaborador int4 NULL,
	id_endereco int4 NULL
);


-- public.colaboradores_enderecos foreign keys

ALTER TABLE public.colaboradores_enderecos ADD CONSTRAINT colaboradores_enderecos_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);
ALTER TABLE public.colaboradores_enderecos ADD CONSTRAINT colaboradores_enderecos_id_endereco_fkey FOREIGN KEY (id_endereco) REFERENCES public.enderecos(id);

-- public.colaboradores_formacoes definition

-- Drop table

-- DROP TABLE public.colaboradores_formacoes;

CREATE TABLE public.colaboradores_formacoes (
	id_colaborador int4 NULL,
	id_formacao int4 NULL,
	data_entrada date NOT NULL,
	data_conclusao date NULL
);


-- public.colaboradores_formacoes foreign keys

ALTER TABLE public.colaboradores_formacoes ADD CONSTRAINT colaboradores_formacoes_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);
ALTER TABLE public.colaboradores_formacoes ADD CONSTRAINT colaboradores_formacoes_id_formacao_fkey FOREIGN KEY (id_formacao) REFERENCES public.formacoes(id);

-- public.colaboradores_projetos definition

-- Drop table

-- DROP TABLE public.colaboradores_projetos;

CREATE TABLE public.colaboradores_projetos (
	id_colaborador int4 NULL,
	id_projeto int4 NULL,
	funcao varchar(25) NOT NULL,
	data_inicio date NOT NULL,
	data_saida date NULL
);


-- public.colaboradores_projetos foreign keys

ALTER TABLE public.colaboradores_projetos ADD CONSTRAINT colaboradores_projetos_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);
ALTER TABLE public.colaboradores_projetos ADD CONSTRAINT colaboradores_projetos_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projetos(id);

-- public.colaboradores_treinamentos definition

-- Drop table

-- DROP TABLE public.colaboradores_treinamentos;

CREATE TABLE public.colaboradores_treinamentos (
	id_colaborador int4 NULL,
	id_treinamento int4 NULL,
	status varchar(20) NULL
);


-- public.colaboradores_treinamentos foreign keys

ALTER TABLE public.colaboradores_treinamentos ADD CONSTRAINT colaboradores_treinamentos_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);
ALTER TABLE public.colaboradores_treinamentos ADD CONSTRAINT colaboradores_treinamentos_id_treinamento_fkey FOREIGN KEY (id_treinamento) REFERENCES public.treinamentos(id);

-- public.competencias definition

-- Drop table

-- DROP TABLE public.competencias;

CREATE TABLE public.competencias (
	id serial NOT NULL,
	nome varchar(25) NOT NULL,
	descricao varchar(255) NULL,
	CONSTRAINT competencias_pkey PRIMARY KEY (id)
);

-- public.competencias_conhecimentos definition

-- Drop table

-- DROP TABLE public.competencias_conhecimentos;

CREATE TABLE public.competencias_conhecimentos (
	id_competencia int4 NULL,
	id_conhecimento int4 NULL
);


-- public.competencias_conhecimentos foreign keys

ALTER TABLE public.competencias_conhecimentos ADD CONSTRAINT competencias_conhecimentos_id_competencia_fkey FOREIGN KEY (id_competencia) REFERENCES public.competencias(id);
ALTER TABLE public.competencias_conhecimentos ADD CONSTRAINT competencias_conhecimentos_id_conhecimento_fkey FOREIGN KEY (id_conhecimento) REFERENCES public.conhecimentos(id);

-- public.competencias_niveis definition

-- Drop table

-- DROP TABLE public.competencias_niveis;

CREATE TABLE public.competencias_niveis (
	id_competencia int4 NULL,
	id_nivel int4 NULL
);


-- public.competencias_niveis foreign keys

ALTER TABLE public.competencias_niveis ADD CONSTRAINT competencias_niveis_id_competencia_fkey FOREIGN KEY (id_competencia) REFERENCES public.competencias(id);
ALTER TABLE public.competencias_niveis ADD CONSTRAINT competencias_niveis_id_nivel_fkey FOREIGN KEY (id_nivel) REFERENCES public.niveis(id);

-- public.conhecimentos definition

-- Drop table

-- DROP TABLE public.conhecimentos;

CREATE TABLE public.conhecimentos (
	id serial NOT NULL,
	nome varchar(25) NOT NULL,
	descricao varchar(255) NULL,
	nivel int4 NOT NULL,
	CONSTRAINT conhecimentos_pkey PRIMARY KEY (id)
);

-- public.conhecimentos_niveis definition

-- Drop table

-- DROP TABLE public.conhecimentos_niveis;

CREATE TABLE public.conhecimentos_niveis (
	id_conhecimento int4 NULL,
	id_nivel int4 NULL
);


-- public.conhecimentos_niveis foreign keys

ALTER TABLE public.conhecimentos_niveis ADD CONSTRAINT conhecimentos_niveis_id_conhecimento_fkey FOREIGN KEY (id_conhecimento) REFERENCES public.conhecimentos(id);
ALTER TABLE public.conhecimentos_niveis ADD CONSTRAINT conhecimentos_niveis_id_nivel_fkey FOREIGN KEY (id_nivel) REFERENCES public.niveis(id);

-- public.conhecimentos_treinamentos definition

-- Drop table

-- DROP TABLE public.conhecimentos_treinamentos;

CREATE TABLE public.conhecimentos_treinamentos (
	id_conhecimento int4 NULL,
	id_treinamento int4 NULL
);


-- public.conhecimentos_treinamentos foreign keys

ALTER TABLE public.conhecimentos_treinamentos ADD CONSTRAINT conhecimentos_treinamentos_id_conhecimento_fkey FOREIGN KEY (id_conhecimento) REFERENCES public.conhecimentos(id);
ALTER TABLE public.conhecimentos_treinamentos ADD CONSTRAINT conhecimentos_treinamentos_id_treinamento_fkey FOREIGN KEY (id_treinamento) REFERENCES public.treinamentos(id);

-- public.enderecos definition

-- Drop table

-- DROP TABLE public.enderecos;

CREATE TABLE public.enderecos (
	id serial NOT NULL,
	cep varchar(12) NOT NULL,
	rua varchar(100) NULL,
	numero varchar(10) NULL,
	complemento varchar(15) NULL,
	bairro varchar(50) NULL,
	cidade varchar(50) NULL,
	estado varchar(2) NULL,
	pais varchar(15) NULL,
	CONSTRAINT enderecos_pkey PRIMARY KEY (id)
);

-- public.formacoes definition

-- Drop table

-- DROP TABLE public.formacoes;

CREATE TABLE public.formacoes (
	id serial NOT NULL,
	nome varchar(50) NOT NULL,
	nivel varchar(50) NOT NULL,
	instituicao varchar(30) NOT NULL,
	CONSTRAINT formacoes_pkey PRIMARY KEY (id)
);

-- public.niveis definition

-- Drop table

-- DROP TABLE public.niveis;

CREATE TABLE public.niveis (
	id serial NOT NULL,
	nivel varchar(50) NULL,
	CONSTRAINT niveis_pkey PRIMARY KEY (id)
);

-- public.posicoes definition

-- Drop table

-- DROP TABLE public.posicoes;

CREATE TABLE public.posicoes (
	id serial NOT NULL,
	nome varchar(50) NOT NULL,
	descricao varchar(255) NULL,
	CONSTRAINT posicoes_pkey PRIMARY KEY (id)
);

-- public.posicoes_competencias definition

-- Drop table

-- DROP TABLE public.posicoes_competencias;

CREATE TABLE public.posicoes_competencias (
	id_posicao int4 NULL,
	id_competencia int4 NULL
);


-- public.posicoes_competencias foreign keys

ALTER TABLE public.posicoes_competencias ADD CONSTRAINT posicoes_competencias_id_competencia_fkey FOREIGN KEY (id_competencia) REFERENCES public.competencias(id);
ALTER TABLE public.posicoes_competencias ADD CONSTRAINT posicoes_competencias_id_posicao_fkey FOREIGN KEY (id_posicao) REFERENCES public.posicoes(id);

-- public.projetos definition

-- Drop table

-- DROP TABLE public.projetos;

CREATE TABLE public.projetos (
	id serial NOT NULL,
	nome varchar(25) NOT NULL,
	descricao varchar(255) NULL,
	app_gerenciamento varchar(255) NULL,
	segmento varchar(50) NULL,
	data_entrega_esperada date NOT NULL,
	data_entrega date NULL,
	equipe int4 NULL,
	CONSTRAINT projetos_pkey PRIMARY KEY (id)
);

-- public.treinamentos definition

-- Drop table

-- DROP TABLE public.treinamentos;

CREATE TABLE public.treinamentos (
	id serial NOT NULL,
	nome varchar(25) NOT NULL,
	instituicao varchar(25) NOT NULL,
	carga_horaria numeric NOT NULL,
	descricao varchar(255) NULL,
	CONSTRAINT treinamentos_pkey PRIMARY KEY (id)
);

-- public.usuarios definition

-- Drop table

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios (
	id serial NOT NULL,
	id_colaborador int4 NULL,
	usuario varchar(20) NOT NULL,
	senha varchar(8) NOT NULL,
	isadmin int4 NULL,
	CONSTRAINT isadmin CHECK (((isadmin = 0) OR (isadmin = 1))),
	CONSTRAINT usuarios_pkey PRIMARY KEY (id),
	CONSTRAINT usuarios_usuario_key UNIQUE (usuario)
);


-- public.usuarios foreign keys

ALTER TABLE public.usuarios ADD CONSTRAINT usuarios_id_colaborador_fkey FOREIGN KEY (id_colaborador) REFERENCES public.colaboradores(id);