package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.SupplierDao;

import com.niit.grocerystore.model.Supplier;

public class SupplierTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao= (SupplierDao)ctx.getBean("supplierDao");
		
		supplier.setSupplierId("s301");
		supplier.setSupplierName("supplier1");
		supplier.setSupplierAddress("bangalore");
		supplier.setSupplierPhnno("12345");
		supplier.setSupplierEmailid("57");
		if(supplierDao.saveorupdate(supplier)==true)
		{
			System.out.println("Supplier is saved");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		
		supplier.setSupplierId("s302");
		supplier.setSupplierName("supplier2");
		supplier.setSupplierAddress("mysore");
		supplier.setSupplierPhnno("67890");
		supplier.setSupplierEmailid("67");
		if(supplierDao.saveorupdate(supplier)==true)
		{
			System.out.println("Supplier is saved");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		
		supplier=supplierDao.getSupplier("s302");
		if(supplierDao.delete(supplier)==true)
		{
			System.out.println("Supplier deleted");
		}
		else
		{
			System.out.println("Supplier not deleted");
		}
		
		supplier=supplierDao.getSupplier("s301");
		if(supplier==null)
		{
			System.out.println("Supplier not found");
		}
		else
		{
			System.out.println(supplier.getSupplierId());
			System.out.println(supplier.getSupplierName());
			System.out.println(supplier.getSupplierAddress());
			System.out.println(supplier.getSupplierPhnno());
			System.out.println(supplier.getSupplierEmailid());
		}
		
		List<Supplier> suplist=supplierDao.list();
		for(Supplier sup:suplist)
		{
			System.out.println(sup.getSupplierId());
			System.out.println(sup.getSupplierName());
			System.out.println(sup.getSupplierAddress());
			System.out.println(sup.getSupplierPhnno());
			System.out.println(sup.getSupplierEmailid());
		}

     }
	
}
