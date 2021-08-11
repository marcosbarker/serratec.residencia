package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.CompetenciasConhecimentosDTO;
import com.t2mTreinamento.dtos.CompetenciasDTO;
import com.t2mTreinamento.dtos.CompetenciasNiveisDTO;
import com.t2mTreinamento.dtos.ConhecimentosDTO;
import com.t2mTreinamento.dtos.ConhecimentosNiveisDTO;
import com.t2mTreinamento.dtos.ConhecimentosTreinamentosDTO;
import com.t2mTreinamento.dtos.NiveisDTO;
import com.t2mTreinamento.dtos.PosicoesCompetenciasDTO;
import com.t2mTreinamento.dtos.PosicoesDTO;
import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class PosicoesService {

	@Autowired
	public PosicoesRepository posicoesRepository;

	public void convertePosParaDTO(Posicoes pos, PosicoesDTO posDTO) {
		posDTO.setIdPosicoes(pos.getIdPosicoes());
		posDTO.setDescricao(pos.getDescricao());
		posDTO.setNome(pos.getNome());

		// COMPETÊNCIAS
		Set<PosicoesCompetenciasDTO> setPosCompsDTO = new HashSet<>();
		Set<PosicoesCompetencias> setPosComps = pos.getSetPosicoesCompetencias();

		for (PosicoesCompetencias posComp : setPosComps) {
			PosicoesCompetenciasDTO posCompDTO = new PosicoesCompetenciasDTO();

			if (posComp.getIdPosicoesCompetencias().getIdPosicao() == pos.getIdPosicoes()) {
				Competencias comp = posComp.getCompetencia();
				CompetenciasDTO compDTO = new CompetenciasDTO();

				compDTO.setIdCompetencias(comp.getIdCompetencias());
				compDTO.setNome(comp.getNome());
				compDTO.setDescricao(comp.getDescricao());

				// CONHECIMENTOS PARA COMPETÊNCIA

				Set<CompetenciasConhecimentosDTO> setCompsConsDTO = new HashSet<>();
				Set<CompetenciasConhecimentos> setCompsCons = comp.getSetCompetenciasConhecimentos();

				for (CompetenciasConhecimentos compCon : setCompsCons) {
					CompetenciasConhecimentosDTO compConDTO = new CompetenciasConhecimentosDTO();

					if (compCon.getIdCompetenciasConhecimentos().getIdCompetencia() == comp.getIdCompetencias()) {
						Conhecimentos con = compCon.getConhecimento();
						ConhecimentosDTO conDTO = new ConhecimentosDTO();

						conDTO.setIdConhecimentos(con.getIdConhecimentos());
						conDTO.setNome(con.getNome());
						conDTO.setDescricao(con.getDescricao());

						// NÍVEIS DE CONHECIMENTO
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

						// TREINAMENTOS PARA CONHECIMENTO
						Set<ConhecimentosTreinamentosDTO> setConsTrnsDTO = new HashSet<>();
						Set<ConhecimentosTreinamentos> setConsTrns = con.getSetConhecimentosTreinamentos();

						for (ConhecimentosTreinamentos conTrn : setConsTrns) {
							ConhecimentosTreinamentosDTO conTrnDTO = new ConhecimentosTreinamentosDTO();

							if (conTrn.getIdConhecimentosTreinamentos().getIdConhecimento() == con
									.getIdConhecimentos()) {
								Treinamentos trn = conTrn.getTreinamento();
								TreinamentosDTO trnDTO = new TreinamentosDTO();

								trnDTO.setIdTreinamentos(trn.getIdTreinamentos());
								trnDTO.setNome(trn.getNome());
								trnDTO.setDescricao(trn.getDescricao());
								trnDTO.setCargaHoraria(trn.getCargaHoraria());
								trnDTO.setInstituicao(trn.getInstituicao());

								conTrnDTO.setTreinamento(trnDTO);

								setConsTrnsDTO.add(conTrnDTO);
							}
						}
						conDTO.setSetConsTrns(setConsTrnsDTO);
						compConDTO.setConhecimento(conDTO);
						setCompsConsDTO.add(compConDTO);
					}
				}
				compDTO.setSetCompsCons(setCompsConsDTO);

				// NÍVEIS
				Set<CompetenciasNiveisDTO> setCompsNivsDTO = new HashSet<>();
				Set<CompetenciasNiveis> setCompsNivs = comp.getSetCompetenciasNiveis();

				for (CompetenciasNiveis compNiv : setCompsNivs) {
					CompetenciasNiveisDTO compNivDTO = new CompetenciasNiveisDTO();

					if (compNiv.getIdCompetenciasNiveis().getIdCompetencia() == comp.getIdCompetencias()) {
						Niveis niv = compNiv.getNivel();
						NiveisDTO nivDTO = new NiveisDTO();

						nivDTO.setIdNiveis(niv.getIdNiveis());
						nivDTO.setNivel(niv.getNivel());

						compNivDTO.setNivel(nivDTO);

						setCompsNivsDTO.add(compNivDTO);
					}
				}
				compDTO.setSetCompsNivs(setCompsNivsDTO);
				posCompDTO.setCompetencia(compDTO);
				setPosCompsDTO.add(posCompDTO);
			}
		}
		posDTO.setSetPosComps(setPosCompsDTO);
	}

	public Posicoes findById(Long id) {
		return posicoesRepository.findById(id).get();
	}

	public Posicoes findByIsAtivoAndIdPosicoes(Long idPosicoes) {
		return posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPosicoes);
	}

	public PosicoesDTO findByIsAtivoAndIdPosicoesDTO(Long idPosicoes) {
		Posicoes pos = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPosicoes);
		PosicoesDTO posDTO = new PosicoesDTO();
		convertePosParaDTO(pos, posDTO);
		return posDTO;
	}

	public List<Posicoes> findAll() {
		return posicoesRepository.findAll();
	}

	public List<Posicoes> findByIsAtivo() {
		return posicoesRepository.findByIsAtivo(1);
	}

	public List<PosicoesDTO> findAllDTO() {
		List<PosicoesDTO> listPos = new ArrayList<>();
		for (Posicoes pos : posicoesRepository.findByIsAtivo(1)) {
			PosicoesDTO posDTO = new PosicoesDTO();

			convertePosParaDTO(pos, posDTO);
			listPos.add(posDTO);
		}
		return listPos;
	}

	public Long Count() {
		return posicoesRepository.count();
	}

	public Posicoes save(Posicoes posicao) {
		posicao.setIsAtivo(1);
		Posicoes novaPosicao = posicoesRepository.save(posicao);
		if (novaPosicao != null) {
			return novaPosicao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && posicoesRepository.findById(id).get().getIsAtivo() == 1) {
			Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, id);
			posicao.setIsAtivo(0);
			posicoesRepository.save(posicao);
			return true;
		} else {
			return false;
		}
	}

	public Posicoes update(Posicoes posicao, Long id) {
		posicao.setIdPosicoes(id);
		posicao.setIsAtivo(1);
		return posicoesRepository.save(posicao);
	}

}
