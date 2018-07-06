package com.niit.grocerystore.Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.model.Billing;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.User;

@Controller
public class UserController {

	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;

	@RequestMapping("/user")
	public ModelAndView User()
	{
		ModelAndView mv= new ModelAndView("user");
		mv.addObject("user", new User());
		List<User> userlist= userDao.list();
		mv.addObject("users", userlist);
		return mv;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
		ModelAndView mv= new ModelAndView("redirect:/");
		Cart c=new Cart();
		user.setCart(c);
		Billing bill=new Billing();
		user.setBilling(bill);
		if(userDao.saveorupdate(user)==true)
		{
			mv.addObject("msg7","User is saved successfully");
		}
		else
		{
			mv.addObject("msg7","User is not saved");
		}
		return mv;
	}
	
}
