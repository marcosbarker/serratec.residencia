package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}