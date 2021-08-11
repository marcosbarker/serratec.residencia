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

import com.t2mTreinamento.dtos.ConhecimentosDTO;
import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.services.CompetenciasConhecimentosService;
import com.t2mTreinamento.services.ConhecimentosNiveisService;
import com.t2mTreinamento.services.ConhecimentosService;
import com.t2mTreinamento.services.ConhecimentosTreinamentosService;

@RestController
@RequestMapping("/conhecimentos")
public class ConhecimentosController {

	@Autowired
	private ConhecimentosService conhecimentosService;

	@Autowired
	private CompetenciasConhecimentosService compsConsService;

	@Autowired
	private ConhecimentosNiveisService consNivsService;

	@Autowired
	private ConhecimentosTreinamentosService consTrnsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Conhecimentos> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(conhecimentosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConhecimentosDTO> findByIsAtivoAndIdConhecimentos(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(conhecimentosService.findByIsAtivoAndIdConhecimentosDTO(id), headers,
				HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Conhecimentos>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(conhecimentosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ConhecimentosDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(conhecimentosService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return conhecimentosService.Count();
	}

	@PostMapping
	public ResponseEntity<Conhecimentos> save(@Valid @RequestBody Conhecimentos conhecimento) {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos novoConhecimento = conhecimentosService.save(conhecimento);

		if (novoConhecimento != null) {

			return new ResponseEntity<>(novoConhecimento, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoConhecimento, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Conhecimentos> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeConhecimentos = conhecimentosService.delete(id);
		boolean removidoDeCompsCons = compsConsService.deleteByConhecimento(id);
		boolean removidoDeConsNivs = consNivsService.deleteByConhecimento(id);
		boolean removidoDeConsTrns = consTrnsService.deleteByConhecimento(id);

		if (removidoDeConhecimentos && removidoDeCompsCons && removidoDeConsNivs && removidoDeConsTrns) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Conhecimentos> update(@Valid @RequestBody Conhecimentos conhecimento, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Conhecimentos conhecimentoAtualizado = conhecimentosService.update(conhecimento, id);

		if (conhecimentoAtualizado != null) {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(conhecimentoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
