package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.ColaboradoresProjetosId;
import com.t2mTreinamento.entities.Projetos;

@Repository
public interface ColaboradoresProjetosRepository extends JpaRepository<ColaboradoresProjetos, ColaboradoresProjetosId> {

	List<ColaboradoresProjetos> findByColaborador(Colaboradores colaborador);

	List<ColaboradoresProjetos> findByColaboradorAndIsAtivo(Colaboradores colaborador, Integer isAtivo);

	List<ColaboradoresProjetos> findByProjeto(Projetos projeto);

	List<ColaboradoresProjetos> findByProjetoAndIsAtivo(Projetos projeto, Integer isAtivo);

	ColaboradoresProjetos findByColaboradorAndProjeto(Colaboradores colaborador, Projetos projeto);

	ColaboradoresProjetos findByColaboradorAndProjetoAndIsAtivo(Colaboradores colaborador, Projetos projeto,
			Integer isAtivo);

}
