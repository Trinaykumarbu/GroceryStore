package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String ctId);
	public List<Cart> list();

}
