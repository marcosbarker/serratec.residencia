package com.residencia.dell.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Category;
import com.residencia.dell.services.CategoryService;
import com.residencia.dell.vo.CategoryVO;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
  
        return categoryService.findById(id);
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@Valid @RequestBody CategoryVO categoryVO) {
		Category Newcategory  = categoryService.save(categoryVO);
		return Newcategory;
	}
	
}