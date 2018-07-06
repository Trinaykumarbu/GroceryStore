package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.OrderItems;


public interface OrderItemsDao {

	public boolean saveorupdate(OrderItems ordItems);
	public boolean delete(OrderItems ordItems);
	public OrderItems getOrderItems(String orditemsId);
	public List<OrderItems> list();
}