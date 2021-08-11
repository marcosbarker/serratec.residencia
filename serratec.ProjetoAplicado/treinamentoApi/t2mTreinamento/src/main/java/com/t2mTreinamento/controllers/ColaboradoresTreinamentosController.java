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
import com.t2mTreinamento.entities.ColaboradoresTreinamentos;
import com.t2mTreinamento.services.ColaboradoresTreinamentosService;

@RestController
@RequestMapping("/colabsTrns")
public class ColaboradoresTreinamentosController {

	@Autowired
	private ColaboradoresTreinamentosService colabsTrnsService;

	@GetMapping("/history/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsTrnsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> findByIdColaboradorAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsTrnsService.findByIdColaboradorAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/treinamento/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> findByIdTreinamento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsTrnsService.findByIdTreinamento(id), headers, HttpStatus.OK);
	}

	@GetMapping("/treinamento/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> findByIdTreinamentoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsTrnsService.findByIdTreinamentoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsTrnsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/treinamento/{id}")
	public ResponseEntity<List<ColaboradoresTreinamentos>> deleteByTreinamento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsTrnsService.deleteByTreinamento(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/treinamento/{idTrn}")
	public ResponseEntity<ColaboradoresTreinamentos> update(@Valid @RequestBody ColaboradoresTreinamentos colabTrn,
			@PathVariable Long idColab, @PathVariable Long idTrn) {
		HttpHeaders headers = new HttpHeaders();

		ColaboradoresTreinamentos colabTrnAtualizado = colabsTrnsService.update(colabTrn, idColab, idTrn);

		if (colabTrnAtualizado != null) {
			return new ResponseEntity<>(colabTrnAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colabTrnAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/treinamentoAInserir/{idTrn}")
	public ResponseEntity<Colaboradores> insereTreinamento(@Valid @RequestBody ColaboradoresTreinamentos colabTrn,
			@PathVariable Long idColab, @PathVariable Long idTrn) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsTrnsService.insereTreinamentoEmColaborador(idColab, idTrn,
				colabTrn.getStatus());

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/treinamentoARemover/{idTrn}")
	public ResponseEntity<Colaboradores> removeTreinamento(@PathVariable Long idColab, @PathVariable Long idTrn)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsTrnsService.removeTreinamentoDeColaborador(idColab, idTrn);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
