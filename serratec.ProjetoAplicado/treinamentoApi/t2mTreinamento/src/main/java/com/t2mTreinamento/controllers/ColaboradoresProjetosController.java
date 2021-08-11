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
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.services.ColaboradoresProjetosService;

@RestController
@RequestMapping("/colabsProjs")
public class ColaboradoresProjetosController {

	@Autowired
	private ColaboradoresProjetosService colabsProjsService;

	@GetMapping("/history/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdColaboradorAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdColaboradorAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/projeto/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdProjeto(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdProjeto(id), headers, HttpStatus.OK);
	}

	@GetMapping("/projeto/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdProjetoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdProjetoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/projeto/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> deleteByProjeto(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsProjsService.deleteByProjeto(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsProjsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/projeto/{idProj}")
	public ResponseEntity<ColaboradoresProjetos> update(@Valid @RequestBody ColaboradoresProjetos colabProj,
			@PathVariable Long idColab, @PathVariable Long idProj) {
		HttpHeaders headers = new HttpHeaders();

		ColaboradoresProjetos colabProjAtualizado = colabsProjsService.update(colabProj, idColab, idProj);

		if (colabProjAtualizado != null) {
			return new ResponseEntity<>(colabProjAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colabProjAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/projetoAInserir/{idProj}")
	public ResponseEntity<Colaboradores> insereProjeto(@Valid @RequestBody ColaboradoresProjetos colabProj,
			@PathVariable Long idColab, @PathVariable Long idProj) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsProjsService.insereProjetoEmColaborador(idColab, idProj,
				colabProj.getFuncao(), colabProj.getDataInicio(), colabProj.getDataSaida());

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/projetoARemover/{idProj}")
	public ResponseEntity<Colaboradores> removeProjeto(@PathVariable Long idColab, @PathVariable Long idProj)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsProjsService.removeProjetoDeColaborador(idColab, idProj);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
