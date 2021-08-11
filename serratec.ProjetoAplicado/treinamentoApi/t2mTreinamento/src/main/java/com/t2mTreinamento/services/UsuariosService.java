package com.t2mTreinamento.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.Usuarios;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	public UsuariosRepository usuariosRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	public Usuarios findById(Long id) {
		return usuariosRepository.findById(id).get();
	}

	public Usuarios findByIsAtivoAndIdUsuarios(Long idUsuarios) {
		return usuariosRepository.findByIsAtivoAndIdUsuarios(1, idUsuarios);
	}

	public List<Usuarios> findAll() {
		return usuariosRepository.findAll();
	}

	public List<Usuarios> findByIsAtivo() {
		return usuariosRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return usuariosRepository.count();
	}

	public Usuarios criaNovoUsuario(Colaboradores colaborador) {

		String nomeUsuario = colaborador.getNome().substring(0, colaborador.getNome().indexOf(" ")).toLowerCase() + "."
				+ colaborador.getDataNascimento().get(Calendar.DAY_OF_MONTH);

		String senha = colaborador.getDataNascimento().get(Calendar.YEAR) + "/"
				+ colaborador.getDataNascimento().get(Calendar.MONTH);

		if (colaborador.getPermissao() == 1) {

			Usuarios novoUsuario = new Usuarios(nomeUsuario, senha, 0, 1, colaborador);

			return novoUsuario;

		} else if (colaborador.getPermissao() == 2) {

			Usuarios novoUsuario = new Usuarios(nomeUsuario, senha, 1, 1, colaborador);

			return novoUsuario;

		} else {
			return null;
		}

	}

	public Usuarios save(Usuarios novoUsuario) {

		Usuarios usuario = usuariosRepository.save(novoUsuario);

		if (usuario != null) {
			return usuario;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && usuariosRepository.findById(id).get().getIsAtivo() == 1) {
			Usuarios usuario = usuariosRepository.findByIsAtivoAndIdUsuarios(1, id);
			usuario.setIsAtivo(0);
			usuariosRepository.save(usuario);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();

			if (colaborador.getUsuario() != null) {
				Usuarios usuario = usuariosRepository.findByColaborador(colaborador);

				usuario.setIsAtivo(0);
				usuariosRepository.save(usuario);
			}

			return true;
		} else {
			return false;
		}
	}

	public Usuarios update(Usuarios usuario, Long id) {
		usuario.setIdUsuarios(id);
		usuario.setIsAtivo(1);
		return usuariosRepository.save(usuario);
	}

	public Usuarios insereColaborador(Long idUsuario, Long idColab) {
		Usuarios usuario = usuariosRepository.findByIsAtivoAndIdUsuarios(1, idUsuario);
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);

		if ((colaborador.getPermissao() == 1 && usuario.getIsAdmin() == 0)
				|| (colaborador.getPermissao() == 2 && usuario.getIsAdmin() == 1)) {
			usuario.setColaborador(colaborador);

			Usuarios usuarioAtualizado = usuariosRepository.save(usuario);

			if (usuarioAtualizado != null) {
				return usuarioAtualizado;
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Usuarios verificaLogin(String nomeUsuario, String senha) {
		Usuarios usuarioVerificado = usuariosRepository.findByUsuarioAndSenhaAndIsAtivo(nomeUsuario, senha, 1);

		if (usuarioVerificado != null) {
			return usuarioVerificado;
		} else {
			return null;
		}
	}

}
