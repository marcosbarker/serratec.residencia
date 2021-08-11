package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.TreinamentosRepository;

@Service
public class TreinamentosService {

	@Autowired
	public TreinamentosRepository treinamentosRepository;

	public void converteTrnParaDTO(Treinamentos trn, TreinamentosDTO trnDTO) {
		trnDTO.setIdTreinamentos(trn.getIdTreinamentos());
		trnDTO.setCargaHoraria(trn.getCargaHoraria());
		trnDTO.setDescricao(trn.getDescricao());
		trnDTO.setInstituicao(trn.getInstituicao());
		trnDTO.setNome(trn.getNome());
	}

	public Treinamentos findById(Long id) {
		return treinamentosRepository.findById(id).get();
	}

	public Treinamentos findByIsAtivoAndIdTreinamentos(Long idTreinamentos) {
		return treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTreinamentos);
	}

	public TreinamentosDTO findByIsAtivoAndIdTreinamentosDTO(Long idTreinamentos) {
		Treinamentos trn = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTreinamentos);
		TreinamentosDTO trnDTO = new TreinamentosDTO();
		converteTrnParaDTO(trn, trnDTO);
		return trnDTO;
	}

	public List<Treinamentos> findAll() {
		return treinamentosRepository.findAll();
	}

	public List<Treinamentos> findByIsAtivo() {
		return treinamentosRepository.findByIsAtivo(1);
	}

	public List<TreinamentosDTO> findAllDTO() {
		List<TreinamentosDTO> listTrns = new ArrayList<>();
		for (Treinamentos trn : treinamentosRepository.findByIsAtivo(1)) {
			TreinamentosDTO trnDTO = new TreinamentosDTO();
			converteTrnParaDTO(trn, trnDTO);
			listTrns.add(trnDTO);
		}
		return listTrns;
	}

	public Long Count() {
		return treinamentosRepository.count();
	}

	public Treinamentos save(Treinamentos treinamento) {
		treinamento.setIsAtivo(1);
		Treinamentos novoTreinamento = treinamentosRepository.save(treinamento);
		if (novoTreinamento != null) {
			return novoTreinamento;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && treinamentosRepository.findById(id).get().getIsAtivo() == 1) {
			Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, id);
			treinamento.setIsAtivo(0);
			return true;
		} else {
			return false;
		}
	}

	public Treinamentos update(Treinamentos treinamento, Long id) {
		treinamento.setIdTreinamentos(id);
		treinamento.setIsAtivo(1);
		return treinamentosRepository.save(treinamento);
	}

}
