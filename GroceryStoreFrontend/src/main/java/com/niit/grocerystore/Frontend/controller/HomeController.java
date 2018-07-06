package com.niit.grocerystore.Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.model.Product;
import com.niit.grocerystore.model.User;

@Controller
public class HomeController {
	
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home(@ModelAttribute("user")User user, Model model)
	{
		model.addAttribute("user", user);
		List<Product> products=productDao.list();
		model.addAttribute("products", products);
			
		return "demo";
	}
	
	@RequestMapping("/category1")
	public String category1()
	{
		return "category1";
	}
  
	
	@RequestMapping("/dryfruits")
	public String dryfruits()
	{
		return "dryfruits";
	}
	
	@RequestMapping("/product1")
	public String product1()
	{
		return "product1";
	}
	
	@RequestMapping("/shipping")
	public String shipping()
	{
		return "shipping";
	}
	
	@RequestMapping("/supplier1")
	public String supplier1()
	{
		return "supplier1";
	}
	
	@RequestMapping("/singlepage")
	public String Singlepage()
	{
		return "Singlepage";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus()
	{
		return "aboutus";
	}
	

	@RequestMapping("/thankyou")
	public String thankyou()
	{
		return "thankyou";
	}
	
	@RequestMapping("/products")
	public String products()
	{
		return "products";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	@RequestMapping("/rating")
	public String rating()
	{
		return "rating";
	}
	
	
}
