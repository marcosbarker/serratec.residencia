package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.entities.CompetenciasNiveisId;
import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.repositories.CompetenciasNiveisRepository;
import com.t2mTreinamento.repositories.CompetenciasRepository;
import com.t2mTreinamento.repositories.NiveisRepository;

@Service
public class CompetenciasNiveisService {

	@Autowired
	public CompetenciasNiveisRepository compsNivsRepository;

	@Autowired
	public CompetenciasRepository competenciasRepository;

	@Autowired
	public NiveisRepository niveisRepository;

	public List<CompetenciasNiveis> findByIdCompetencia(Long id) {
		Competencias competencia = competenciasRepository.findById(id).get();
		return compsNivsRepository.findByCompetencia(competencia);
	}

	public List<CompetenciasNiveis> findByIdCompetenciaAtivo(Long id) {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
		return compsNivsRepository.findByCompetenciaAndIsAtivo(competencia, 1);
	}

	public List<CompetenciasNiveis> findByIdNivel(Long id) {
		Niveis nivel = niveisRepository.findById(id).get();
		return compsNivsRepository.findByNivel(nivel);
	}

	public List<CompetenciasNiveis> findByIdNivelAtivo(Long id) {
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, id);
		return compsNivsRepository.findByNivelAndIsAtivo(nivel, 1);
	}

	public List<CompetenciasNiveis> findAll() {
		return compsNivsRepository.findAll();
	}

	public Long Count() {
		return compsNivsRepository.count();
	}

	public CompetenciasNiveis save(CompetenciasNiveis compNiv, Long idComp, Long idNiv) {
		Competencias competencia = competenciasRepository.findById(idComp).get();
		Niveis nivel = niveisRepository.findById(idNiv).get();
		compNiv.setCompetencia(competencia);
		compNiv.setNivel(nivel);
		compNiv.setIsAtivo(1);
		CompetenciasNiveis novoCompNiv = compsNivsRepository.save(compNiv);

		if (novoCompNiv != null) {
			return novoCompNiv;
		} else {
			return null;
		}
	}

	public boolean deleteByCompetencia(Long id) {
		if (id != null) {
			Competencias competencia = competenciasRepository.findById(id).get();
			List<CompetenciasNiveis> listCompsNivs = compsNivsRepository.findByCompetencia(competencia);

			for (CompetenciasNiveis compNiv : listCompsNivs) {
				compNiv.setIsAtivo(0);
				compsNivsRepository.save(compNiv);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByNivel(Long id) {
		if (id != null) {
			Niveis nivel = niveisRepository.findById(id).get();
			List<CompetenciasNiveis> listCompsNivs = compsNivsRepository.findByNivel(nivel);

			for (CompetenciasNiveis compNiv : listCompsNivs) {
				compNiv.setIsAtivo(0);
				compsNivsRepository.save(compNiv);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(CompetenciasNiveis compNiv, CompetenciasNiveis novoCompNiv) {
		novoCompNiv.setIsAtivo(compNiv.getIsAtivo());
	}

	public CompetenciasNiveis update(CompetenciasNiveis compNiv, Long idComp, Long idNiv) {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

		CompetenciasNiveis novoCompNiv = new CompetenciasNiveis();

		novoCompNiv.setCompetencia(competencia);
		novoCompNiv.setNivel(nivel);
		novoCompNiv.setIdCompetenciasNiveis(new CompetenciasNiveisId(idComp, idNiv));

		updateDados(compNiv, novoCompNiv);

		return compsNivsRepository.save(novoCompNiv);
	}

	public Competencias insereNivelEmCompetencia(Long idComp, Long idNiv) throws Exception {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
		Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

		CompetenciasNiveisId compsNivsId = new CompetenciasNiveisId(idComp, idNiv);

		CompetenciasNiveis compNiv = new CompetenciasNiveis(compsNivsId, competencia, nivel, 1);

		Set<CompetenciasNiveis> novoSetCompsNivs = competencia.getSetCompetenciasNiveis();

		if (novoSetCompsNivs.add(compNiv)) {

			novoSetCompsNivs.add(compNiv);
			competencia.setSetCompetenciasNiveis(novoSetCompsNivs);
			Competencias competenciaAtualizada = competenciasRepository.save(competencia);

			return competenciaAtualizada;
		} else {
			return null;
		}
	}

	public Competencias removeNivelDeCompetencia(Long idComp, Long idNiv) throws Exception {

		if (idComp != null && idNiv != null) {
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);
			Niveis nivel = niveisRepository.findByIsAtivoAndIdNiveis(1, idNiv);

			CompetenciasNiveis compNiv = compsNivsRepository.findByCompetenciaAndNivel(competencia, nivel);

			competencia.getSetCompetenciasNiveis().remove(compNiv);

			compsNivsRepository.delete(compNiv);

			return competencia;
		} else {
			return null;
		}
	}

}
