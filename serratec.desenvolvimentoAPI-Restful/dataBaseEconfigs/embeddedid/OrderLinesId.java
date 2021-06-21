package com.residencia.dell.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLinesId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orderlineid;
	private Integer orderid;

	public OrderLinesId() {
	}

	public OrderLinesId(Integer orderlineid, Integer orderid) {
		this.orderlineid = orderlineid;
		this.orderid = orderid;
	}

	public Integer getOrderlineid() {
		return orderlineid;
	}

	public void setOrderlineid(Integer orderlineid) {
		this.orderlineid = orderlineid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((orderlineid == null) ? 0 : orderlineid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLinesId other = (OrderLinesId) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (orderlineid == null) {
			if (other.orderlineid != null)
				return false;
		} else if (!orderlineid.equals(other.orderlineid))
			return false;
		return true;
	}

}
