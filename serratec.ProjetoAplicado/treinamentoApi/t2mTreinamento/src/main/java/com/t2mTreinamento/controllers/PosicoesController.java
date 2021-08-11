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

import com.t2mTreinamento.dtos.PosicoesDTO;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.services.PosicoesService;

@RestController
@RequestMapping("/posicoes")
public class PosicoesController {

	@Autowired
	private PosicoesService posicoesService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Posicoes> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posicoesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PosicoesDTO> findByIsAtivoAndIdPosicoes(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posicoesService.findByIsAtivoAndIdPosicoesDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Posicoes>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posicoesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PosicoesDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posicoesService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return posicoesService.Count();
	}

	@PostMapping
	public ResponseEntity<Posicoes> save(@Valid @RequestBody Posicoes posicao) {
		HttpHeaders headers = new HttpHeaders();

		Posicoes novaPosicao = posicoesService.save(posicao);

		if (novaPosicao != null) {
			return new ResponseEntity<>(novaPosicao, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novaPosicao, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// FUTURAMENTE DEVE SER COMPLETADO
	@DeleteMapping("/{id}")
	public ResponseEntity<Posicoes> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDePosicoes = posicoesService.delete(id);

		if (removidoDePosicoes) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Posicoes> update(@Valid @RequestBody Posicoes posicao, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Posicoes posicaoAtualizada = posicoesService.update(posicao, id);

		if (posicaoAtualizada != null) {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
