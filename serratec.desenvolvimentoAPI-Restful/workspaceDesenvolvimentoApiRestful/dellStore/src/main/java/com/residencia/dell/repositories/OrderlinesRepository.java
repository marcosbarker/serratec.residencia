package com.residencia.dell.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Orderlines;

@Repository
public interface OrderlinesRepository extends JpaRepository<Orderlines, Integer> {

}