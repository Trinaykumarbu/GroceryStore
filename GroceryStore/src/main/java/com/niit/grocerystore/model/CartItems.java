package com.niit.grocerystore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class CartItems {
	
	@Id
	private String ctItemsId;
	private double ctItemsPrice;
	
	@ManyToOne
	@JoinColumn(name="ctId")
	private Cart cart;

	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) 
	{
		this.cart = cart;
	}
	
	public CartItems()
	{
		this.ctItemsId="CITID"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getCtItemsId() {
		return ctItemsId;
	}
	public void setCtItemsId(String ctItemsId) {
		this.ctItemsId = ctItemsId;
	}
	
	public double getCtItemsPrice() {
		return ctItemsPrice;
	}
	public void setCtItemsPrice(double ctItemsPrice) {
		this.ctItemsPrice = ctItemsPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
