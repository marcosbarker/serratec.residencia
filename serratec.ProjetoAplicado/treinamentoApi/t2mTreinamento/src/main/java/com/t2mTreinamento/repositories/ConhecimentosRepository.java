package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Conhecimentos;

@Repository
public interface ConhecimentosRepository extends JpaRepository<Conhecimentos, Long> {

	List<Conhecimentos> findByIsAtivo(Integer isAtivo);

	Conhecimentos findByIsAtivoAndIdConhecimentos(Integer isAtivo, Long idConhecimentos);

}
