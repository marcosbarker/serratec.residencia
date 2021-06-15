package com.residencia.biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.biblioteca.biblioteca.entities.Livros;

@Repository
public interface LivrosRepository extends JpaRepository <Livros, Integer> {

}
