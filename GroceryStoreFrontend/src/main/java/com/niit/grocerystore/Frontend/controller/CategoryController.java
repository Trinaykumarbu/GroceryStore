package com.niit.grocerystore.Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.grocerystore.Dao.CategoryDao;
import com.niit.grocerystore.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/category")
	public ModelAndView Category()
	{
		ModelAndView mv= new ModelAndView("category1");
		mv.addObject("category", new Category());
		List<Category> catlist= categoryDao.list();
		mv.addObject("categories", catlist);
		return mv;
	}
	
	@RequestMapping("/addCategory")
	public ModelAndView addcat(@ModelAttribute("category")Category category)
	{
		ModelAndView mv= new ModelAndView("redirect:/category");
		mv.addObject("category", category);
		if(categoryDao.saveorupdate(category)==true)
		{
			mv.addObject("msg1","Category is saved successfully");
		}
		else
		{
			mv.addObject("msg1","category is not saved");
		}
		return mv;
	}
	
	@RequestMapping("/editCategory/{catId}")
	public ModelAndView editcat(@PathVariable("catId")String catid)
	{
		ModelAndView mv= new ModelAndView("category1");
		category=categoryDao.getCategory(catid);
		mv.addObject("category", category);
		List<Category> catlist= categoryDao.list();
		mv.addObject("categories", catlist);
		return mv;
	}
	
	@RequestMapping("/deleteCategory/{catId}")
	public ModelAndView deletecat(@PathVariable("catId")String catid)
	{
		ModelAndView mv= new ModelAndView("redirect:/category");
		category= categoryDao.getCategory(catid);
		if(categoryDao.delete(category)==true)
		{
			mv.addObject("msg2", "Category Deleted");
		}
		else
		{
			mv.addObject("msg2","Category not deleted");
		}
		return mv;
	}
}
