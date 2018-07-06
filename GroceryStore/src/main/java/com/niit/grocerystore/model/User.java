package com.niit.grocerystore.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class User {
	@Id
	private String userId;
	private String userName;
	private String userAddress;
	private String userPhnno;
	private String userPassword;
	private String userEmailid;
	private String userPincode;
	private String userHouseno;
	private String role="ROLE_USER";
	
	public String getUserPincode() {
		return userPincode;
	}

	public void setUserPincode(String userPincode) {
		this.userPincode = userPincode;
	}

	public String getUserHouseno() {
		return userHouseno;
	}

	public void setUserHouseno(String userHouseno) {
		this.userHouseno = userHouseno;
	}

	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}
   
	@OneToMany(mappedBy="user")
	private List<Shipping> shipping;
	
	public List<Shipping> getShipping() {
		return shipping;
	}

	@OneToOne
	@JoinColumn(name="ctId")
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setShipping(List<Shipping> shipping) {
		this.shipping = shipping;
	}

	public User()
	{
		this.userId="USE"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhnno() {
		return userPhnno;
	}

	public void setUserPhnno(String userPhnno) {
		this.userPhnno = userPhnno;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmailid() {
		return userEmailid;
	}

	public void setUserEmailid(String userEmailid) {
		this.userEmailid = userEmailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
