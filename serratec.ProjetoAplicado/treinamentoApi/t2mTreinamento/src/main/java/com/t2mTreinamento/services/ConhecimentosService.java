package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.ConhecimentosDTO;
import com.t2mTreinamento.dtos.ConhecimentosNiveisDTO;
import com.t2mTreinamento.dtos.ConhecimentosTreinamentosDTO;
import com.t2mTreinamento.dtos.NiveisDTO;
import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.ConhecimentosRepository;

@Service
public class ConhecimentosService {

	@Autowired
	public ConhecimentosRepository conhecimentosRepository;

	public void converteConParaDTO(Conhecimentos con, ConhecimentosDTO conDTO) {

		conDTO.setIdConhecimentos(con.getIdConhecimentos());
		conDTO.setNome(con.getNome());
		conDTO.setDescricao(con.getDescricao());

		// NÍVEIS
		Set<ConhecimentosNiveisDTO> setConsNivsDTO = new HashSet<>();
		Set<ConhecimentosNiveis> setConsNivs = con.getSetConhecimentosNiveis();

		for (ConhecimentosNiveis conNiv : setConsNivs) {
			ConhecimentosNiveisDTO conNivDTO = new ConhecimentosNiveisDTO();

			if (conNiv.getIdConhecimentosNiveis().getIdConhecimento() == con.getIdConhecimentos()) {
				Niveis niv = conNiv.getNivel();
				NiveisDTO nivDTO = new NiveisDTO();

				nivDTO.setIdNiveis(niv.getIdNiveis());
				nivDTO.setNivel(niv.getNivel());

				conNivDTO.setNivel(nivDTO);

				setConsNivsDTO.add(conNivDTO);
			}
		}
		conDTO.setSetConsNivs(setConsNivsDTO);

		// TREINAMENTOS
		Set<ConhecimentosTreinamentosDTO> setConsTrnsDTO = new HashSet<>();
		Set<ConhecimentosTreinamentos> setConsTrns = con.getSetConhecimentosTreinamentos();

		for (ConhecimentosTreinamentos conTrn : setConsTrns) {
			ConhecimentosTreinamentosDTO conTrnDTO = new ConhecimentosTreinamentosDTO();

			if (conTrn.getIdConhecimentosTreinamentos().getIdConhecimento() == con.getIdConhecimentos()) {
				Treinamentos trn = conTrn.getTreinamento();
				TreinamentosDTO trnDTO = new TreinamentosDTO();

				trnDTO.setIdTreinamentos(trn.getIdTreinamentos());
				trnDTO.setCargaHoraria(trn.getCargaHoraria());
				trnDTO.setDescricao(trn.getDescricao());
				trnDTO.setInstituicao(trn.getInstituicao());
				trnDTO.setNome(trn.getNome());

				conTrnDTO.setTreinamento(trnDTO);

				setConsTrnsDTO.add(conTrnDTO);
			}
		}
		conDTO.setSetConsTrns(setConsTrnsDTO);
	}

	public Conhecimentos findById(Long id) {
		return conhecimentosRepository.findById(id).get();
	}

	public Conhecimentos findByIsAtivoAndIdConhecimentos(Long idConhecimentos) {
		return conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idConhecimentos);
	}

	public ConhecimentosDTO findByIsAtivoAndIdConhecimentosDTO(Long idConhecimentos) {
		Conhecimentos con = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idConhecimentos);
		ConhecimentosDTO conDTO = new ConhecimentosDTO();

		converteConParaDTO(con, conDTO);
		return conDTO;
	}

	public List<Conhecimentos> findAll() {
		return conhecimentosRepository.findAll();
	}

	public List<Conhecimentos> findByIsAtivo() {
		return conhecimentosRepository.findByIsAtivo(1);
	}

	public List<ConhecimentosDTO> findAllDTO() {
		List<ConhecimentosDTO> listCons = new ArrayList<>();
		for (Conhecimentos con : conhecimentosRepository.findByIsAtivo(1)) {
			ConhecimentosDTO conDTO = new ConhecimentosDTO();
			converteConParaDTO(con, conDTO);
			listCons.add(conDTO);
		}
		return listCons;
	}

	public Long Count() {
		return conhecimentosRepository.count();
	}

	public Conhecimentos save(Conhecimentos conhecimento) {
		conhecimento.setIsAtivo(1);
		Conhecimentos novoConhecimento = conhecimentosRepository.save(conhecimento);

		if (novoConhecimento != null) {
			return novoConhecimento;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && conhecimentosRepository.findById(id).get().getIsAtivo() == 1) {
			Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, id);
			conhecimento.setIsAtivo(0);
			conhecimentosRepository.save(conhecimento);

			return true;
		} else {
			return false;
		}
	}

	public Conhecimentos update(Conhecimentos conhecimento, Long id) {
		conhecimento.setIdConhecimentos(id);
		conhecimento.setIsAtivo(1);
		return conhecimentosRepository.save(conhecimento);
	}
}
