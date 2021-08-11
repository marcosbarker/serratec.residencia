package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Formacoes;

@Repository
public interface FormacoesRepository extends JpaRepository<Formacoes, Long> {

	List<Formacoes> findByIsAtivo(Integer isAtivo);

	Formacoes findByIsAtivoAndIdFormacoes(Integer isAtivo, Long idFormacoes);
}
