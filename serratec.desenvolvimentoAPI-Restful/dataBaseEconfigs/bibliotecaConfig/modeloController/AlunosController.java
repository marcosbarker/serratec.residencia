package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
    private AlunoService alunoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(alunoService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() 
					throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(alunoService.findAll(), 
				headers, HttpStatus.OK);
	}
	/*
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(alunoService.findAll(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	*/
	@GetMapping("/matricula")
	public ResponseEntity<List<Aluno>> listByMatricula(@RequestParam(required = true) Integer matricula) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(alunoService.listByMatricula(matricula), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return alunoService.count();
	}
	
	@PostMapping
	public ResponseEntity<Aluno> save(Aluno aluno){
		//return alunoService.save(aluno);
		HttpHeaders headers = new HttpHeaders();
		
		if(null != alunoService.save(aluno))
			return new ResponseEntity<>(alunoService.save(aluno), headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(alunoService.save(aluno), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Aluno update(Aluno aluno){
       return alunoService.update(aluno);
    }
	
}
