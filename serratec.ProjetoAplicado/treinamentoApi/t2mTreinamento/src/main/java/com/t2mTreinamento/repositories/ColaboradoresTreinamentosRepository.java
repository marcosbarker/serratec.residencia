package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresTreinamentos;
import com.t2mTreinamento.entities.ColaboradoresTreinamentosId;
import com.t2mTreinamento.entities.Treinamentos;

@Repository
public interface ColaboradoresTreinamentosRepository
		extends JpaRepository<ColaboradoresTreinamentos, ColaboradoresTreinamentosId> {

	List<ColaboradoresTreinamentos> findByColaborador(Colaboradores colaborador);

	List<ColaboradoresTreinamentos> findByColaboradorAndIsAtivo(Colaboradores colaborador, Integer isAtivo);

	List<ColaboradoresTreinamentos> findByTreinamento(Treinamentos treinamento);

	List<ColaboradoresTreinamentos> findByTreinamentoAndIsAtivo(Treinamentos treinamento, Integer isAtivo);

	ColaboradoresTreinamentos findByColaboradorAndTreinamento(Colaboradores colaborador, Treinamentos treinamento);

	ColaboradoresTreinamentos findByColaboradorAndTreinamentoAndIsAtivo(Colaboradores colaborador,
			Treinamentos treinamento, Integer isAtivo);
}
