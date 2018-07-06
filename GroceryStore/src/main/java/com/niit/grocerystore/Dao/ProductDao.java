package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Product;


public interface ProductDao {

		public boolean saveorupdate(Product product);
		public boolean delete(Product product);
		public Product getProduct(String productId);
		public List<Product> list();
		public List<Product> getProductByCategory(Category categoryObj);
		public List<Product> getProductBySupplier(String supplierId);
		}
