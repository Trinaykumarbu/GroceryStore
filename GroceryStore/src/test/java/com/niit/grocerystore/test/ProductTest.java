package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.CategoryDao;
import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.Dao.SupplierDao;

import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Product;
import com.niit.grocerystore.model.Supplier;

public class ProductTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Product product=(Product)ctx.getBean("product");
		ProductDao productDao= (ProductDao)ctx.getBean("productDao");
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao categoryDao= (CategoryDao)ctx.getBean("categoryDao");
		
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
		
		product.setProductId("p201");
		product.setProductName("product1");
		product.setProductDesc("good");
		product.setProductPrice(100.0);
		product.setProductQty(50);
		
		cat=categoryDao.getCategory("c101");
		supplier=supplierDao.getSupplier("s301");
		product.setCategory(cat);
		product.setSupplier(supplier);
		
		if(productDao.saveorupdate(product)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product is not saved");
		}
		
		product.setProductId("p202");
		product.setProductName("product2");
		product.setProductDesc("good");
		product.setProductPrice(100.0);
		product.setProductQty(50);
		if(productDao.saveorupdate(product)==true)
		{
			System.out.println("Product is saved");
		}
		else
		{
			System.out.println("Product is not saved");
		}
		
		product=productDao.getProduct("p202");
		if(productDao.delete(product)==true)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}
		
		product=productDao.getProduct("p201");
		if(product==null)
		{
			System.out.println("Product not found");
		}
		else
		{
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
			System.out.println(product.getProductPrice());
			System.out.println(product.getProductQty());
		}
		
		List<Product> prodlist=productDao.list();
		for(Product prod:prodlist)
		{
			System.out.println(prod.getProductId());
			System.out.println(prod.getProductName());
			System.out.println(prod.getProductDesc());
			System.out.println(prod.getProductPrice());
			System.out.println(prod.getProductQty());
		}
		
		}

}

