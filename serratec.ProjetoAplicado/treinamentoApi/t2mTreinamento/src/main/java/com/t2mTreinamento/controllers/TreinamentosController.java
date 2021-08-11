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

import com.t2mTreinamento.dtos.TreinamentosDTO;
import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.services.CertificacoesService;
import com.t2mTreinamento.services.ColaboradoresTreinamentosService;
import com.t2mTreinamento.services.ConhecimentosTreinamentosService;
import com.t2mTreinamento.services.TreinamentosService;

@RestController
@RequestMapping("/treinamentos")
public class TreinamentosController {

	@Autowired
	private TreinamentosService treinamentosService;

	@Autowired
	private CertificacoesService certificacoesService;

	@Autowired
	private ConhecimentosTreinamentosService consTrnsService;

	@Autowired
	private ColaboradoresTreinamentosService colabsTrnsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Treinamentos> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(treinamentosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TreinamentosDTO> findByIsAtivoAndIdTreinamentos(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(treinamentosService.findByIsAtivoAndIdTreinamentosDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Treinamentos>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(treinamentosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TreinamentosDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(treinamentosService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return treinamentosService.Count();
	}

	@PostMapping
	public ResponseEntity<Treinamentos> save(@Valid @RequestBody Treinamentos treinamento) {
		HttpHeaders headers = new HttpHeaders();

		Treinamentos novoTreinamento = treinamentosService.save(treinamento);

		if (novoTreinamento != null) {

			return new ResponseEntity<>(novoTreinamento, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoTreinamento, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Treinamentos> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeTreinamentos = treinamentosService.delete(id);
		boolean removidoDeCertificacoes = certificacoesService.deleteByTreinamento(id);
		boolean removidoDeConsTrns = consTrnsService.deleteByTreinamento(id);
		boolean removidoDeColabsTrns = colabsTrnsService.deleteByTreinamento(id);

		if (removidoDeTreinamentos && removidoDeCertificacoes && removidoDeConsTrns && removidoDeColabsTrns) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Treinamentos> update(@Valid @RequestBody Treinamentos treinamento, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Treinamentos treinamentoAtualizado = treinamentosService.update(treinamento, id);

		if (treinamentoAtualizado != null) {
			return new ResponseEntity<>(treinamentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(treinamentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// POTENCIALMENTE INSERIR REQUISIÇÃO PARA INSERIR CERTIFICAÇÃO
}
