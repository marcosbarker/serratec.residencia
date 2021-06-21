package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Category;
import com.residencia.dell.repositories.CategoryRepository;
import com.residencia.dell.vo.CategoryVO;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Long count(){
        return categoryRepository.count();
    }

    public Category save(CategoryVO categoryVO){
    	Category newCategory = ConverteVOParaEntidade(categoryVO);
        return categoryRepository.save(newCategory);
    }

    public Boolean update(Long id, Category category){
        Category updateCategory = categoryRepository.getById(id);
        updateCategory.setCategoryId(category.getCategoryId());
        updateCategory.setCategoryName(category.getCategoryName());
        if(updateCategory == category)
            return true;
        else
            return false;
    }
    
    public Category ConverteVOParaEntidade(CategoryVO categoryVO) {
    	Category category = new Category();
    	
    	category.setCategoryId(categoryVO.getCategoryId());
    	category.setCategoryName(categoryVO.getCategoryName());
    	
    	return category;
    }
    
    public CategoryVO ConverteEntidadeParaVO(Category category) {
    	CategoryVO categoryVO = new CategoryVO();
    	
    	categoryVO.setCategoryId(category.getCategoryId());
    	categoryVO.setCategoryName(category.getCategoryName());
    	
    	return categoryVO;
    }
    
}