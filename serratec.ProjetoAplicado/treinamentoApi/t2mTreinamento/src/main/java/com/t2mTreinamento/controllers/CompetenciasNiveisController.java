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

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.services.CompetenciasNiveisService;

@RestController
@RequestMapping("/compsNivs")
public class CompetenciasNiveisController {

	@Autowired
	private CompetenciasNiveisService compsNivsService;

	@GetMapping("/history/competencia/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> findByIdCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsNivsService.findByIdCompetencia(id), headers, HttpStatus.OK);
	}

	@GetMapping("/competencia/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> findByIdCompetenciaAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsNivsService.findByIdCompetenciaAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/nivel/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> findByIdNivel(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsNivsService.findByIdNivel(id), headers, HttpStatus.OK);
	}

	@GetMapping("/nivel/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> findByIdNivelAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsNivsService.findByIdNivelAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/competencia/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> deleteByCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = compsNivsService.deleteByCompetencia(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/nivel/{id}")
	public ResponseEntity<List<CompetenciasNiveis>> deleteByNivel(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = compsNivsService.deleteByNivel(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/nivel/{idNiv}")
	public ResponseEntity<CompetenciasNiveis> update(@Valid @RequestBody CompetenciasNiveis compNiv,
			@PathVariable Long idComp, @PathVariable Long idNiv) {
		HttpHeaders headers = new HttpHeaders();

		CompetenciasNiveis compNivAtualizado = compsNivsService.update(compNiv, idComp, idNiv);

		if (compNivAtualizado != null) {
			return new ResponseEntity<>(compNivAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(compNivAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/nivelAInserir/{idNiv}")
	public ResponseEntity<Competencias> insereNivelEmCompetencia(@PathVariable Long idComp, @PathVariable Long idNiv)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Competencias competenciaAtualizada = compsNivsService.insereNivelEmCompetencia(idComp, idNiv);

		if (competenciaAtualizada != null) {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/nivelARemover/{idNiv}")
	public ResponseEntity<Competencias> removeNivelDeCompetencia(@PathVariable Long idComp, @PathVariable Long idNiv)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Competencias competenciaAtualizada = compsNivsService.removeNivelDeCompetencia(idComp, idNiv);

		if (competenciaAtualizada != null) {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
