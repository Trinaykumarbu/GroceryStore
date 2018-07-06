package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Shipping;

public interface ShippingDao {

	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping> list();
	public List<Shipping> getaddbyuser(String userId); 
		
	}

