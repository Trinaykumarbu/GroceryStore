package com.niit.grocerystore.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component
public class Order {
	
	@Id
	private String ordId;
	private Double ordGrandtotal;
	private String ordDate;
	private String OrdTime;
	
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderItems;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payId")
	private Pay pay;
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipId")
	private Shipping shipping;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order()
	{
		this.ordId="ORD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Pay getPay() {
		return pay;
	}
	
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	public String getOrdId() {
		return ordId;
	}
	
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}
	
	public Double getOrdGrandtotal() {
		return ordGrandtotal;
	}
	
	public void setOrdGrandtotal(Double ordGrandtotal) {
		this.ordGrandtotal = ordGrandtotal;
	}
	
	public String getOrdDate() {
		return ordDate;
	}
	
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
	public String getOrdTime() {
		return OrdTime;
	}
	
	public void setOrdTime(String ordTime) {
		OrdTime = ordTime;
	}
	
	
}
