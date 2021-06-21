package com.residencia.biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.biblioteca.entities.Livros;
import com.residencia.biblioteca.biblioteca.repositories.LivrosRepository;

@Service
public class LivrosService {
	

		@Autowired
		public LivrosRepository livrosRepository;
		
		public Livros getByID(Integer id) {
			return livrosRepository.findById(id).get();
		}
		
		public List<Livros> getAll(){
			return livrosRepository.findAll();
		}
		
		public Long count() {
			return livrosRepository.count();
		}
		
		public Livros save(Livros livro) {
			Livros novoLivro = livrosRepository.save(livro);
			if(livrosRepository.existsById(novoLivro.getCodigoLivro())) {
				return novoLivro;
			}	
			else {
				return null;	
			}
		}
		
		public Livros update(Livros livro, Integer id) {
			livro.setCodigoLivro(id);
			return livrosRepository.save(livro);
		}
		
		public Livros update(Livros livro) {
			return livrosRepository.save(livro);
		}
		
		public void delete(Integer id) {
			 livrosRepository.deleteById(id);
		}

}
