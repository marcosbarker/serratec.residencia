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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.services.EmprestimoService;
import com.residencia.biblioteca.vo.EmprestimoVO;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
    private EmprestimoService emprestimoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<EmprestimoVO> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(emprestimoService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmprestimoVO>> findAll() 
					throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(emprestimoService.findAll(), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return emprestimoService.count();
	}
	
	@PostMapping
	public ResponseEntity<EmprestimoVO> save(@RequestBody EmprestimoVO emprestimoVO){
		HttpHeaders headers = new HttpHeaders();
	
		EmprestimoVO novoEmprestimoVO = emprestimoService.save(emprestimoVO);
		
		if(null != novoEmprestimoVO)
			return new ResponseEntity<>(novoEmprestimoVO, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoEmprestimoVO, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
    public EmprestimoVO update(@PathVariable Integer id, @RequestBody EmprestimoVO emprestimoVO){
       return emprestimoService.update(emprestimoVO, id);
    }
	
}
