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

import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.services.PosicoesCompetenciasService;

@RestController
@RequestMapping("/posComps")
public class PosicoesCompetenciasController {

	@Autowired
	private PosicoesCompetenciasService posCompsService;

	@GetMapping("/history/posicao/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> findByIdPosicao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posCompsService.findByIdPosicao(id), headers, HttpStatus.OK);
	}

	@GetMapping("/posicao/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> findByIdPosicaoAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posCompsService.findByIdPosicaoAtivo(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history/competencia/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> findByIdCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posCompsService.findByIdCompetencia(id), headers, HttpStatus.OK);
	}

	@GetMapping("/competencia/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> findByIdCompetenciaAtivo(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(posCompsService.findByIdCompetenciaAtivo(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/posicao/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> deleteByPosicao(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = posCompsService.deleteByPosicao(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/competencia/{id}")
	public ResponseEntity<List<PosicoesCompetencias>> deleteByCompetencia(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = posCompsService.deleteByCompetencia(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/posicao/{idPos}/competencia/{idComp}")
	public ResponseEntity<PosicoesCompetencias> update(@Valid @RequestBody PosicoesCompetencias posComp,
			@PathVariable Long idPos, @PathVariable Long idComp) {
		HttpHeaders headers = new HttpHeaders();

		PosicoesCompetencias posCompAtualizado = posCompsService.update(posComp, idPos, idComp);

		if (posCompAtualizado != null) {
			return new ResponseEntity<>(posCompAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(posCompAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/posicao/{idPos}/competenciaAInserir/{idComp}")
	public ResponseEntity<Posicoes> insereCompetenciaEmPosicao(@PathVariable Long idPos, @PathVariable Long idComp)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Posicoes posicaoAtualizada = posCompsService.insereCompetenciaEmPosicao(idPos, idComp);

		if (posicaoAtualizada != null) {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/posicao/{idPos}/competenciaARemover/{idComp}")
	public ResponseEntity<Posicoes> removeCompetenciaDePosicao(@PathVariable Long idPos, @PathVariable Long idComp)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		Posicoes posicaoAtualizada = posCompsService.removeCompetenciaDePosicao(idPos, idComp);

		if (posicaoAtualizada != null) {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(posicaoAtualizada, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
