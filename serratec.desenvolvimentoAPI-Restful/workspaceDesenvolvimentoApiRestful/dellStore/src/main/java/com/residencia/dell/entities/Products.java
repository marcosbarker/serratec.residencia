package com.residencia.dell.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Integer prodId;

	@Column(name = "category")
	private Integer category;

	@Column(name = "title")
	private String title;

	@Column(name = "actor")
	private String actor;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "special")
	private Integer special;

	@Column(name = "common_prod_id")
	private Integer commonProdId;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getSpecial() {
		return special;
	}

	public void setSpecial(Integer special) {
		this.special = special;
	}

	public Integer getCommonProdId() {
		return commonProdId;
	}

	public void setCommonProdId(Integer commonProdId) {
		this.commonProdId = commonProdId;
	}

}