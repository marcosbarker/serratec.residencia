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
import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.services.ColaboradoresFormacoesService;

@RestController
@RequestMapping("/colabsForms")
public class ColaboradoresFormacoesController {

	@Autowired
	private ColaboradoresFormacoesService colabsFormsService;

	@GetMapping("/history/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsFormsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> findByIdColaboradorAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsFormsService.findByIdColaboradorAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/formacao/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> findByIdFormacao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsFormsService.findByIdFormacao(id), headers, HttpStatus.OK);
	}

	@GetMapping("/formacao/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> findByIdFormacaoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsFormsService.findByIdFormacaoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/formacao/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> deleteByFormacao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsFormsService.deleteByFormacao(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresFormacoes>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsFormsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/formacao/{idForm}")
	public ResponseEntity<ColaboradoresFormacoes> update(@Valid @RequestBody ColaboradoresFormacoes colabForm,
			@PathVariable Long idColab, @PathVariable Long idForm) {
		HttpHeaders headers = new HttpHeaders();

		ColaboradoresFormacoes colabFormAtualizado = colabsFormsService.update(colabForm, idColab, idForm);

		if (colabFormAtualizado != null) {
			return new ResponseEntity<>(colabFormAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colabFormAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/formacaoAInserir/{idForm}")
	public ResponseEntity<Colaboradores> insereFormacao(@Valid @RequestBody ColaboradoresFormacoes colabForm,
			@PathVariable Long idColab, @PathVariable Long idForm) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsFormsService.insereFormacaoEmColaborador(idColab, idForm,
				colabForm.getDataConclusao(), colabForm.getDataConclusao());

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idColab}/formacaoARemover/{idForm}")
	public ResponseEntity<Colaboradores> removeFormacao(@PathVariable Long idColab, @PathVariable Long idForm)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsFormsService.removeFormacaoDeColaborador(idColab, idForm);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
