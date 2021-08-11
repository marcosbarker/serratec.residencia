package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosNiveisId;
import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.repositories.ConhecimentosNiveisRepository;
import com.t2mTreinamento.repositories.ConhecimentosRepository;
import com.t2mTreinamento.repositories.NiveisRepository;

@Service
public class ConhecimentosNiveisService {

	@Autowired
	public ConhecimentosNiveisRepository consNivsRepository;

	@Autowired
	public ConhecimentosRepository conhecimentosRepository;

	@Autowired
	public NiveisRepository niveisRepository;

	public List<ConhecimentosNiveis> findByIdConhecimento(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
		return consNivsRepository.findByConhecimento(conhecimento);
	}

	public List<ConhecimentosNiveis> findByIdConhecimentoAtivo(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, id);
		return consNivsRepository.findByConhecimentoAndIsAtivo(conhecimento, 1);
	}

	public List<ConhecimentosNiveis> findByIdNivel(Long id) {
		Niveis nivel = niveisRepository.findById(id).get();
		return consNivsRepository.findByNivel(nivel);
	}

	public List<ConhecimentosNiveis> findByIdNivelAtivo(Long id) {
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, id);
		return consNivsRepository.findByNivelAndIsAtivo(nivel, 1);
	}

	public List<ConhecimentosNiveis> findAll() {
		return consNivsRepository.findAll();
	}

	public Long Count() {
		return consNivsRepository.count();
	}

	public ConhecimentosNiveis save(ConhecimentosNiveis conNiv, Long idCon, Long idNiv) {
		Conhecimentos conhecimento = conhecimentosRepository.findById(idCon).get();
		Niveis nivel = niveisRepository.findById(idNiv).get();
		conNiv.setConhecimento(conhecimento);
		conNiv.setNivel(nivel);
		conNiv.setIsAtivo(1);
		ConhecimentosNiveis novoConNiv = consNivsRepository.save(conNiv);

		if (novoConNiv != null) {
			return novoConNiv;
		} else {
			return null;
		}
	}

	public boolean deleteByConhecimento(Long id) {
		if (id != null) {
			Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
			List<ConhecimentosNiveis> listConsNivs = consNivsRepository.findByConhecimento(conhecimento);

			for (ConhecimentosNiveis conNiv : listConsNivs) {
				conNiv.setIsAtivo(0);
				consNivsRepository.save(conNiv);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByNivel(Long id) {
		if (id != null) {
			Niveis nivel = niveisRepository.findById(id).get();
			List<ConhecimentosNiveis> listConsNivs = consNivsRepository.findByNivel(nivel);

			for (ConhecimentosNiveis conNiv : listConsNivs) {
				conNiv.setIsAtivo(0);
				consNivsRepository.save(conNiv);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ConhecimentosNiveis conNiv, ConhecimentosNiveis novoConNiv) {
		novoConNiv.setIsAtivo(conNiv.getIsAtivo());
	}

	public ConhecimentosNiveis update(ConhecimentosNiveis conNiv, Long idCon, Long idNiv) {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

		ConhecimentosNiveis novoConNiv = new ConhecimentosNiveis();

		novoConNiv.setConhecimento(conhecimento);
		novoConNiv.setNivel(nivel);
		novoConNiv.setIdConhecimentosNiveis(new ConhecimentosNiveisId(idCon, idNiv));

		updateDados(conNiv, novoConNiv);

		return consNivsRepository.save(novoConNiv);
	}

	public Conhecimentos insereNivelEmConhecimento(Long idCon, Long idNiv) throws Exception {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

		ConhecimentosNiveisId consNivsId = new ConhecimentosNiveisId(idCon, idNiv);

		ConhecimentosNiveis conNiv = new ConhecimentosNiveis(consNivsId, conhecimento, nivel, 1);

		Set<ConhecimentosNiveis> novoSetConsNivs = conhecimento.getSetConhecimentosNiveis();

		if (novoSetConsNivs.add(conNiv)) {

			novoSetConsNivs.add(conNiv);
			conhecimento.setSetConhecimentosNiveis(novoSetConsNivs);
			Conhecimentos conhecimentoAtualizado = conhecimentosRepository.save(conhecimento);

			return conhecimentoAtualizado;
		} else {
			return null;
		}
	}

	public Conhecimentos removeNivelDeConhecimento(Long idCon, Long idNiv) throws Exception {

		if (idCon != null && idNiv != null) {
			Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
			Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

			ConhecimentosNiveis conNiv = consNivsRepository.findByConhecimentoAndNivel(conhecimento, nivel);

			conhecimento.getSetConhecimentosNiveis().remove(conNiv);

			consNivsRepository.delete(conNiv);

			return conhecimento;
		} else {
			return null;
		}
	}
}
