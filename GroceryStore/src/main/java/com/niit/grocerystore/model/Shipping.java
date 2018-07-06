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

public class Shipping {

	@Id
	 private String shipId;
	 private String shipFname;
	 private String shipLname;
	 private String shipHouseno;
	 private String shipCountry;
	 private String shipCity;
	 private String shipPincode;
	 private String shipEmailid;
	 private String shipMobno;
	 
	 @ManyToOne
		@JoinColumn(name="userId")
		private User user;
	 
	 public Shipping()
		{
			this.shipId="SHIP"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	public String getShipFname() {
		return shipFname;
	}
	public void setShipFname(String shipFname) {
		this.shipFname = shipFname;
	}
	public String getShipLname() {
		return shipLname;
	}
	public void setShipLname(String shipLname) {
		this.shipLname = shipLname;
	}
	public String getShipHouseno() {
		return shipHouseno;
	}
	public void setShipHouseno(String shipHouseno) {
		this.shipHouseno = shipHouseno;
	}
	public String getShipCountry() {
		return shipCountry;
	}
	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}
	public String getShipCity() {
		return shipCity;
	}
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	public String getShipPincode() {
		return shipPincode;
	}
	public void setShipPincode(String shipPincode) {
		this.shipPincode = shipPincode;
	}
	public String getShipEmailid() {
		return shipEmailid;
	}
	public void setShipEmailid(String shipEmailid) {
		this.shipEmailid = shipEmailid;
	}
	public String getShipMobno() {
		return shipMobno;
	}
	public void setShipMobno(String shipMobno) {
		this.shipMobno = shipMobno;
	}
	 
}
