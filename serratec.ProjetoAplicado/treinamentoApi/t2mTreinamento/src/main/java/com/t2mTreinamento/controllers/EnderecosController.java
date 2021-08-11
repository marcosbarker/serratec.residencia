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

import com.t2mTreinamento.dtos.EnderecosDTO;
import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.services.ColaboradoresEnderecosService;
import com.t2mTreinamento.services.EnderecosService;

@RestController
@RequestMapping("/enderecos")
public class EnderecosController {

	@Autowired
	private EnderecosService enderecosService;

	@Autowired
	private ColaboradoresEnderecosService colabsEndrsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Enderecos> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecosDTO> findByIsAtivoAndIdEnderecos(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecosService.findByIsAtivoAndIdEnderecosDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Enderecos>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EnderecosDTO>> findByIsAtivo() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecosService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return enderecosService.Count();
	}

	@PostMapping
	public ResponseEntity<Enderecos> save(@Valid @RequestBody Enderecos endereco) {
		HttpHeaders headers = new HttpHeaders();

		Enderecos novoEndereco = enderecosService.save(endereco);

		if (novoEndereco != null) {
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Enderecos> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeEnderecos = enderecosService.delete(id);
		boolean removidoDeColabsEndrs = colabsEndrsService.deleteByEndereco(id);

		if (removidoDeEnderecos && removidoDeColabsEndrs) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Enderecos> update(@Valid @RequestBody Enderecos endereco, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Enderecos enderecoAtualizado = enderecosService.update(endereco, id);

		if (enderecoAtualizado != null) {
			return new ResponseEntity<>(enderecoAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(enderecoAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}
}
