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
import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.CompetenciasRepository;

@Service
public class CompetenciasService {

	@Autowired
	public CompetenciasRepository competenciasRepository;

	public void converteCompParaDTO(Competencias comp, CompetenciasDTO compDTO) {

		compDTO.setIdCompetencias(comp.getIdCompetencias());
		compDTO.setNome(comp.getNome());
		compDTO.setDescricao(comp.getDescricao());

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

		// CONHECIMENTOS
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
				compConDTO.setConhecimento(conDTO);
				setCompsConsDTO.add(compConDTO);
			}
		}
		compDTO.setSetCompsCons(setCompsConsDTO);
	}

	public Competencias findById(Long id) {
		return competenciasRepository.findById(id).get();
	}

	public Competencias findByIsAtivoAndIdCompetencias(Long id) {
		return competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
	}

	public CompetenciasDTO findByIsAtivoAndIdCompetenciasDTO(Long id) {
		Competencias comp = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
		CompetenciasDTO compDTO = new CompetenciasDTO();

		converteCompParaDTO(comp, compDTO);
		return compDTO;
	}

	public List<Competencias> findAll() {
		return competenciasRepository.findAll();
	}

	public List<Competencias> findByIsAtivo() {
		return competenciasRepository.findByIsAtivo(1);
	}

	public List<CompetenciasDTO> findAllDTO() {
		List<CompetenciasDTO> listComps = new ArrayList<>();
		for (Competencias comp : competenciasRepository.findByIsAtivo(1)) {
			CompetenciasDTO compDTO = new CompetenciasDTO();
			converteCompParaDTO(comp, compDTO);
			listComps.add(compDTO);
		}
		return listComps;
	}

	public Long Count() {
		return competenciasRepository.count();
	}

	public Competencias save(Competencias competencia) {
		competencia.setIsAtivo(1);
		Competencias novaCompetencia = competenciasRepository.save(competencia);

		if (novaCompetencia != null) {
			return novaCompetencia;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && competenciasRepository.findById(id).get().getIsAtivo() == 1) {
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
			competencia.setIsAtivo(0);
			competenciasRepository.save(competencia);
			return true;
		} else {
			return false;
		}
	}

	public Competencias update(Competencias competencia, Long id) {
		competencia.setIdCompetencias(id);
		competencia.setIsAtivo(1);
		return competenciasRepository.save(competencia);
	}

}
