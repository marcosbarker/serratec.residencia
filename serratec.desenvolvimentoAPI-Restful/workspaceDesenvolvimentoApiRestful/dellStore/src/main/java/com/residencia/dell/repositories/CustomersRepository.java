package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}