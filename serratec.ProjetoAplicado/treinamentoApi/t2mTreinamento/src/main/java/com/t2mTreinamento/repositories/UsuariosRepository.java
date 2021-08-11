package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	List<Usuarios> findByIsAtivo(Integer isAtivo);

	Usuarios findByIsAtivoAndIdUsuarios(Integer isAtivo, Long idUsuarios);

	Usuarios findByColaborador(Colaboradores colaborador);

	Usuarios findByUsuarioAndSenhaAndIsAtivo(String usuario, String senha, Integer isAtivo);

}
