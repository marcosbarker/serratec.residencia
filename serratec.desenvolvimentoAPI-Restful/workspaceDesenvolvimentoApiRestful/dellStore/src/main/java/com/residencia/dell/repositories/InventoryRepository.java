package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}