package com.niit.grocerystore.model;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component

public class Product {

	@Id
	private String productId;
	private String productName;
	private String productDesc;
	private Double productPrice;
	private int productQty;
	
	@Transient	
	private MultipartFile pimg;

	
	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}

	@ManyToOne
	@JoinColumn(name="catId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;

	public Product()
	{
		this.productId="PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	
}
