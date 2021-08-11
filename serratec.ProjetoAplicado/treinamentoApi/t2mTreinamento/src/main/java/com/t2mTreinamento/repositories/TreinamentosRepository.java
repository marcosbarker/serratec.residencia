package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Treinamentos;

@Repository
public interface TreinamentosRepository extends JpaRepository<Treinamentos, Long> {

	List<Treinamentos> findByIsAtivo(Integer isAtivo);

	Treinamentos findByIsAtivoAndIdTreinamentos(Integer isAtivo, Long idTreinamentos);
}
