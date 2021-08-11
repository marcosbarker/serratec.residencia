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

import com.t2mTreinamento.dtos.CompetenciasDTO;
import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.services.CompetenciasConhecimentosService;
import com.t2mTreinamento.services.CompetenciasNiveisService;
import com.t2mTreinamento.services.CompetenciasService;
import com.t2mTreinamento.services.PosicoesCompetenciasService;

@RestController
@RequestMapping("/competencias")
public class CompetenciasController {

	@Autowired
	CompetenciasService competenciasService;

	@Autowired
	PosicoesCompetenciasService posCompsService;

	@Autowired
	CompetenciasNiveisService compsNivsService;

	@Autowired
	CompetenciasConhecimentosService compsConsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Competencias> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(competenciasService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompetenciasDTO> findByIsAtivoAndIdCompetenciasDTO(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(competenciasService.findByIsAtivoAndIdCompetenciasDTO(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Competencias>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(competenciasService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CompetenciasDTO>> findAllDTO() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(competenciasService.findAllDTO(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return competenciasService.Count();
	}

	@PostMapping
	public ResponseEntity<Competencias> save(@Valid @RequestBody Competencias competencia) {
		HttpHeaders headers = new HttpHeaders();

		Competencias novaCompetencia = competenciasService.save(competencia);

		if (novaCompetencia != null) {

			return new ResponseEntity<>(novaCompetencia, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novaCompetencia, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Competencias> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeCompetencias = competenciasService.delete(id);
		boolean removidoDePosComps = posCompsService.deleteByCompetencia(id);
		boolean removidoDeCompsNivs = compsNivsService.deleteByCompetencia(id);
		boolean removidoDeCompsCons = compsConsService.deleteByCompetencia(id);

		if (removidoDeCompetencias && removidoDePosComps && removidoDeCompsNivs && removidoDeCompsCons) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Competencias> update(@Valid @RequestBody Competencias competencia, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Competencias competenciaAtualizada = competenciasService.update(competencia, id);

		if (competenciaAtualizada != null) {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
