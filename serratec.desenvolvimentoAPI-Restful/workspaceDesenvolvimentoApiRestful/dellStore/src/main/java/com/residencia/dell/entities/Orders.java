package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderId;

	@Column(name = "orderdate")
	private Calendar orderDate;

	@OneToMany(mappedBy = "orders")
	private List<Orderlines> listOrderlines;

	// tem relacionamento com Customer - gerar anotação
	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
	private Customers customers;

	@Column(name = "netamount")
	private BigDecimal netAmount;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Orderlines> getListOrderlines() {
		return listOrderlines;
	}

	public void setListOrderlines(List<Orderlines> listOrderlines) {
		this.listOrderlines = listOrderlines;
	}

}