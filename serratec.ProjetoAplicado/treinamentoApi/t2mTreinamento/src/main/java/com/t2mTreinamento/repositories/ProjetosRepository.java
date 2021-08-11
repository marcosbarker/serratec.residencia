package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Projetos;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {

	List<Projetos> findByIsAtivo(Integer isAtivo);

	Projetos findByIsAtivoAndIdProjetos(Integer isAtivo, Long idProjetos);
}
