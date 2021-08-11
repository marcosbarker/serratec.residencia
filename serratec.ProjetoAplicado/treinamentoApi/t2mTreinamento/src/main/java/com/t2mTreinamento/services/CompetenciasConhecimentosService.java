package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.entities.CompetenciasConhecimentosId;
import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.repositories.CompetenciasConhecimentosRepository;
import com.t2mTreinamento.repositories.CompetenciasRepository;
import com.t2mTreinamento.repositories.ConhecimentosRepository;

@Service
public class CompetenciasConhecimentosService {

	@Autowired
	public CompetenciasConhecimentosRepository compsConsRepository;

	@Autowired
	public CompetenciasRepository competenciasRepository;

	@Autowired
	public ConhecimentosRepository conhecimentosRepository;

	public List<CompetenciasConhecimentos> findByIdCompetencia(Long id) {
		Competencias competencia = competenciasRepository.findById(id).get();
		return compsConsRepository.findByCompetencia(competencia);
	}

	public List<CompetenciasConhecimentos> findByIdCompetenciaAtivo(Long id) {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
		return compsConsRepository.findByCompetenciaAndIsAtivo(competencia, 1);
	}

	public List<CompetenciasConhecimentos> findByIdConhecimento(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
		return compsConsRepository.findByConhecimento(conhecimento);
	}

	public List<CompetenciasConhecimentos> findByIdConhecimentoAtivo(Long id) {
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, id);
		return compsConsRepository.findByConhecimentoAndIsAtivo(conhecimento, 1);
	}

	public List<CompetenciasConhecimentos> findAll() {
		return compsConsRepository.findAll();
	}

	public Long Count() {
		return compsConsRepository.count();
	}

	public CompetenciasConhecimentos save(CompetenciasConhecimentos compCon, Long idComp, Long idCon) {
		Competencias competencia = competenciasRepository.findById(idComp).get();
		Conhecimentos conhecimento = conhecimentosRepository.findById(idCon).get();
		compCon.setCompetencia(competencia);
		compCon.setConhecimento(conhecimento);
		compCon.setIsAtivo(1);
		CompetenciasConhecimentos novoCompCon = compsConsRepository.save(compCon);

		if (novoCompCon != null) {
			return novoCompCon;
		} else {
			return null;
		}
	}

	public boolean deleteByCompetencia(Long id) {
		if (id != null) {
			Competencias competencia = competenciasRepository.findById(id).get();
			List<CompetenciasConhecimentos> listCompsCons = compsConsRepository.findByCompetencia(competencia);

			for (CompetenciasConhecimentos compCon : listCompsCons) {
				compCon.setIsAtivo(0);
				compsConsRepository.save(compCon);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByConhecimento(Long id) {
		if (id != null) {
			Conhecimentos conhecimento = conhecimentosRepository.findById(id).get();
			List<CompetenciasConhecimentos> listCompsCons = compsConsRepository.findByConhecimento(conhecimento);

			for (CompetenciasConhecimentos compCon : listCompsCons) {
				compCon.setIsAtivo(0);
				compsConsRepository.save(compCon);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(CompetenciasConhecimentos compCon, CompetenciasConhecimentos novoCompCon) {
		novoCompCon.setIsAtivo(compCon.getIsAtivo());
	}

	public CompetenciasConhecimentos update(CompetenciasConhecimentos compCon, Long idComp, Long idCon) {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);

		CompetenciasConhecimentos novoCompCon = new CompetenciasConhecimentos();

		novoCompCon.setCompetencia(competencia);
		novoCompCon.setConhecimento(conhecimento);
		novoCompCon.setIdCompetenciasConhecimentos(new CompetenciasConhecimentosId(idComp, idCon));

		updateDados(compCon, novoCompCon);

		return compsConsRepository.save(novoCompCon);
	}

	public Competencias insereConhecimentoEmCompetencia(Long idComp, Long idCon) throws Exception {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
		Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);

		CompetenciasConhecimentosId compsConsId = new CompetenciasConhecimentosId(idComp, idCon);

		CompetenciasConhecimentos compCon = new CompetenciasConhecimentos(compsConsId, competencia, conhecimento, 1);

		Set<CompetenciasConhecimentos> novoSetCompsCons = competencia.getSetCompetenciasConhecimentos();

		if (novoSetCompsCons.add(compCon)) {

			novoSetCompsCons.add(compCon);
			competencia.setSetCompetenciasConhecimentos(novoSetCompsCons);
			Competencias competenciaAtualizada = competenciasRepository.save(competencia);

			return competenciaAtualizada;
		} else {
			return null;
		}
	}

	public Competencias removeConhecimentoDeCompetencia(Long idComp, Long idCon) throws Exception {

		if (idComp != null && idCon != null) {
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
			Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idCon);

			CompetenciasConhecimentos compCon = compsConsRepository.findByCompetenciaAndConhecimento(competencia,
					conhecimento);

			competencia.getSetCompetenciasConhecimentos().remove(compCon);

			compsConsRepository.delete(compCon);

			return competencia;
		} else {
			return null;
		}
	}

}
