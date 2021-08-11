package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.ConhecimentosTreinamentosId;
import com.t2mTreinamento.entities.Treinamentos;

@Repository
public interface ConhecimentosTreinamentosRepository
		extends JpaRepository<ConhecimentosTreinamentos, ConhecimentosTreinamentosId> {

	List<ConhecimentosTreinamentos> findByConhecimento(Conhecimentos conhecimento);

	List<ConhecimentosTreinamentos> findByConhecimentoAndIsAtivo(Conhecimentos conhecimento, Integer isAtivo);

	List<ConhecimentosTreinamentos> findByTreinamento(Treinamentos treinamento);

	List<ConhecimentosTreinamentos> findByTreinamentoAndIsAtivo(Treinamentos treinamento, Integer isAtivo);

	ConhecimentosTreinamentos findByConhecimentoAndTreinamento(Conhecimentos conhecimento, Treinamentos treinamento);

	ConhecimentosTreinamentos findByConhecimentoAndTreinamentoAndIsAtivo(Conhecimentos conhecimento,
			Treinamentos treinamento, Integer isAtivo);

}
