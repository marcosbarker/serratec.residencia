package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresTreinamentos;
import com.t2mTreinamento.entities.ColaboradoresTreinamentosId;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.ColaboradoresTreinamentosRepository;
import com.t2mTreinamento.repositories.TreinamentosRepository;

@Service
public class ColaboradoresTreinamentosService {

	@Autowired
	public ColaboradoresTreinamentosRepository colabsTrnsRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public TreinamentosRepository treinamentosRepository;

	public List<ColaboradoresTreinamentos> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsTrnsRepository.findByColaborador(colaborador);
	}

	public List<ColaboradoresTreinamentos> findByIdColaboradorAtivo(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
		return colabsTrnsRepository.findByColaboradorAndIsAtivo(colaborador, 1);
	}

	public List<ColaboradoresTreinamentos> findByIdTreinamento(Long id) {
		Treinamentos treinamento = treinamentosRepository.findById(id).get();
		return colabsTrnsRepository.findByTreinamento(treinamento);
	}

	public List<ColaboradoresTreinamentos> findByIdTreinamentoAtivo(Long id) {
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, id);
		return colabsTrnsRepository.findByTreinamentoAndIsAtivo(treinamento, 1);
	}

	public List<ColaboradoresTreinamentos> findAll() {
		return colabsTrnsRepository.findAll();
	}

	public Long Count() {
		return colabsTrnsRepository.count();
	}

	public ColaboradoresTreinamentos save(ColaboradoresTreinamentos colabTrn, Long idColab, Long idTrn) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);
		colabTrn.setColaborador(colaborador);
		colabTrn.setTreinamento(treinamento);
		colabTrn.setIsAtivo(1);
		ColaboradoresTreinamentos novoColabTrn = colabsTrnsRepository.save(colabTrn);

		if (novoColabTrn != null) {
			return novoColabTrn;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresTreinamentos> listColabsTrns = colabsTrnsRepository.findByColaborador(colaborador);

			for (ColaboradoresTreinamentos colabTrn : listColabsTrns) {
				colabTrn.setIsAtivo(0);
				colabsTrnsRepository.save(colabTrn);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByTreinamento(Long id) {
		if (id != null) {
			Treinamentos treinamento = treinamentosRepository.findById(id).get();
			List<ColaboradoresTreinamentos> listColabsTrns = colabsTrnsRepository.findByTreinamento(treinamento);

			for (ColaboradoresTreinamentos colabTrn : listColabsTrns) {
				colabTrn.setIsAtivo(0);
				colabsTrnsRepository.save(colabTrn);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ColaboradoresTreinamentos colabTrn, ColaboradoresTreinamentos novoColabTrn) {
		novoColabTrn.setColaborador(colabTrn.getColaborador());
		novoColabTrn.setTreinamento(colabTrn.getTreinamento());
		novoColabTrn.setStatus(colabTrn.getStatus());
		novoColabTrn.setIsAtivo(1);
	}

	public ColaboradoresTreinamentos update(ColaboradoresTreinamentos colabTrn, Long idColab, Long idTrn) {

		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

		ColaboradoresTreinamentos novoColabTrn = new ColaboradoresTreinamentos();

		novoColabTrn.setColaborador(colaborador);
		novoColabTrn.setTreinamento(treinamento);
		novoColabTrn.setIdColaboradoresTreinamentos(new ColaboradoresTreinamentosId(idColab, idTrn));

		updateDados(colabTrn, novoColabTrn);

		return colabsTrnsRepository.save(novoColabTrn);
	}

	public Colaboradores insereTreinamentoEmColaborador(Long idColab, Long idTrn, String status) throws Exception {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

		ColaboradoresTreinamentosId colabsTrnsId = new ColaboradoresTreinamentosId(idColab, idTrn);

		ColaboradoresTreinamentos colabTrn = new ColaboradoresTreinamentos(colabsTrnsId, colaborador, treinamento,
				status, 1);

		Set<ColaboradoresTreinamentos> novoSetColabsTrns = colaborador.getSetColaboradoresTreinamentos();

		if (novoSetColabsTrns.add(colabTrn)) {

			novoSetColabsTrns.add(colabTrn);
			colaborador.setSetColaboradoresTreinamentos(novoSetColabsTrns);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

	public Colaboradores removeTreinamentoDeColaborador(Long idColab, Long idTrn) throws Exception {

		if (idColab != null && idTrn != null) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
			Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

			ColaboradoresTreinamentos colabTrn = colabsTrnsRepository.findByColaboradorAndTreinamento(colaborador,
					treinamento);

			colaborador.getSetColaboradoresTreinamentos().remove(colabTrn);

			colabsTrnsRepository.delete(colabTrn);

			return colaborador;
		} else {
			return null;
		}
	}
}
