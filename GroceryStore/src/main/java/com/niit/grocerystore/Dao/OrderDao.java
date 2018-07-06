package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Order;



public interface OrderDao {
	public boolean saveorupdate(Order order);
	public boolean delete(Order order);
	public Order getCartItems(String ordId);
	public List<Order> list();
	

}

