package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.ProjetosDTO;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.repositories.ProjetosRepository;

@Service
public class ProjetosService {

	@Autowired
	public ProjetosRepository projetosRepository;

	public void converteProjParaDTO(Projetos proj, ProjetosDTO projDTO) {
		projDTO.setIdProjetos(proj.getIdProjetos());
		projDTO.setAppGerenciamento(proj.getAppGerenciamento());
		projDTO.setDataEntrega(proj.getDataEntrega());
		projDTO.setDataEntregaEsperada(proj.getDataEntregaEsperada());
		projDTO.setDescricao(proj.getDescricao());
		projDTO.setEquipe(proj.getEquipe());
		projDTO.setNome(proj.getNome());
		projDTO.setSegmento(proj.getSegmento());
	}

	public Projetos findById(Long id) {
		return projetosRepository.findById(id).get();
	}

	public Projetos findByIsAtivoAndIdProjetos(Long idProjetos) {
		return projetosRepository.findByIsAtivoAndIdProjetos(1, idProjetos);
	}

	public ProjetosDTO findByIsAtivoAndIdProjetosDTO(Long idProjetos) {
		Projetos proj = projetosRepository.findByIsAtivoAndIdProjetos(1, idProjetos);
		ProjetosDTO projDTO = new ProjetosDTO();
		converteProjParaDTO(proj, projDTO);
		return projDTO;
	}

	public List<Projetos> findAll() {
		return projetosRepository.findAll();
	}

	public List<Projetos> findByIsAtivo() {
		return projetosRepository.findByIsAtivo(1);
	}

	public List<ProjetosDTO> findAllDTO() {
		List<ProjetosDTO> listProjs = new ArrayList<>();
		for (Projetos proj : projetosRepository.findByIsAtivo(1)) {
			ProjetosDTO projDTO = new ProjetosDTO();
			converteProjParaDTO(proj, projDTO);
			listProjs.add(projDTO);
		}
		return listProjs;
	}

	public Long Count() {
		return projetosRepository.count();
	}

	public Projetos save(Projetos projeto) {
		projeto.setIsAtivo(1);
		Projetos novoProjeto = projetosRepository.save(projeto);
		if (novoProjeto != null) {
			return novoProjeto;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		// DELETAR DA LISTA DE REGISTROS ATIVOS
		if (id != null && projetosRepository.findById(id).get().getIsAtivo() == 1) {
			Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, id);
			projeto.setIsAtivo(0);
			projetosRepository.save(projeto);
			return true;
		} else {
			return false;
		}
	}

	public Projetos update(Projetos projeto, Long id) {
		projeto.setIdProjetos(id);
		projeto.setIsAtivo(1);
		return projetosRepository.save(projeto);
	}
}
