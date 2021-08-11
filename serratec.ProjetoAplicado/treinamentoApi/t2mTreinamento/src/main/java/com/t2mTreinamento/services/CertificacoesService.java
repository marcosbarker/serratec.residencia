package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.CertificacoesDTO;
import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.CertificacoesRepository;
import com.t2mTreinamento.repositories.TreinamentosRepository;

@Service
public class CertificacoesService {

	@Autowired
	public CertificacoesRepository certificacoesRepository;

	@Autowired
	public TreinamentosRepository treinamentosRepository;

	public void converteCertParaDTO(Certificacoes cert, CertificacoesDTO certDTO) {

		certDTO.setIdCertificacoes(cert.getIdCertificacoes());
		certDTO.setTempoValidade(cert.getTempoValidade());
		certDTO.setNomeCertificado(cert.getTreinamento().getNome());
		certDTO.setInstituicaoCertificado(cert.getTreinamento().getInstituicao());

	}

	public Certificacoes findById(Long id) {
		return certificacoesRepository.findById(id).get();
	}

	public Certificacoes findByIsAtivoAndIdCertificacoes(Long idCertificacoes) {
		return certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCertificacoes);
	}

	public CertificacoesDTO findByIsAtivoAndIdCertificacoesDTO(Long idCertificacoes) {
		Certificacoes cert = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCertificacoes);
		CertificacoesDTO certDTO = new CertificacoesDTO();

		converteCertParaDTO(cert, certDTO);
		return certDTO;
	}

	public List<Certificacoes> findAll() {
		return certificacoesRepository.findAll();
	}

	public List<Certificacoes> findByIsAtivo() {
		return certificacoesRepository.findByIsAtivo(1);
	}

	public List<CertificacoesDTO> findAllDTO() {
		List<CertificacoesDTO> listCerts = new ArrayList<>();
		for (Certificacoes cert : certificacoesRepository.findByIsAtivo(1)) {
			CertificacoesDTO certDTO = new CertificacoesDTO();
			converteCertParaDTO(cert, certDTO);
			listCerts.add(certDTO);
		}
		return listCerts;
	}

	public Long Count() {
		return certificacoesRepository.count();
	}

	public Certificacoes save(Certificacoes certificacao) {
		certificacao.setIsAtivo(1);
		Certificacoes novaCertificacao = certificacoesRepository.save(certificacao);
		if (novaCertificacao != null) {
			return novaCertificacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && certificacoesRepository.findById(id).get().getIsAtivo() == 1) {
			Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, id);
			certificacao.setIsAtivo(0);
			certificacoesRepository.save(certificacao);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByTreinamento(Long id) {
		if (id != null) {
			Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, id);
			Certificacoes certificacao = certificacoesRepository.findByTreinamento(treinamento);
			certificacao.setIsAtivo(0);
			certificacoesRepository.save(certificacao);

			return true;
		} else {
			return false;
		}
	}

	public Certificacoes update(Certificacoes certificacao, Long id) {
		certificacao.setIdCertificacoes(id);
		certificacao.setIsAtivo(1);
		return certificacoesRepository.save(certificacao);
	}

	public Certificacoes insereTreinamento(Long idCert, Long idTrn) {
		Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCert);
		Treinamentos treinamento = treinamentosRepository.findByIsAtivoAndIdTreinamentos(1, idTrn);

		certificacao.setTreinamento(treinamento);

		Certificacoes certificacaoAtualizada = certificacoesRepository.save(certificacao);

		if (certificacaoAtualizada != null) {
			return certificacaoAtualizada;
		} else {
			return null;
		}
	}
}
