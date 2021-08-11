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
import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.services.ColaboradoresEnderecosService;

@RestController
@RequestMapping("/colabsEndrs")
public class ColaboradoresEnderecosController {

	@Autowired
	private ColaboradoresEnderecosService colabsEndrsService;

	@GetMapping("/history/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsEndrsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> findByIdColaboradorAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsEndrsService.findByIdColaboradorAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/endereco/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> findByIdEndereco(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsEndrsService.findByIdEndereco(id), headers, HttpStatus.OK);
	}

	@GetMapping("/endereco/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> findByIdEnderecoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsEndrsService.findByIdEnderecoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsEndrsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/endereco/{id}")
	public ResponseEntity<List<ColaboradoresEnderecos>> deleteByEndereco(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsEndrsService.deleteByEndereco(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/endereco/{idEndr}")
	public ResponseEntity<ColaboradoresEnderecos> update(@Valid @RequestBody ColaboradoresEnderecos colabEndr,
			@PathVariable Long idColab, @PathVariable Long idEndr) {
		HttpHeaders headers = new HttpHeaders();

		ColaboradoresEnderecos colabEndrAtualizado = colabsEndrsService.update(colabEndr, idColab, idEndr);

		if (colabEndrAtualizado != null) {
			return new ResponseEntity<>(colabEndrAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colabEndrAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/enderecoAInserir/{idEndr}")
	public ResponseEntity<Colaboradores> insereEnderecoEmColaborador(@PathVariable Long idColab,
			@PathVariable Long idEndr) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsEndrsService.insereEnderecoEmColaborador(idColab, idEndr);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/colaborador/{idColab}/enderecoARemover/{idEndr}")
	public ResponseEntity<Colaboradores> removeEnderecoDeColaborador(@PathVariable Long idColab,
			@PathVariable Long idEndr) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colabsEndrsService.removeEnderecoDeColaborador(idColab, idEndr);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
