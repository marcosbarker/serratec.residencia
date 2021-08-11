package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.PosicoesCompetenciasId;

@Repository
public interface PosicoesCompetenciasRepository extends JpaRepository<PosicoesCompetencias, PosicoesCompetenciasId> {

	List<PosicoesCompetencias> findByPosicao(Posicoes posicao);

	List<PosicoesCompetencias> findByPosicaoAndIsAtivo(Posicoes Posicoes, Integer isAtivo);

	List<PosicoesCompetencias> findByCompetencia(Competencias competencia);

	List<PosicoesCompetencias> findByCompetenciaAndIsAtivo(Competencias competencia, Integer isAtivo);

	PosicoesCompetencias findByPosicaoAndCompetencia(Posicoes posicao, Competencias competencia);

	PosicoesCompetencias findByPosicaoAndCompetenciaAndIsAtivo(Posicoes posicao, Competencias competencia,
			Integer isAtivo);

}
