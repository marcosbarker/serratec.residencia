package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.repositories.NiveisRepository;

@Service
public class NiveisService {

	@Autowired
	public NiveisRepository niveisRepository;

	public Niveis findById(Long id) {
		return niveisRepository.findById(id).get();
	}

	public Niveis findByIsAtivoAndIdNiveis(Long id) {
		return niveisRepository.findByIsAtivoAndIdNiveis(1, id);
	}

	public List<Niveis> findAll() {
		return niveisRepository.findAll();
	}

	public List<Niveis> findByIsAtivo() {
		return niveisRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return niveisRepository.count();
	}

	public Niveis save(Niveis nivel) {
		nivel.setIsAtivo(1);
		Niveis novoNivel = niveisRepository.save(nivel);
		if (novoNivel != null) {
			return novoNivel;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && niveisRepository.findById(id).get().getIsAtivo() == 1) {
			Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, id);
			nivel.setIsAtivo(0);
			niveisRepository.save(nivel);
			return true;
		} else {
			return false;
		}
	}

	public Niveis update(Niveis nivel, Long id) {
		nivel.setIdNiveis(id);
		nivel.setIsAtivo(1);
		return niveisRepository.save(nivel);
	}
}
