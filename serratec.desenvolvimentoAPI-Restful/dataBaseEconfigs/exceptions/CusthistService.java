package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Custhist;
import com.residencia.dell.exceptions.CusthistException;
import com.residencia.dell.repositories.CusthistRepository;

@Service
public class CusthistService {

	@Autowired
	public CusthistRepository custHistRepository;

	public Custhist findById(Integer id) {
		return custHistRepository.findById(id).get();
	}

	public List<Custhist> findAll() {
		return custHistRepository.findAll();
	}
	
	public List<Custhist> listarTodos(){
		return custHistRepository.findAll();
	}
	
	public void salvar(Custhist custhist){
		custHistRepository.save(custhist);
	}
	
	public Custhist salvarComRetorno(Custhist custhist){
		return custHistRepository.save(custhist);
	}

	public void update(Custhist custhist, Integer id) throws CusthistException{
		//Utilizando o Exception
    if(null == id)
			throw new CusthistException("Não foi informado um ID válido.");
		
		custHistRepository.save(custhist);
	}
	
}
