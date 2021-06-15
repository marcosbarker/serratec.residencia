package com.residencia.validation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.validation.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
