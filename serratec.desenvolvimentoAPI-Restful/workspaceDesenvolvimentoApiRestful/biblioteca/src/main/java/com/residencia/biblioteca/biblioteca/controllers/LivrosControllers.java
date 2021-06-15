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

import com.residencia.biblioteca.biblioteca.entities.Livros;
import com.residencia.biblioteca.biblioteca.services.LivrosService;

@RestController
@RequestMapping ("/livros")
public class LivrosControllers {
	
	@Autowired
	private LivrosService livrosService;
	
	@GetMapping ("/{id}")
	public ResponseEntity<Livros> findById (@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders ();
		return new ResponseEntity <> (livrosService.getByID(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Livros>> findAll ()
		throws Exception {
			HttpHeaders headers = new HttpHeaders ();
			return new ResponseEntity <> (livrosService.getAll(), headers, HttpStatus.OK);
		}
	
	@GetMapping("/count")
	public Long count() {
		return livrosService.count();
	}
	
	@PostMapping
	public ResponseEntity<Livros> save(@RequestBody Livros livro){
		HttpHeaders headers = new HttpHeaders();
		
		if(null != livrosService.save(livro))
			return new ResponseEntity<>(livrosService.save(livro), headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(livrosService.save(livro), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Livros update(Livros livro){
       return livrosService.update(livro);
    }
	
	@DeleteMapping ("/{id}")
	public void deleteById (@PathVariable Integer id) {
		livrosService.delete(id);
	}
}
