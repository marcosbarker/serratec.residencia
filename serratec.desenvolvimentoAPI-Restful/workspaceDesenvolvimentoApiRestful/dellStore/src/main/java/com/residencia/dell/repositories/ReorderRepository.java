package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Reorder;

@Repository
public interface ReorderRepository extends JpaRepository<Reorder, Integer>{

}