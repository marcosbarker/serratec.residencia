package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reorder")
public class Reorder {
	
	@Id
	@Column(name="prod_id")
	private Integer prodId;
	
	@Column(name = "date_low")
	private Calendar dateLow;
	
	@Column(name = "quan_low")
	private Integer quanLow;
	
	@Column(name = "date_reordered")
	private Calendar dateReordered;
	
	@Column(name = "quan_reordered")
	private Integer quanReordered;
	
	@Column(name = "date_expected")
	private Calendar dateExpected;

}