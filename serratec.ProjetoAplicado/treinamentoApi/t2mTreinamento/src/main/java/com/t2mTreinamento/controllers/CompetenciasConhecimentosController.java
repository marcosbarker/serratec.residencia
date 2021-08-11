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
import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.services.CompetenciasConhecimentosService;

@RestController
@RequestMapping("/compsCons")
public class CompetenciasConhecimentosController {

	@Autowired
	private CompetenciasConhecimentosService compsConsService;

	@GetMapping("/history/competencia/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> findByIdCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsConsService.findByIdCompetencia(id), headers, HttpStatus.OK);
	}

	@GetMapping("/competencia/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> findByIdCompetenciaAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsConsService.findByIdCompetenciaAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/conhecimento/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> findByIdConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsConsService.findByIdConhecimento(id), headers, HttpStatus.OK);
	}

	@GetMapping("/conhecimento/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> findByIdConhecimentoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(compsConsService.findByIdConhecimentoAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/competencia/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> deleteByCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = compsConsService.deleteByCompetencia(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/conhecimento/{id}")
	public ResponseEntity<List<CompetenciasConhecimentos>> deleteByConhecimento(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = compsConsService.deleteByConhecimento(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/conhecimento/{idCon}")
	public ResponseEntity<CompetenciasConhecimentos> update(@Valid @RequestBody CompetenciasConhecimentos compCon,
			@PathVariable Long idComp, @PathVariable Long idCon) {
		HttpHeaders headers = new HttpHeaders();

		CompetenciasConhecimentos compConAtualizado = compsConsService.update(compCon, idComp, idCon);

		if (compConAtualizado != null) {
			return new ResponseEntity<>(compConAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(compConAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/conhecimentoAInserir/{idCon}")
	public ResponseEntity<Competencias> insereConhecimentoEmCompetencia(@PathVariable Long idComp,
			@PathVariable Long idCon) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Competencias competenciaAtualizada = compsConsService.insereConhecimentoEmCompetencia(idComp, idCon);

		if (competenciaAtualizada != null) {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/competencia/{idComp}/conhecimentoARemover/{idCon}")
	public ResponseEntity<Competencias> removeConhecimentoDeCompetencia(@PathVariable Long idComp,
			@PathVariable Long idCon) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Competencias competenciaAtualizada = compsConsService.removeConhecimentoDeCompetencia(idComp, idCon);

		if (competenciaAtualizada != null) {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(competenciaAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
