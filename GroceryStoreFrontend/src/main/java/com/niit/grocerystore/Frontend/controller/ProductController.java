package com.niit.grocerystore.Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.fileinput.FileInput;
import com.niit.grocerystore.Dao.CategoryDao;
import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.Dao.SupplierDao;
import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Product;
import com.niit.grocerystore.model.Supplier;


@Controller
public class ProductController 
{

	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	
	String path="C:\\Users\\HP\\eclipse-workspace\\GroceryStoreFrontend\\src\\main\\webapp\\resources\\images\\";
	
	@RequestMapping("/product")
	public ModelAndView Product()
	{
		ModelAndView mv= new ModelAndView("product1");
		mv.addObject("product", new Product());
		
		List<Product> prodlist= productDao.list();
		List<Category> categories= categoryDao.list();
		List<Supplier> suppliers=supplierDao.list();
		mv.addObject("categories", categories);
		mv.addObject("suppliers", suppliers);		
		mv.addObject("products", prodlist);
		return mv;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addproduct(@ModelAttribute("product")Product product)
	{
		ModelAndView mv= new ModelAndView("redirect:/product");
		mv.addObject("product", product);
		String  path="C:\\Users\\TRINAY KUMAR\\eclipse-workspace\\GroceryStoreFrontend\\src\\main\\webapp\\resources\\images\\";
		if(productDao.saveorupdate(product)==true)
		{	FileInput.upload(path,product.getPimg(),product.getProductId()+".jpg");
		
			
			mv.addObject("msg3","Product is saved successfully");
		}
		else
		{
			mv.addObject("msg3","Product is not saved");
		}
		return mv;
	}
	
	@RequestMapping("/editProduct/{productId}")
	public ModelAndView editproduct(@PathVariable("productId")String productId)
	{
		ModelAndView mv= new ModelAndView("product1");
		product=productDao.getProduct(productId);
		mv.addObject("product", product);
		List<Product> prodlist= productDao.list();
		List<Category> categories= categoryDao.list();
		List<Supplier> suppliers=supplierDao.list();
		mv.addObject("categories", categories);
		mv.addObject("suppliers", suppliers);	
		mv.addObject("products", prodlist);
		return mv;		
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public ModelAndView deleteproduct(@PathVariable("productId")String productId)
	{
		ModelAndView mv= new ModelAndView("redirect:/product");
		product= productDao.getProduct(productId);
		if(productDao.delete(product)==true)
		{
			mv.addObject("msg4", "Product Deleted");
		}
		else
		{
			mv.addObject("msg4","Product not deleted");
		}
		return mv;
	}
	
}
