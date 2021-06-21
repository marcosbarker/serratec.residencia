package com.residencia.dell.vo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalVO {

	private Integer orderId;
	private Calendar orderDate;
	private BigDecimal netAmount;
	private BigDecimal totalAmount;
	private String customerFirstName;
	private String customerLastName;
	private List<ItemOrderLinesVO> listItemOrderLinesVO;

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

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public List<ItemOrderLinesVO> getListItemOrderLinesVO() {
		return listItemOrderLinesVO;
	}

	public void setListItemOrderLinesVO(List<ItemOrderLinesVO> listItemOrderLinesVO) {
		this.listItemOrderLinesVO = listItemOrderLinesVO;
	}

}
