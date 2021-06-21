package com.residencia.biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.biblioteca.entities.Editoras;
import com.residencia.biblioteca.biblioteca.repositories.EditorasRepository;

@Service
public class EditorasService {
	
	@Autowired
	public EditorasRepository editoraRepository;
	
	public Editoras getByID(Integer id) {
		return editoraRepository.findById(id).get();
	}
	
	public List<Editoras> getAll(){
		return editoraRepository.findAll();
	}
	
	public Long count() {
		return editoraRepository.count();
	}
	
	public Editoras save(Editoras editora) {
		Editoras novaEditora = editoraRepository.save(editora);
		return novaEditora;
	}
	
	public Editoras update(Editoras editora, Integer id) {
		editora.setCodigoEditora(id);
		return editoraRepository.save(editora);
	}
	
	public Editoras update(Editoras editora) {
		return editoraRepository.save(editora);
	}
	
	public void delete (Integer id) {
		editoraRepository.deleteById(id);
	}
}
