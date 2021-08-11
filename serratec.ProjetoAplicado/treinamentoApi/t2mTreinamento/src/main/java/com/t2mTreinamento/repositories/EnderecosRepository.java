package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Enderecos;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {

	List<Enderecos> findByIsAtivo(Integer isAtivo);

	Enderecos findByIsAtivoAndIdEnderecos(Integer isAtivo, Long idEnderecos);
}
