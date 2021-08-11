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

import com.t2mTreinamento.dtos.FormacoesDTO;
import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.services.ColaboradoresFormacoesService;
import com.t2mTreinamento.services.FormacoesService;

@RestController
@RequestMapping("/formacoes")
public class FormacoesController {

	@Autowired
	private FormacoesService formacoesService;

	@Autowired
	private ColaboradoresFormacoesService colabsFormsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Formacoes> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(formacoesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FormacoesDTO> findByIsAtivoAndIdFormacoes(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(formacoesService.findByIsAtivoAndIdFormacoesDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Formacoes>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(formacoesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<FormacoesDTO>> findAllDTO() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(formacoesService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return formacoesService.Count();
	}

	@PostMapping
	public ResponseEntity<Formacoes> save(@Valid @RequestBody Formacoes formacao) {
		HttpHeaders headers = new HttpHeaders();

		Formacoes novaFormacao = formacoesService.save(formacao);

		if (novaFormacao != null) {
			return new ResponseEntity<>(novaFormacao, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novaFormacao, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Formacoes> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeFormacoes = formacoesService.delete(id);
		boolean removidoDeColabsForms = colabsFormsService.deleteByFormacao(id);

		if (removidoDeFormacoes && removidoDeColabsForms) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Formacoes> update(@Valid @RequestBody Formacoes formacao, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Formacoes formacaoAtualizada = formacoesService.update(formacao, id);

		if (formacaoAtualizada != null) {
			return new ResponseEntity<>(formacaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(formacaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
