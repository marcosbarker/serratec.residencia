package com.residencia.biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.biblioteca.entities.Alunos;
import com.residencia.biblioteca.biblioteca.repositories.AlunosRepository;

@Service
public class AlunosService {
		
	@Autowired
	public AlunosRepository alunoRepository;
	
	public Alunos getByID(Integer id) {
		return alunoRepository.findById(id).get();
	}
	
	public List<Alunos> getAll(){
		return alunoRepository.findAll();
	}
	
	public Long count() {
		return alunoRepository.count();
	}
	
	public Alunos save(Alunos aluno) {
		
		Alunos novoAluno = alunoRepository.save(aluno);
		
		if(alunoRepository.existsById(novoAluno.getNumeroMatriculaAluno())) {
			return novoAluno;
		}	
		else {
			return null;	
		}
		
	}
	
	public Alunos update(Alunos aluno, Integer id) {
		aluno.setNumeroMatriculaAluno(id);
		return alunoRepository.save(aluno);
	}
	
	public void delete (Integer id) {
		alunoRepository.deleteById(id);
	}
	
}
