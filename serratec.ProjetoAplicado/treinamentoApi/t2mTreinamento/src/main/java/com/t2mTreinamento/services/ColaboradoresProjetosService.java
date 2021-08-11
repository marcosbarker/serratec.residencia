package com.t2mTreinamento.services;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.ColaboradoresProjetosId;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.repositories.ColaboradoresProjetosRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.ProjetosRepository;

@Service
public class ColaboradoresProjetosService {

	@Autowired
	public ColaboradoresProjetosRepository colabsProjsRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public ProjetosRepository projetosRepository;

	public List<ColaboradoresProjetos> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsProjsRepository.findByColaborador(colaborador);
	}

	public List<ColaboradoresProjetos> findByIdColaboradorAtivo(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
		return colabsProjsRepository.findByColaboradorAndIsAtivo(colaborador, 1);

	}

	public List<ColaboradoresProjetos> findByIdProjeto(Long id) {
		Projetos projeto = projetosRepository.findById(id).get();
		return colabsProjsRepository.findByProjeto(projeto);
	}

	public List<ColaboradoresProjetos> findByIdProjetoAtivo(Long id) {
		Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, id);
		return colabsProjsRepository.findByProjetoAndIsAtivo(projeto, 1);
	}

	public List<ColaboradoresProjetos> findAll() {
		return colabsProjsRepository.findAll();
	}

	public Long Count() {
		return colabsProjsRepository.count();
	}

	public ColaboradoresProjetos save(ColaboradoresProjetos colabProj, Long idColab, Long idProj) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, idProj);
		colabProj.setColaborador(colaborador);
		colabProj.setProjeto(projeto);
		colabProj.setIsAtivo(1);
		ColaboradoresProjetos novoColabProj = colabsProjsRepository.save(colabProj);

		if (novoColabProj != null) {
			return novoColabProj;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresProjetos> listColabsProjs = colabsProjsRepository.findByColaborador(colaborador);

			for (ColaboradoresProjetos colabProj : listColabsProjs) {
				colabProj.setIsAtivo(0);
				colabsProjsRepository.save(colabProj);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByProjeto(Long id) {
		if (id != null) {
			Projetos projeto = projetosRepository.findById(id).get();
			List<ColaboradoresProjetos> listColabsProjs = colabsProjsRepository.findByProjetoAndIsAtivo(projeto, 1);

			for (ColaboradoresProjetos colabProj : listColabsProjs) {
				colabProj.setIsAtivo(0);
				colabsProjsRepository.save(colabProj);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ColaboradoresProjetos colabProj, ColaboradoresProjetos novoColabProj) {

		novoColabProj.setColaborador(colabProj.getColaborador());
		novoColabProj.setProjeto(colabProj.getProjeto());
		novoColabProj.setDataInicio(colabProj.getDataInicio());
		novoColabProj.setDataSaida(colabProj.getDataSaida());
		novoColabProj.setFuncao(colabProj.getFuncao());
		novoColabProj.setIsAtivo(1);
	}

	public ColaboradoresProjetos update(ColaboradoresProjetos colabProj, Long idColab, Long idProj) {

		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, idProj);

		ColaboradoresProjetos novoColabProj = new ColaboradoresProjetos();

		novoColabProj.setColaborador(colaborador);
		novoColabProj.setProjeto(projeto);
		novoColabProj.setIdColaboradoresProjetos(new ColaboradoresProjetosId(idColab, idProj));

		updateDados(colabProj, novoColabProj);

		return colabsProjsRepository.save(novoColabProj);

	}

	public Colaboradores insereProjetoEmColaborador(Long idColab, Long idProj, String funcao, Calendar dataInicio,
			Calendar dataSaida) throws Exception {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, idProj);

		ColaboradoresProjetosId colabsProjsId = new ColaboradoresProjetosId(idColab, idProj);

		ColaboradoresProjetos colabProj = new ColaboradoresProjetos(colabsProjsId, colaborador, projeto, funcao,
				dataInicio, dataSaida, 1);

		Set<ColaboradoresProjetos> novoSetColabsProjs = colaborador.getSetColaboradoresProjetos();

		if (novoSetColabsProjs.add(colabProj)) {

			novoSetColabsProjs.add(colabProj);
			colaborador.setSetColaboradoresProjetos(novoSetColabsProjs);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

	public Colaboradores removeProjetoDeColaborador(Long idColab, Long idProj) throws Exception {

		if (idColab != null && idProj != null) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
			Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, idProj);

			ColaboradoresProjetos colabProj = colabsProjsRepository.findByColaboradorAndProjeto(colaborador, projeto);

			colaborador.getSetColaboradoresProjetos().remove(colabProj);

			colabsProjsRepository.delete(colabProj);

			return colaborador;
		} else {
			return null;
		}
	}

}
