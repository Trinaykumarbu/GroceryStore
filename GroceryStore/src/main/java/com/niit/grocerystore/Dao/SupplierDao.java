package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Supplier;



public interface SupplierDao {

		public boolean saveorupdate(Supplier supplier);
		public boolean delete(Supplier supplier);
		public Supplier getSupplier(String supplierId);
		public List<Supplier> list();
		

}
