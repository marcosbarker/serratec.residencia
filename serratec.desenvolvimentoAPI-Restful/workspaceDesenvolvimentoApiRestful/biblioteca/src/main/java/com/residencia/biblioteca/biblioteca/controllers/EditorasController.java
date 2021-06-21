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

import com.residencia.biblioteca.biblioteca.entities.Editoras;
import com.residencia.biblioteca.biblioteca.services.EditorasService;

@RestController
@RequestMapping ("/editoras")
public class EditorasController {
	
	@Autowired
	private EditorasService editorasService;
	
	@GetMapping ("/{id}")
	public ResponseEntity<Editoras> findById (@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders ();
		return new ResponseEntity <> (editorasService.getByID(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Editoras>> findAll ()
		throws Exception {
			HttpHeaders headers = new HttpHeaders ();
			return new ResponseEntity <> (editorasService.getAll(), headers, HttpStatus.OK);
		}
	
	@GetMapping("/count")
	public Long count() {
		return editorasService.count();
	}
	
	@PostMapping
	public ResponseEntity<Editoras> save(@RequestBody Editoras editora){
		//return alunoService.save(editora);
		HttpHeaders headers = new HttpHeaders();
		
		if(null != editorasService.save(editora))
			return new ResponseEntity<>(editorasService.save(editora), headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(editorasService.save(editora), headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
    public Editoras update(Editoras editora){
       return editorasService.update(editora);
    }
	
	@DeleteMapping("/{id}")
	public void DeleteById (@PathVariable Integer id) {
		editorasService.delete(id);
    }

}
