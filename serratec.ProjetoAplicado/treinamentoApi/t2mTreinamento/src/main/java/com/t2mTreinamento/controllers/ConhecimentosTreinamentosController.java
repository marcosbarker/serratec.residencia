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
import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.services.ConhecimentosTreinamentosService;

@RestController
@RequestMapping("/consTrns")
public class ConhecimentosTreinamentosController {

	@Autowired
	private ConhecimentosTreinamentosService consTrnsService;

	@GetMapping("/history/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> findByIdConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consTrnsService.findByIdConhecimento(id), headers, HttpStatus.OK);
	}

	@GetMapping("/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> findByIdConhecimentoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consTrnsService.findByIdConhecimentoAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/treinamento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> findByIdTreinamento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consTrnsService.findByIdTreinamento(id), headers, HttpStatus.OK);
	}

	@GetMapping("/treinamento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> findByIdTreinamentoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(consTrnsService.findByIdTreinamentoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/conhecimento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> deleteByConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = consTrnsService.deleteByConhecimento(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/treinamento/{id}")
	public ResponseEntity<List<ConhecimentosTreinamentos>> deleteByTreinamento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = consTrnsService.deleteByTreinamento(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/treinamento/{idTrn}")
	public ResponseEntity<ConhecimentosTreinamentos> update(@Valid @RequestBody ConhecimentosTreinamentos conTrn,
			@PathVariable Long idCon, @PathVariable Long idTrn) {
		HttpHeaders headers = new HttpHeaders();

		ConhecimentosTreinamentos conTrnAtualizado = consTrnsService.update(conTrn, idCon, idTrn);

		if (conTrnAtualizado != null) {
			return new ResponseEntity<>(conTrnAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conTrnAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/treinamentoAInserir/{idTrn}")
	public ResponseEntity<Conhecimentos> insereTreinamentoEmConhecimento(@PathVariable Long idCon,
			@PathVariable Long idTrn) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos conhecimentoAtualizado = consTrnsService.insereTreinamentoEmConhecimento(idCon, idTrn);

		if (conhecimentoAtualizado != null) {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/conhecimento/{idCon}/treinamentoARemover/{idTrn}")
	public ResponseEntity<Conhecimentos> removeTreinamentoDeConhecimento(@PathVariable Long idCon,
			@PathVariable Long idTrn) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos conhecimentoAtualizado = consTrnsService.removeTreinamentoDeConhecimento(idCon, idTrn);

		if (conhecimentoAtualizado != null) {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
