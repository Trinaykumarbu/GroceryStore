package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Category;

public interface CategoryDao {

	public boolean saveorupdate(Category category);
	public boolean delete(Category category);
	public Category getCategory(String catId);
	public List<Category> list();
	
}
