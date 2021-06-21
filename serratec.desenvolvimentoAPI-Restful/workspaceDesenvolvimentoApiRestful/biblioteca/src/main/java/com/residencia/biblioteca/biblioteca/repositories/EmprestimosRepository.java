package com.residencia.biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.biblioteca.biblioteca.entities.Emprestimos;

@Repository
public interface EmprestimosRepository extends JpaRepository <Emprestimos, Integer> {

}
