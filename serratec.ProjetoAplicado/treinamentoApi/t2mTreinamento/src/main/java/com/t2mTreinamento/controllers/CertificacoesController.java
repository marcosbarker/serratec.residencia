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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.dtos.CertificacoesDTO;
import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.services.CertificacoesService;
import com.t2mTreinamento.services.ColaboradoresCertificacoesService;

@RestController
@RequestMapping("/certificacoes")
public class CertificacoesController {

	@Autowired
	private CertificacoesService certificacoesService;

	@Autowired
	private ColaboradoresCertificacoesService colabsCertsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Certificacoes> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CertificacoesDTO> findByIsAtivoAndIdCertificacoes(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findByIsAtivoAndIdCertificacoesDTO(id), headers,
				HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Certificacoes>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CertificacoesDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return certificacoesService.Count();
	}

	@PostMapping
	public ResponseEntity<Certificacoes> save(@Valid @RequestBody Certificacoes certificacao) {
		HttpHeaders headers = new HttpHeaders();

		Certificacoes novaCertificacao = certificacoesService.save(certificacao);

		if (novaCertificacao != null) {

			return new ResponseEntity<>(novaCertificacao, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novaCertificacao, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Certificacoes> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeCertificacoes = certificacoesService.delete(id);
		boolean removidoDeColabsCerts = colabsCertsService.deleteByCertificacao(id);

		if (removidoDeCertificacoes && removidoDeColabsCerts) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Certificacoes> update(@Valid @RequestBody Certificacoes certificacao, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Certificacoes certificacaoAtualizada = certificacoesService.update(certificacao, id);

		if (certificacaoAtualizada != null) {
			return new ResponseEntity<>(certificacaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(certificacaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idCert}/treinamento/{idTrn}")
	public ResponseEntity<Certificacoes> insereTreinamento(@PathVariable Long idCert, @PathVariable Long idTrn) {
		HttpHeaders headers = new HttpHeaders();

		Certificacoes certificacaoAtualizada = certificacoesService.insereTreinamento(idCert, idTrn);

		if (certificacaoAtualizada != null) {
			return new ResponseEntity<>(certificacaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(certificacaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
