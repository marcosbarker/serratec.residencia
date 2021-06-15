package com.residencia.biblioteca.biblioteca.controllers;

import java.util.List;

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
import com.residencia.biblioteca.biblioteca.entities.Alunos;
import com.residencia.biblioteca.biblioteca.services.AlunosService;

@RestController
@RequestMapping ("/alunos")
public class AlunosController {
	
	@Autowired
	private AlunosService alunoService;
	
	@GetMapping ("/{id}")
	public ResponseEntity<Alunos> findById (@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders ();
		return new ResponseEntity <> (alunoService.getByID(id), headers, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<Alunos>> findAll ()
		throws Exception {
			HttpHeaders headers = new HttpHeaders ();
			return new ResponseEntity <> (alunoService.getAll(), headers, HttpStatus.OK);
		}
	
	@GetMapping("/count")
	public Long count() {
		return alunoService.count();
	}
	
	@PostMapping
	public ResponseEntity<Alunos> save(@RequestBody Alunos aluno){
		
		HttpHeaders headers = new HttpHeaders();
		
		Alunos novoAluno = alunoService.save(aluno);
		
		if(null != novoAluno)
			return new ResponseEntity<>(novoAluno, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoAluno, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Alunos update(Alunos aluno, Integer id){
       return alunoService.update(aluno, id);
    }
	
	@DeleteMapping("/{id}")
	public void DeleteById (@PathVariable Integer id) {
		alunoService.delete(id);
    }
}
