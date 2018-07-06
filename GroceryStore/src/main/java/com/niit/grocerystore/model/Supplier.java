package com.niit.grocerystore.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Supplier {
	
	@Id
	private String supplierId;
	private String supplierName;
	private String supplierAddress;
	private String supplierPhnno;
	private String supplierEmailid;
	
	@OneToMany (mappedBy="supplier")
	private List<Product> product;
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Supplier()
	{
		this.supplierId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhnno() {
		return supplierPhnno;
	}

	public void setSupplierPhnno(String supplierPhnno) {
		this.supplierPhnno = supplierPhnno;
	}

	public String getSupplierEmailid() {
		return supplierEmailid;
	}

	public void setSupplierEmailid(String supplierEmailid) {
		this.supplierEmailid = supplierEmailid;
	}

}
