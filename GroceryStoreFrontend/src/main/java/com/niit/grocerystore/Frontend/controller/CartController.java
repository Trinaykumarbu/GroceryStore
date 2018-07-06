package com.niit.grocerystore.Frontend.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.grocerystore.Dao.CartDao;
import com.niit.grocerystore.Dao.CartItemsDao;
import com.niit.grocerystore.Dao.CategoryDao;
import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.Dao.UserDao;

import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.CartItems;
import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Product;
import com.niit.grocerystore.model.User;

@Controller
public class CartController {
	
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;


	@RequestMapping("/addtocart/{productId}")
	public ModelAndView cart(@PathVariable("productId")String id)
	{
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
		    String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
		//	System.out.println(u.getUserEmailid());
			if(user==null)
			{
				return new ModelAndView("redirect:/");
			}
			else
			{
				cart=u.getCart();
				Product product1= productDao.getProduct(id);
				CartItems cartItems =new CartItems();
				cartItems.setCart(cart);
				cartItems.setProduct(product1);
				cartItems.setCtItemsPrice(product1.getProductPrice());
				cartItemsDao.saveorupdate(cartItems);
				cart.setCtGrandtotal(cart.getCtGrandtotal()+product1.getProductPrice());
				cart.setCtTotalitem(cart.getCtTotalitem() + 1);
				cartDao.saveorupdate(cart);
			    session.setAttribute("items", cart.getCtTotalitem());
				session.setAttribute("gd", cart.getCtGrandtotal());
				return new ModelAndView("redirect:/");
			}
		}
	else 
		{
			return new ModelAndView("redirect:/");
		}
	
}
	
	@RequestMapping(value="/viewcart")
	public String viewcart(Model model,HttpSession session)
	{
		System.out.println(1223);
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();	
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
			Cart c=u.getCart();
			List<CartItems> cartItems=cartItemsDao.getlist(u.getCart().getCtId());
			if(cartItems==null||cartItems.isEmpty())
			{
				 session.setAttribute("items", 0);
				 model.addAttribute("gtotal", 0.0);
				 model.addAttribute("msg", "no items is added to cart");
				 return "checkout";
			}
			 model.addAttribute("cartItem", cartItems);
			 model.addAttribute("grandtotal", c.getCtGrandtotal());
			 session.setAttribute("items", c.getCtTotalitem());
			 session.setAttribute("ctid", c.getCtId());	 
			 return "checkout";
	   }
	   else
	   { 
		 return "redirect:/viewcart";
	   }	
	}
	
	@RequestMapping(value="/remove/{ctItemsId}")
	public ModelAndView RemoveFromcart(@PathVariable("ctItemsId") String id)
	{
		ModelAndView obj =new ModelAndView("redirect:/viewcart");
		cartItems=cartItemsDao.getCartItems(id);
		Cart c=cartItems.getCart();
		c.setCtGrandtotal(c.getCtGrandtotal()-cartItems.getCtItemsPrice());
		c.setCtTotalitem(c.getCtTotalitem()-1);
		cartDao.saveorupdate(c);
		cartItemsDao.delete(cartItems.getCtItemsId());
		session.setAttribute("items", c.getCtTotalitem());
		return obj;  
	}
	
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromcart(Model model, HttpSession session)
	{
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();	
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
			Cart c=cartDao.getCart(u.getCart().getCtId());
			List<CartItems> cartItems=cartItemsDao.getlist(u.getCart().getCtId());
			for(CartItems g:cartItems)
			{
				cartItemsDao.delete(g.getCtItemsId());
			}
			c.setCtGrandtotal(0.0);
			c.setCtTotalitem(0);
			cartDao.saveorupdate(c);
			session.setAttribute("items", c.getCtTotalitem());
			return "redirect:/viewcart";
		}
		else
		{
			return "redirect:/";
		}
		 
	
}
}