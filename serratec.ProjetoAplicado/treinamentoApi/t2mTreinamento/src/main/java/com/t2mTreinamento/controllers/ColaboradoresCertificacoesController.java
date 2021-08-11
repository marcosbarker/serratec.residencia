package com.t2mTreinamento.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresCertificacoes;
import com.t2mTreinamento.services.ColaboradoresCertificacoesService;

@RestController
@RequestMapping("/colabsCerts")
public class ColaboradoresCertificacoesController {

	@Autowired
	private ColaboradoresCertificacoesService colabsCertsService;

	@GetMapping("/history/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsCertsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> findByIdColaboradorAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsCertsService.findByIdColaboradorAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/certificacao/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> findByIdCertificacao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsCertsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/certificacao/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> findByIdCertificacaoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsCertsService.findByIdCertificacaoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsCertsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/certificacao/{id}")
	public ResponseEntity<List<ColaboradoresCertificacoes>> deleteByCertificacao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsCertsService.deleteByCertificacao(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/certificacao/{idCert}")
	public ResponseEntity<ColaboradoresCertificacoes> update(@Valid @RequestBody ColaboradoresCertificacoes colabCert,
			@PathVariable Long idColab, @PathVariable Long idCert) {
		HttpHeaders headers = new HttpHeaders();

		ColaboradoresCertificacoes colabCertAtualizado = colabsCertsService.update(colabCert, idColab, idCert);

		if (colabCertAtualizado != null) {
			return new ResponseEntity<>(colabCertAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colabCertAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/certificacaoAInserir/{idCert}")
	public ResponseEntity<Colaboradores> insereCertificacao(@Valid @RequestBody ColaboradoresCertificacoes colabCert,
			@PathVariable Long idColab, @PathVariable Long idCert) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsCertsService.insereCertificacaoEmColaborador(idColab, idCert,
				colabCert.getDataObtencao());

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/certificacaoARemover/{idCert}")
	public ResponseEntity<Colaboradores> removeCertificacao(@PathVariable Long idColab, @PathVariable Long idCert)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsCertsService.removeCertificacaoDeColaborador(idColab, idCert);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
