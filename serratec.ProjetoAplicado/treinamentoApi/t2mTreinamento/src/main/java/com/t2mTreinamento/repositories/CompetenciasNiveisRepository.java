package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.entities.CompetenciasNiveisId;
import com.t2mTreinamento.entities.Niveis;

@Repository
public interface CompetenciasNiveisRepository extends JpaRepository<CompetenciasNiveis, CompetenciasNiveisId> {

	List<CompetenciasNiveis> findByCompetencia(Competencias competencia);

	List<CompetenciasNiveis> findByCompetenciaAndIsAtivo(Competencias competencia, Integer isAtivo);

	List<CompetenciasNiveis> findByNivel(Niveis nivel);

	List<CompetenciasNiveis> findByNivelAndIsAtivo(Niveis nivel, Integer isAtivo);

	CompetenciasNiveis findByCompetenciaAndNivel(Competencias competencia, Niveis nivel);

	CompetenciasNiveis findByCompetenciaAndNivelAndIsAtivo(Competencias competencia, Niveis nivel, Integer isAtivo);
}
