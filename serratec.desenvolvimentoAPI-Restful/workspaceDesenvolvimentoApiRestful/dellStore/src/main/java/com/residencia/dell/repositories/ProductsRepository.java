package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

}