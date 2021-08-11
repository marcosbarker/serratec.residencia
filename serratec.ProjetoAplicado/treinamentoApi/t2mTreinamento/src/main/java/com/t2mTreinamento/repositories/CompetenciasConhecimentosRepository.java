package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.entities.CompetenciasConhecimentosId;
import com.t2mTreinamento.entities.Conhecimentos;

@Repository
public interface CompetenciasConhecimentosRepository
		extends JpaRepository<CompetenciasConhecimentos, CompetenciasConhecimentosId> {

	List<CompetenciasConhecimentos> findByCompetencia(Competencias competencia);

	List<CompetenciasConhecimentos> findByCompetenciaAndIsAtivo(Competencias competencia, Integer isAtivo);

	List<CompetenciasConhecimentos> findByConhecimento(Conhecimentos conhecimento);

	List<CompetenciasConhecimentos> findByConhecimentoAndIsAtivo(Conhecimentos conhecimento, Integer isAtivo);

	CompetenciasConhecimentos findByCompetenciaAndConhecimento(Competencias competencia, Conhecimentos conhecimento);

	CompetenciasConhecimentos findByCompetenciaAndConhecimentoAndIsAtivo(Competencias competencia,
			Conhecimentos conhecimento, Integer isAtivo);
}
