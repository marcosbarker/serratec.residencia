package com.residencia.biblioteca.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.biblioteca.services.EmprestimosService;
import com.residencia.biblioteca.biblioteca.vo.EmprestimoVO;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimosControllers {

	@Autowired
    private EmprestimosService emprestimosService;
	
	@GetMapping("/{id}")
	public ResponseEntity<EmprestimoVO> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(emprestimosService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmprestimoVO>> findAll() 
					throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(emprestimosService.findAll(), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return emprestimosService.count();
	}
	
	@PostMapping
	public ResponseEntity<EmprestimoVO> save(@RequestBody EmprestimoVO emprestimoVO){
		HttpHeaders headers = new HttpHeaders();
	
		EmprestimoVO novoEmprestimoVO = emprestimosService.save(emprestimoVO);
		
		if(null != novoEmprestimoVO)
			return new ResponseEntity<>(novoEmprestimoVO, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoEmprestimoVO, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
    public EmprestimoVO update(@PathVariable Integer id, @RequestBody EmprestimoVO emprestimoVO){
       return emprestimosService.update(emprestimoVO, id);
    }
	
}
