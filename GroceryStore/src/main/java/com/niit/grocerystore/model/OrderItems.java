package com.niit.grocerystore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class OrderItems {

	@Id
	private String orditemsId;
	private String orditemsproductId;
	
	@ManyToOne
	@JoinColumn(name="ordId")
	private Order order;
	
	public OrderItems()
 	{
 		this.orditemsId="ORDIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
 	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

	public String getOrditemsId() {
		return orditemsId;
	}
	
	public void setOrditemsId(String orditemsId) {
		this.orditemsId = orditemsId;
	}
	public String getOrditemsproductId() {
		return orditemsproductId;
	}
	public void setOrditemsproductId(String orditemsproductId) {
		this.orditemsproductId = orditemsproductId;
	}
	
}
