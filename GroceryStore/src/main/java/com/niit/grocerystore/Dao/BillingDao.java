package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Billing;


public interface BillingDao {

	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String userId);
	public List<Billing> list();

}
