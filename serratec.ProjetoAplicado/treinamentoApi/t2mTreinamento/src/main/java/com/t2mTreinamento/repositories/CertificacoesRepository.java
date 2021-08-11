package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.entities.Treinamentos;

@Repository
public interface CertificacoesRepository extends JpaRepository<Certificacoes, Long> {

	List<Certificacoes> findByIsAtivo(Integer isAtivo);

	Certificacoes findByIsAtivoAndIdCertificacoes(Integer isAtivo, Long idCertificacoes);

	Certificacoes findByTreinamento(Treinamentos treinamento);

}
