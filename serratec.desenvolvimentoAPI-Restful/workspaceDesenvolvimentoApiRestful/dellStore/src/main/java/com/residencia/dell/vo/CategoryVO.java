package com.residencia.dell.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryVO {

	
	  private Long categoryId;
	  
	  @NotBlank(message = "Insira um Yan")
	  @Size(max = 10, message = "Limite de so {max} caracteres")
	  private String categoryName;
	  
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	  
	  


	  
}
