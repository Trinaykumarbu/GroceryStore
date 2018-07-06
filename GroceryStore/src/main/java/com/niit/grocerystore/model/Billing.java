package com.niit.grocerystore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Billing {
	
	@Id
	private String billId;
    private String billHouseno;
    private String billCity;
    private String billPincode;
    private String billEmailid;
    private String billPhnno;
   
     @OneToOne
	@JoinColumn(name="userId")
	private User user;
     
     public Billing()
 	{
 		this.billId="BILL"+UUID.randomUUID().toString().substring(30).toUpperCase();
 	}
    
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getBillHouseno() {
		return billHouseno;
	}
	public void setBillHouseno(String billHouseno) {
		this.billHouseno = billHouseno;
	}
	public String getBillCity() {
		return billCity;
	}
	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}
	public String getBillPincode() {
		return billPincode;
	}
	public void setBillPincode(String billPincode) {
		this.billPincode = billPincode;
	}
	public String getBillEmailid() {
		return billEmailid;
	}
	public void setBillEmailid(String billEmailid) {
		this.billEmailid = billEmailid;
	}
	public String getBillPhnno() {
		return billPhnno;
	}
	public void setBillPhnno(String billPhnno) {
		this.billPhnno = billPhnno;
	}
}
