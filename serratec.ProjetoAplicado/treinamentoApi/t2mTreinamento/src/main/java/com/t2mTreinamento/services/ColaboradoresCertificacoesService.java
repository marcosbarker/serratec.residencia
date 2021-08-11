package com.t2mTreinamento.services;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresCertificacoes;
import com.t2mTreinamento.entities.ColaboradoresCertificacoesId;
import com.t2mTreinamento.repositories.CertificacoesRepository;
import com.t2mTreinamento.repositories.ColaboradoresCertificacoesRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;

@Service
public class ColaboradoresCertificacoesService {

	@Autowired
	public ColaboradoresCertificacoesRepository colabsCertsRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public CertificacoesRepository certificacoesRepository;

	public List<ColaboradoresCertificacoes> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsCertsRepository.findByColaborador(colaborador);
	}

	public List<ColaboradoresCertificacoes> findByIdColaboradorAtivo(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
		return colabsCertsRepository.findByColaboradorAndIsAtivo(colaborador, 1);

	}

	public List<ColaboradoresCertificacoes> findByIdCertificacao(Long id) {
		Certificacoes certificacao = certificacoesRepository.findById(id).get();
		return colabsCertsRepository.findByCertificacao(certificacao);
	}

	public List<ColaboradoresCertificacoes> findByIdCertificacaoAtivo(Long id) {
		Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, id);
		return colabsCertsRepository.findByCertificacaoAndIsAtivo(certificacao, 1);

	}

	public List<ColaboradoresCertificacoes> findAll() {
		return colabsCertsRepository.findAll();
	}

	public Long Count() {
		return colabsCertsRepository.count();
	}

	public ColaboradoresCertificacoes save(ColaboradoresCertificacoes colabCert, Long idColab, Long idCert) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCert);
		colabCert.setColaborador(colaborador);
		colabCert.setCertificacao(certificacao);
		colabCert.setIsAtivo(1);
		ColaboradoresCertificacoes novoColabCert = colabsCertsRepository.save(colabCert);

		if (novoColabCert != null) {
			return novoColabCert;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresCertificacoes> listColabsCerts = colabsCertsRepository.findByColaborador(colaborador);

			for (ColaboradoresCertificacoes colabCert : listColabsCerts) {
				colabCert.setIsAtivo(0);
				colabsCertsRepository.save(colabCert);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByCertificacao(Long id) {
		if (id != null) {
			Certificacoes certificacao = certificacoesRepository.findById(id).get();
			List<ColaboradoresCertificacoes> listColabsCerts = colabsCertsRepository.findByCertificacao(certificacao);

			for (ColaboradoresCertificacoes colabCert : listColabsCerts) {
				colabCert.setIsAtivo(0);
				colabsCertsRepository.save(colabCert);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ColaboradoresCertificacoes colabCert, ColaboradoresCertificacoes novoColabCert) {

		novoColabCert.setColaborador(colabCert.getColaborador());
		novoColabCert.setCertificacao(colabCert.getCertificacao());
		novoColabCert.setDataObtencao(colabCert.getDataObtencao());
		novoColabCert.setIsAtivo(1);
	}

	public ColaboradoresCertificacoes update(ColaboradoresCertificacoes colabCert, Long idColab, Long idCert) {

		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCert);

		ColaboradoresCertificacoes novoColabCert = new ColaboradoresCertificacoes();

		novoColabCert.setColaborador(colaborador);
		novoColabCert.setCertificacao(certificacao);
		novoColabCert.setIdColaboradoresCertificacoes(new ColaboradoresCertificacoesId(idColab, idCert));

		updateDados(colabCert, novoColabCert);

		return colabsCertsRepository.save(novoColabCert);

	}

	public Colaboradores insereCertificacaoEmColaborador(Long idColab, Long idCert, Calendar dataObtencao)
			throws Exception {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCert);

		ColaboradoresCertificacoesId colabsCertsId = new ColaboradoresCertificacoesId(idColab, idCert);

		ColaboradoresCertificacoes colabCert = new ColaboradoresCertificacoes(colabsCertsId, colaborador, certificacao,
				dataObtencao, 1);

		Set<ColaboradoresCertificacoes> novoSetColabsCerts = colaborador.getSetColaboradoresCertificacoes();

		if (novoSetColabsCerts.add(colabCert)) {

			novoSetColabsCerts.add(colabCert);
			colaborador.setSetColaboradoresCertificacoes(novoSetColabsCerts);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

	public Colaboradores removeCertificacaoDeColaborador(Long idColab, Long idCert) throws Exception {

		if (idColab != null && idCert != null) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
			Certificacoes certificacao = certificacoesRepository.findByIsAtivoAndIdCertificacoes(1, idCert);

			ColaboradoresCertificacoes colabCert = colabsCertsRepository.findByColaboradorAndCertificacao(colaborador,
					certificacao);

			colaborador.getSetColaboradoresCertificacoes().remove(colabCert);

			colabsCertsRepository.delete(colabCert);

			return colaborador;
		} else {
			return null;
		}
	}

}
