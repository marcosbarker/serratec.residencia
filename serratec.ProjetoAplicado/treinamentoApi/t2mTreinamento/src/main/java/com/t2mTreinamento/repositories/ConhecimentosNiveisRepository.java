package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosNiveisId;
import com.t2mTreinamento.entities.Niveis;

@Repository
public interface ConhecimentosNiveisRepository extends JpaRepository<ConhecimentosNiveis, ConhecimentosNiveisId> {

	List<ConhecimentosNiveis> findByConhecimento(Conhecimentos conhecimento);

	List<ConhecimentosNiveis> findByConhecimentoAndIsAtivo(Conhecimentos conhecimento, Integer isAtivo);

	List<ConhecimentosNiveis> findByNivel(Niveis nivel);

	List<ConhecimentosNiveis> findByNivelAndIsAtivo(Niveis nivel, Integer isAtivo);

	ConhecimentosNiveis findByConhecimentoAndNivel(Conhecimentos conhecimento, Niveis nivel);

	ConhecimentosNiveis findByConhecimentoAndNivelAndIsAtivo(Conhecimentos conhecimento, Niveis nivel, Integer isAtivo);

}
