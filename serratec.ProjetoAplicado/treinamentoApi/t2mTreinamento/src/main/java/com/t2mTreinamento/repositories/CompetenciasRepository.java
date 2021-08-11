package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Competencias;

@Repository
public interface CompetenciasRepository extends JpaRepository<Competencias, Long> {

	List<Competencias> findByIsAtivo(Integer isAtivo);

	Competencias findByIsAtivoAndIdCompetencias(Integer isAtivo, Long idCompetencias);

}
