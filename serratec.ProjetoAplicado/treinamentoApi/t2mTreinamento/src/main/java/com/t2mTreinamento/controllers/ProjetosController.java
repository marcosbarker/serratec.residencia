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

import com.t2mTreinamento.dtos.ProjetosDTO;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.services.ColaboradoresProjetosService;
import com.t2mTreinamento.services.ProjetosService;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {

	@Autowired
	private ProjetosService projetosService;

	@Autowired
	private ColaboradoresProjetosService colabsProjsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Projetos> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjetosDTO> findByIsAtivoAndIdProjetos(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findByIsAtivoAndIdProjetosDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Projetos>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ProjetosDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return projetosService.Count();
	}

	@PostMapping
	public ResponseEntity<Projetos> save(@Valid @RequestBody Projetos projeto) {
		HttpHeaders headers = new HttpHeaders();

		Projetos novoProjeto = projetosService.save(projeto);

		if (novoProjeto != null) {
			return new ResponseEntity<>(novoProjeto, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoProjeto, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Projetos> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeProjetos = projetosService.delete(id);
		boolean removidoDeColabsProjs = colabsProjsService.deleteByProjeto(id);

		if (removidoDeProjetos && removidoDeColabsProjs) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Projetos> update(@Valid @RequestBody Projetos projeto, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Projetos projetoAtualizado = projetosService.update(projeto, id);

		if (projetoAtualizado != null) {
			return new ResponseEntity<>(projetoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(projetoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
