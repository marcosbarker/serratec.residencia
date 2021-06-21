package com.residencia.biblioteca.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.biblioteca.biblioteca.entities.Editoras;

@Repository
public interface EditorasRepository extends JpaRepository <Editoras, Integer> {

}
