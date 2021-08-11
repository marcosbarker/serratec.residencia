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

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.services.ConhecimentosNiveisService;

@RestController
@RequestMapping("/consNivs")
public class ConhecimentosNiveisController {

	@Autowired
	private ConhecimentosNiveisService consNivsService;

	@GetMapping("/history/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> findByIdConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consNivsService.findByIdConhecimento(id), headers, HttpStatus.OK);
	}

	@GetMapping("/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> findByIdConhecimentoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consNivsService.findByIdConhecimentoAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/nivel/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> findByIdNivel(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consNivsService.findByIdNivel(id), headers, HttpStatus.OK);
	}

	@GetMapping("/nivel/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> findByIdNivelAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consNivsService.findByIdNivelAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> deleteByConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = consNivsService.deleteByConhecimento(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/nivel/{id}")
	public ResponseEntity<List<ConhecimentosNiveis>> deleteByNivel(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = consNivsService.deleteByNivel(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/nivel/{idNiv}")
	public ResponseEntity<ConhecimentosNiveis> update(@Valid @RequestBody ConhecimentosNiveis conNiv,
			@PathVariable Long idCon, @PathVariable Long idNiv) {
		HttpHeaders headers = new HttpHeaders();

		ConhecimentosNiveis conNivAtualizado = consNivsService.update(conNiv, idCon, idNiv);

		if (conNivAtualizado != null) {
			return new ResponseEntity<>(conNivAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conNivAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/nivelAInserir/{idNiv}")
	public ResponseEntity<Conhecimentos> insereNivelEmConhecimento(@PathVariable Long idCon, @PathVariable Long idNiv)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos conhecimentoAtualizado = consNivsService.insereNivelEmConhecimento(idCon, idNiv);

		if (conhecimentoAtualizado != null) {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/nivelARemover/{idNiv}")
	public ResponseEntity<Conhecimentos> removeNivelDeConhecimento(@PathVariable Long idCon, @PathVariable Long idNiv)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos conhecimentoAtualizado = consNivsService.removeNivelDeConhecimento(idCon, idNiv);

		if (conhecimentoAtualizado != null) {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
