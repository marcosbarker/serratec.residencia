package com.residencia.dell.vo;

import java.util.Calendar;

public class OrderlinesVO {

	private Integer orderlineId;
	private OrdersVO ordersVO;
	private Integer prodId;
	private Integer quantity;
	private Calendar orderDate;
	private String prodTitle;

	public String getProdTitle() {
		return prodTitle;
	}

	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}

	public Integer getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(Integer orderlineId) {
		this.orderlineId = orderlineId;
	}

	public OrdersVO getOrdersVO() {
		return ordersVO;
	}

	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

}
