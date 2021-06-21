package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;

@Service
public class ProductsServices {

	@Autowired
	public ProductsRepository productsRepository;
	
	public Products findById(Integer id) {
		return productsRepository.findById(id).get();
	}
	
	public List<Products> findAll(){
		return productsRepository.findAll();
	}
	
	public Long count() {
		return productsRepository.count();
	}
	
	public Products save(Products products) {
		return productsRepository.save(products);
	}
	
	public Products update(Products products, Integer id) {
		products.setProdId(id);
		return productsRepository.save(products);
	}
	
	public void delete(Integer id) {
		productsRepository.deleteById(id);
	}

}