package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresCertificacoes;
import com.t2mTreinamento.entities.ColaboradoresCertificacoesId;

@Repository
public interface ColaboradoresCertificacoesRepository
		extends JpaRepository<ColaboradoresCertificacoes, ColaboradoresCertificacoesId> {

	List<ColaboradoresCertificacoes> findByColaborador(Colaboradores colaborador);

	List<ColaboradoresCertificacoes> findByColaboradorAndIsAtivo(Colaboradores colaborador, Integer isAtivo);

	List<ColaboradoresCertificacoes> findByCertificacao(Certificacoes certificacao);

	List<ColaboradoresCertificacoes> findByCertificacaoAndIsAtivo(Certificacoes certificacao, Integer isAtivo);

	ColaboradoresCertificacoes findByColaboradorAndCertificacao(Colaboradores colaborador, Certificacoes certificacao);

	ColaboradoresCertificacoes findByColaboradorAndCertificacaoAndIsAtivo(Colaboradores colaborador,
			Certificacoes certificacao, Integer isAtivo);

}
