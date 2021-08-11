package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.ConhecimentosTreinamentosId;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.ConhecimentosRepository;
import com.t2mTreinamento.repositories.ConhecimentosTreinamentosRepository;
import com.t2mTreinamento.repositories.TreinamentosRepository;

@Service
public class ConhecimentosTreinamentosService {

	@Autowired
	public ConhecimentosTreinamentosRepository consTrnsRepository;

	@Autowired
	public ConhecimentosRepository conhecimentosRepository;

	@Autowired
	public TreinamentosRepository treinamentosRepository;

	public List<ConhecimentosTreinamentos> findByIdConhecimento(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
		return consTrnsRepository.findByConhecimento(conhecimento);
	}

	public List<ConhecimentosTreinamentos> findByIdConhecimentoAtivo(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, id);
		return consTrnsRepository.findByConhecimentoAndIsAtivo(conhecimento, 1);
	}

	public List<ConhecimentosTreinamentos> findByIdTreinamento(Long id) {
		Treinamentos treinamento = treinamentosRepository.findById(id).get();
		return consTrnsRepository.findByTreinamento(treinamento);
	}

	public List<ConhecimentosTreinamentos> findByIdTreinamentoAtivo(Long id) {
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, id);
		return consTrnsRepository.findByTreinamentoAndIsAtivo(treinamento, 1);
	}

	public List<ConhecimentosTreinamentos> findAll() {
		return consTrnsRepository.findAll();
	}

	public Long Count() {
		return consTrnsRepository.count();
	}

	public ConhecimentosTreinamentos save(ConhecimentosTreinamentos conTrn, Long idCon, Long idTrn) {
		Conhecimentos conhecimento = conhecimentosRepository.findById(idCon).get();
		Treinamentos treinamento = treinamentosRepository.findById(idTrn).get();
		conTrn.setConhecimento(conhecimento);
		conTrn.setTreinamento(treinamento);
		conTrn.setIsAtivo(1);
		ConhecimentosTreinamentos novoConTrn = consTrnsRepository.save(conTrn);

		if (novoConTrn != null) {
			return novoConTrn;
		} else {
			return null;
		}
	}

	public boolean deleteByConhecimento(Long id) {
		if (id != null) {
			Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
			List<ConhecimentosTreinamentos> listConsTrns = consTrnsRepository.findByConhecimento(conhecimento);

			for (ConhecimentosTreinamentos conTrn : listConsTrns) {
				conTrn.setIsAtivo(0);
				consTrnsRepository.save(conTrn);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByTreinamento(Long id) {
		if (id != null) {
			Treinamentos treinamento = treinamentosRepository.findById(id).get();
			List<ConhecimentosTreinamentos> listConsTrns = consTrnsRepository.findByTreinamento(treinamento);

			for (ConhecimentosTreinamentos conTrn : listConsTrns) {
				conTrn.setIsAtivo(0);
				consTrnsRepository.save(conTrn);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ConhecimentosTreinamentos conTrn, ConhecimentosTreinamentos novoConTrn) {
		novoConTrn.setIsAtivo(conTrn.getIsAtivo());
	}

	public ConhecimentosTreinamentos update(ConhecimentosTreinamentos conTrn, Long idCon, Long idTrn) {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

		ConhecimentosTreinamentos novoConTrn = new ConhecimentosTreinamentos();

		novoConTrn.setConhecimento(conhecimento);
		novoConTrn.setTreinamento(treinamento);
		novoConTrn.setIdConhecimentosTreinamentos(new ConhecimentosTreinamentosId(idCon, idTrn));

		updateDados(conTrn, novoConTrn);

		return consTrnsRepository.save(novoConTrn);
	}

	public Conhecimentos insereTreinamentoEmConhecimento(Long idCon, Long idTrn) throws Exception {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

		ConhecimentosTreinamentosId consTrnsId = new ConhecimentosTreinamentosId(idCon, idTrn);

		ConhecimentosTreinamentos conTrn = new ConhecimentosTreinamentos(consTrnsId, conhecimento, treinamento, 1);

		Set<ConhecimentosTreinamentos> novoSetConsTrns = conhecimento.getSetConhecimentosTreinamentos();

		if (novoSetConsTrns.add(conTrn)) {

			novoSetConsTrns.add(conTrn);
			conhecimento.setSetConhecimentosTreinamentos(novoSetConsTrns);
			Conhecimentos conhecimentoAtualizado = conhecimentosRepository.save(conhecimento);

			return conhecimentoAtualizado;
		} else {
			return null;
		}
	}

	public Conhecimentos removeTreinamentoDeConhecimento(Long idCon, Long idTrn) throws Exception {

		if (idCon != null && idTrn != null) {
			Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);
			Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

			ConhecimentosTreinamentos conTrn = consTrnsRepository.findByConhecimentoAndTreinamento(conhecimento,
					treinamento);

			conhecimento.getSetConhecimentosTreinamentos().remove(conTrn);

			consTrnsRepository.delete(conTrn);

			return conhecimento;
		} else {
			return null;
		}
	}
}
