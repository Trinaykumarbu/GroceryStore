package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.CartItems;



public interface CartItemsDao {
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(String ctId);
	public CartItems getCartItems(String ctItemsId);
    public List<CartItems> getlist(String ctId);
    public CartItems getlistall(String ctId,String productId);
    public List<CartItems> getlistbyproductId(String productId);
    public List<CartItems> list();
}
