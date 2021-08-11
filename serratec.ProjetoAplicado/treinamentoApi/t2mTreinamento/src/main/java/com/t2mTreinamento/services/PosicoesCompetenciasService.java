package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.PosicoesCompetenciasId;
import com.t2mTreinamento.repositories.CompetenciasRepository;
import com.t2mTreinamento.repositories.PosicoesCompetenciasRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class PosicoesCompetenciasService {

	@Autowired
	public PosicoesCompetenciasRepository posCompsRepository;

	@Autowired
	public PosicoesRepository posicoesRepository;

	@Autowired
	public CompetenciasRepository competenciasRepository;

	public List<PosicoesCompetencias> findByIdPosicao(Long id) {
		Posicoes posicao = posicoesRepository.findById(id).get();
		return posCompsRepository.findByPosicao(posicao);
	}

	public List<PosicoesCompetencias> findByIdPosicaoAtivo(Long id) {
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, id);
		return posCompsRepository.findByPosicaoAndIsAtivo(posicao, 1);
	}

	public List<PosicoesCompetencias> findByIdCompetencia(Long id) {
		Competencias competencia = competenciasRepository.findById(id).get();
		return posCompsRepository.findByCompetencia(competencia);
	}

	public List<PosicoesCompetencias> findByIdCompetenciaAtivo(Long id) {
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
		return posCompsRepository.findByCompetenciaAndIsAtivo(competencia, 1);
	}

	public List<PosicoesCompetencias> findAll() {
		return posCompsRepository.findAll();
	}

	public Long Count() {
		return posCompsRepository.count();
	}

	public PosicoesCompetencias save(PosicoesCompetencias posComp, Long idPos, Long idComp) {
		Posicoes posicao = posicoesRepository.findById(idPos).get();
		Competencias competencia = competenciasRepository.findById(idComp).get();
		posComp.setPosicao(posicao);
		posComp.setCompetencia(competencia);
		posComp.setIsAtivo(1);
		PosicoesCompetencias novoPosComp = posCompsRepository.save(posComp);

		if (novoPosComp != null) {
			return novoPosComp;
		} else {
			return null;
		}
	}

	public boolean deleteByPosicao(Long id) {
		if (id != null) {
			Posicoes posicao = posicoesRepository.findById(id).get();
			List<PosicoesCompetencias> listPosComps = posCompsRepository.findByPosicao(posicao);

			for (PosicoesCompetencias posComp : listPosComps) {
				posComp.setIsAtivo(0);
				posCompsRepository.save(posComp);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByCompetencia(Long id) {
		if (id != null) {
			Competencias competencia = competenciasRepository.findById(id).get();
			List<PosicoesCompetencias> listPosComps = posCompsRepository.findByCompetencia(competencia);

			for (PosicoesCompetencias posComp : listPosComps) {
				posComp.setIsAtivo(0);
				posCompsRepository.save(posComp);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(PosicoesCompetencias posComp, PosicoesCompetencias novoPosComp) {
		novoPosComp.setIsAtivo(posComp.getIsAtivo());
	}

	public PosicoesCompetencias update(PosicoesCompetencias posComp, Long idPos, Long idComp) {
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

		PosicoesCompetencias novoPosComp = new PosicoesCompetencias();

		novoPosComp.setPosicao(posicao);
		novoPosComp.setCompetencia(competencia);
		novoPosComp.setIdPosicoesCompetencias(new PosicoesCompetenciasId(idPos, idComp));

		updateDados(posComp, novoPosComp);

		return posCompsRepository.save(novoPosComp);
	}

	public Posicoes insereCompetenciaEmPosicao(Long idPos, Long idComp) {
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

		PosicoesCompetenciasId posCompsId = new PosicoesCompetenciasId(idPos, idComp);

		PosicoesCompetencias posComp = new PosicoesCompetencias(posCompsId, posicao, competencia, 1);

		Set<PosicoesCompetencias> novoSetPosComps = posicao.getSetPosicoesCompetencias();

		if (novoSetPosComps.add(posComp)) {

			novoSetPosComps.add(posComp);
			posicao.setSetPosicoesCompetencias(novoSetPosComps);
			Posicoes posicaoAtualizada = posicoesRepository.save(posicao);

			return posicaoAtualizada;
		} else {
			return null;
		}
	}

	public Posicoes removeCompetenciaDePosicao(Long idPos, Long idComp) {

		if (idPos != null && idComp != null) {
			Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

			PosicoesCompetencias posComp = posCompsRepository.findByPosicaoAndCompetencia(posicao, competencia);

			posicao.getSetPosicoesCompetencias().remove(posComp);

			posCompsRepository.delete(posComp);

			return posicao;
		} else {
			return null;
		}
	}

}
