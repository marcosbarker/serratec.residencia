package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_hist")
public class CustHist {

	@Id
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "orderid")
	private Integer orderId;
	
	@Column(name = "prod_id")
	private Integer prodId;
	
}