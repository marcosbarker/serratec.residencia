package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.FormacoesDTO;
import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.repositories.FormacoesRepository;

@Service
public class FormacoesService {

	@Autowired
	public FormacoesRepository formacoesRepository;

	public void converteFormParaDTO(Formacoes form, FormacoesDTO formDTO) {

		formDTO.setIdFormacoes(form.getIdFormacoes());
		formDTO.setInstituicao(form.getInstituicao());
		formDTO.setNivel(form.getNivel());
		formDTO.setNome(form.getNome());
	}

	public Formacoes findById(Long id) {
		return formacoesRepository.findById(id).get();
	}

	public Formacoes findByIsAtivoAndIdFormacoes(Long idFormacoes) {
		return formacoesRepository.findByIsAtivoAndIdFormacoes(1, idFormacoes);
	}

	public FormacoesDTO findByIsAtivoAndIdFormacoesDTO(Long idFormacoes) {
		Formacoes form = formacoesRepository.findByIsAtivoAndIdFormacoes(1, idFormacoes);
		FormacoesDTO formDTO = new FormacoesDTO();
		converteFormParaDTO(form, formDTO);
		return formDTO;
	}

	public List<Formacoes> findAll() {
		return formacoesRepository.findAll();
	}

	public List<Formacoes> findByIsAtivo() {
		return formacoesRepository.findByIsAtivo(1);
	}

	public List<FormacoesDTO> findAllDTO() {
		List<FormacoesDTO> listForms = new ArrayList<>();
		for (Formacoes form : formacoesRepository.findByIsAtivo(1)) {
			FormacoesDTO formDTO = new FormacoesDTO();
			converteFormParaDTO(form, formDTO);
			listForms.add(formDTO);
		}
		return listForms;
	}

	public Long Count() {
		return formacoesRepository.count();
	}

	public Formacoes save(Formacoes formacao) {
		formacao.setIsAtivo(1);
		Formacoes novaFormacao = formacoesRepository.save(formacao);

		if (novaFormacao != null) {
			return novaFormacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			Formacoes formacao = formacoesRepository.findById(id).get();
			formacao.setIsAtivo(0);
			formacoesRepository.save(formacao);
			return true;
		} else {
			return false;
		}
	}

	public Formacoes update(Formacoes formacao, Long id) {
		formacao.setIdFormacoes(id);
		formacao.setIsAtivo(1);
		return formacoesRepository.save(formacao);
	}
}
