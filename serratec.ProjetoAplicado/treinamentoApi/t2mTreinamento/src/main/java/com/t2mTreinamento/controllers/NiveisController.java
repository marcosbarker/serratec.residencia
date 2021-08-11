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

import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.services.CompetenciasNiveisService;
import com.t2mTreinamento.services.ConhecimentosNiveisService;
import com.t2mTreinamento.services.NiveisService;

@RestController
@RequestMapping("/niveis")
public class NiveisController {

	@Autowired
	private NiveisService niveisService;

	@Autowired
	private CompetenciasNiveisService compsNivsService;

	@Autowired
	private ConhecimentosNiveisService consNivsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Niveis> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(niveisService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Niveis> findByIsAtivoAndIdColaboradores(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(niveisService.findByIsAtivoAndIdNiveis(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Niveis>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(niveisService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Niveis>> findByIsAtivo() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(niveisService.findByIsAtivo(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return niveisService.Count();
	}

	@PostMapping
	public ResponseEntity<Niveis> save(@Valid @RequestBody Niveis nivel) {
		HttpHeaders headers = new HttpHeaders();

		Niveis novoNivel = niveisService.save(nivel);

		if (novoNivel != null) {

			return new ResponseEntity<>(novoNivel, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoNivel, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Niveis> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeNiveis = niveisService.delete(id);
		boolean removidoDeCompsNivs = compsNivsService.deleteByNivel(id);
		boolean removidoDeConsNivs = consNivsService.deleteByNivel(id);

		if (removidoDeNiveis && removidoDeCompsNivs && removidoDeConsNivs) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Niveis> update(@Valid @RequestBody Niveis nivel, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Niveis nivelAtualizado = niveisService.update(nivel, id);

		if (nivelAtualizado != null) {
			return new ResponseEntity<>(nivelAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(nivelAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
