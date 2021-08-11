package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.CertificacoesDTO;
import com.t2mTreinamento.dtos.ColaboradoresCertificacoesDTO;
import com.t2mTreinamento.dtos.ColaboradoresDTO;
import com.t2mTreinamento.dtos.ColaboradoresEnderecosDTO;
import com.t2mTreinamento.dtos.ColaboradoresFormacoesDTO;
import com.t2mTreinamento.dtos.ColaboradoresProjetosDTO;
import com.t2mTreinamento.dtos.ColaboradoresTreinamentosDTO;
import com.t2mTreinamento.dtos.EnderecosDTO;
import com.t2mTreinamento.dtos.FormacoesDTO;
import com.t2mTreinamento.dtos.PosicoesDTO;
import com.t2mTreinamento.dtos.ProjetosDTO;
import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.dtos.UsuariosDTO;
import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresCertificacoes;
import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.ColaboradoresTreinamentos;
import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class ColaboradoresService {

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public PosicoesRepository posicoesRepository;

	public void converteColabParaDTO(Colaboradores colab, ColaboradoresDTO colabDTO) {

		colabDTO.setIdColaboradores(colab.getIdColaboradores());
		colabDTO.setNome(colab.getNome());
		colabDTO.setDataNascimento(colab.getDataNascimento());
		colabDTO.setEmail(colab.getEmail());
		colabDTO.setPix(colab.getPix());
		colabDTO.setCpf(colab.getCpf());
		colabDTO.setRg(colab.getRg());
		colabDTO.setCnh(colab.getCnh());
		colabDTO.setPermissao(colab.getPermissao());

		// POSIÇÃO
		PosicoesDTO posDTO = new PosicoesDTO();
		if (colab.getPosicao() != null) {
			posDTO.setIdPosicoes(colab.getPosicao().getIdPosicoes());
			posDTO.setDescricao(colab.getPosicao().getDescricao());
			posDTO.setNome(colab.getPosicao().getNome());
		} else {
			posDTO = null;
		}
		colabDTO.setPosicao(posDTO);

		// USUÁRIO
		UsuariosDTO usuarioDTO = new UsuariosDTO();
		if (colab.getUsuario() != null) {
			usuarioDTO.setUsuario(colab.getUsuario().getUsuario());
			usuarioDTO.setSenha(colab.getUsuario().getSenha());
			usuarioDTO.setIsAdmin(colab.getUsuario().getIsAdmin());
		} else {
			usuarioDTO = null;
		}

		colabDTO.setUsuario(usuarioDTO);

		// ENDEREÇOS
		Set<ColaboradoresEnderecosDTO> setColabsEndrsDTO = new HashSet<>();
		Set<ColaboradoresEnderecos> setColabsEndrs = colab.getSetColaboradoresEnderecos();

		for (ColaboradoresEnderecos colabEndr : setColabsEndrs) {
			ColaboradoresEnderecosDTO colabEndrDTO = new ColaboradoresEnderecosDTO();

			if (colabEndr.getIdColaboradoresEnderecos().getIdColaborador() == colab.getIdColaboradores()) {

				Enderecos endr = colabEndr.getEndereco();
				EnderecosDTO endrDTO = new EnderecosDTO();

				endrDTO.setIdEnderecos(endr.getIdEnderecos());
				endrDTO.setBairro(endr.getBairro());
				endrDTO.setCep(endr.getCep());
				endrDTO.setCidade(endr.getCidade());
				endrDTO.setComplemento(endr.getComplemento());
				endrDTO.setEstado(endr.getEstado());
				endrDTO.setNumero(endr.getNumero());
				endrDTO.setPais(endr.getPais());
				endrDTO.setRua(endr.getRua());

				colabEndrDTO.setEndereco(endrDTO);

				setColabsEndrsDTO.add(colabEndrDTO);
			}

		}
		colabDTO.setSetColabsEndrs(setColabsEndrsDTO);

		// PROJETOS
		Set<ColaboradoresProjetosDTO> setColabsProjsDTO = new HashSet<>();
		Set<ColaboradoresProjetos> setColabsProjs = colab.getSetColaboradoresProjetos();

		for (ColaboradoresProjetos colabProj : setColabsProjs) {
			ColaboradoresProjetosDTO colabProjDTO = new ColaboradoresProjetosDTO();

			if (colabProj.getIdColaboradoresProjetos().getIdColaborador() == colab.getIdColaboradores()) {

				Projetos proj = colabProj.getProjeto();
				ProjetosDTO projDTO = new ProjetosDTO();

				projDTO.setIdProjetos(proj.getIdProjetos());
				projDTO.setAppGerenciamento(proj.getAppGerenciamento());
				projDTO.setDataEntrega(proj.getDataEntregaEsperada());
				projDTO.setDataEntregaEsperada(proj.getDataEntregaEsperada());
				projDTO.setDescricao(proj.getDescricao());
				projDTO.setEquipe(proj.getEquipe());
				projDTO.setNome(proj.getNome());
				projDTO.setSegmento(proj.getSegmento());
				colabProjDTO.setProjeto(projDTO);

				colabProjDTO.setFuncao(colabProj.getFuncao());
				colabProjDTO.setDataInicio(colabProj.getDataInicio());
				colabProjDTO.setDataSaida(colabProj.getDataSaida());

				setColabsProjsDTO.add(colabProjDTO);
			}

		}
		colabDTO.setSetColabsProjs(setColabsProjsDTO);

		// FORMAÇÕES
		Set<ColaboradoresFormacoesDTO> setColabsFormsDTO = new HashSet<>();
		Set<ColaboradoresFormacoes> setColabsForms = colab.getSetColaboradoresFormacoes();

		for (ColaboradoresFormacoes colabForm : setColabsForms) {
			ColaboradoresFormacoesDTO colabFormDTO = new ColaboradoresFormacoesDTO();

			if (colabForm.getIdColaboradoresFormacoes().getIdColaborador() == colab.getIdColaboradores()) {

				Formacoes form = colabForm.getFormacao();
				FormacoesDTO formDTO = new FormacoesDTO();

				formDTO.setIdFormacoes(form.getIdFormacoes());
				formDTO.setInstituicao(form.getInstituicao());
				formDTO.setNivel(form.getNivel());
				formDTO.setNome(form.getNome());

				colabFormDTO.setFormacao(formDTO);
				colabFormDTO.setDataEntrada(colabForm.getDataEntrada());
				colabFormDTO.setDataConclusao(colabForm.getDataConclusao());

				setColabsFormsDTO.add(colabFormDTO);
			}

		}
		colabDTO.setSetColabsForms(setColabsFormsDTO);

		// TREINAMENTOS
		Set<ColaboradoresTreinamentosDTO> setColabsTrnsDTO = new HashSet<>();
		Set<ColaboradoresTreinamentos> setColabsTrns = colab.getSetColaboradoresTreinamentos();

		for (ColaboradoresTreinamentos colabTrn : setColabsTrns) {
			ColaboradoresTreinamentosDTO colabTrnDTO = new ColaboradoresTreinamentosDTO();

			if (colabTrn.getIdColaboradoresTreinamentos().getIdColaborador() == colab.getIdColaboradores()) {

				Treinamentos trn = colabTrn.getTreinamento();
				TreinamentosDTO trnDTO = new TreinamentosDTO();

				trnDTO.setIdTreinamentos(trn.getIdTreinamentos());
				trnDTO.setCargaHoraria(trn.getCargaHoraria());
				trnDTO.setDescricao(trn.getDescricao());
				trnDTO.setInstituicao(trn.getInstituicao());
				trnDTO.setNome(trn.getNome());

				colabTrnDTO.setTreinamento(trnDTO);

				setColabsTrnsDTO.add(colabTrnDTO);
			}

		}
		colabDTO.setSetColabsTrns(setColabsTrnsDTO);

		// CERTIFICAÇÕES
		Set<ColaboradoresCertificacoesDTO> setColabsCertsDTO = new HashSet<>();
		Set<ColaboradoresCertificacoes> setColabsCerts = colab.getSetColaboradoresCertificacoes();

		for (ColaboradoresCertificacoes colabCert : setColabsCerts) {
			ColaboradoresCertificacoesDTO colabCertDTO = new ColaboradoresCertificacoesDTO();

			if (colabCert.getIdColaboradoresCertificacoes().getIdColaborador() == colab.getIdColaboradores()) {

				Certificacoes cert = colabCert.getCertificacao();
				CertificacoesDTO certDTO = new CertificacoesDTO();

				certDTO.setIdCertificacoes(cert.getIdCertificacoes());
				certDTO.setTempoValidade(cert.getTempoValidade());
				certDTO.setNomeCertificado(cert.getTreinamento().getNome());
				certDTO.setInstituicaoCertificado(cert.getTreinamento().getInstituicao());

				colabCertDTO.setCertificacao(certDTO);
				colabCertDTO.setDataObtencao(colabCert.getDataObtencao());

				setColabsCertsDTO.add(colabCertDTO);
			}

		}
		colabDTO.setSetColabsCerts(setColabsCertsDTO);

	}

	public Colaboradores findById(Long id) {
		return colaboradoresRepository.findById(id).get();
	}

	public Colaboradores findByIsAtivoAndIdColaboradores(Long idColaboradores) {
		return colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColaboradores);
	}

	public ColaboradoresDTO findByIsAtivoAndIdColaboradoresDTO(Long idColaboradores) {
		Colaboradores colab = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColaboradores);
		ColaboradoresDTO colabDTO = new ColaboradoresDTO();

		converteColabParaDTO(colab, colabDTO);
		return colabDTO;

	}

	public List<Colaboradores> findAll() {
		return colaboradoresRepository.findAll();
	}

	public List<Colaboradores> findByIsAtivo() {
		return colaboradoresRepository.findByIsAtivo(1);
	}

	public List<ColaboradoresDTO> findAllDTO() {
		List<ColaboradoresDTO> listColabs = new ArrayList<>();
		for (Colaboradores colab : colaboradoresRepository.findByIsAtivo(1)) {
			ColaboradoresDTO colabDTO = new ColaboradoresDTO();
			converteColabParaDTO(colab, colabDTO);
			listColabs.add(colabDTO);
		}
		return listColabs;
	}

	public Long Count() {
		return colaboradoresRepository.count();
	}

	public Colaboradores save(Colaboradores colaborador) {
		colaborador.setIsAtivo(1);
		Colaboradores novoColaborador = colaboradoresRepository.save(colaborador);
		if (novoColaborador != null) {
			return novoColaborador;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && colaboradoresRepository.findById(id).get().getIsAtivo() == 1) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
			colaborador.setIsAtivo(0);
			colaboradoresRepository.save(colaborador);
			return true;
		} else {
			return false;
		}
	}

	public Colaboradores update(Colaboradores colaborador, Long id) {
		colaborador.setIdColaboradores(id);
		colaborador.setIsAtivo(1);
		return colaboradoresRepository.save(colaborador);
	}

	public Colaboradores inserePosicao(Long idColab, Long idPos) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);

		colaborador.setPosicao(posicao);

		Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

		if (colaboradorAtualizado != null) {
			return colaboradorAtualizado;
		} else {
			return null;
		}
	}
}
