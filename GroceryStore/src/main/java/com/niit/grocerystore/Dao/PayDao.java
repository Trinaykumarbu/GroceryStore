package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Pay;


public interface PayDao {
   
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String payId);
	public List<Pay> list();
}
