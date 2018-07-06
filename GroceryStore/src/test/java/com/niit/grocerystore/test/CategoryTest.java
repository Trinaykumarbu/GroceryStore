package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.CategoryDao;

import com.niit.grocerystore.model.Category;


public class CategoryTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao= (CategoryDao)ctx.getBean("categoryDao");
		
		cat.setCatId("c101");
		cat.setCatName("category1");
		
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
		}
		
		cat.setCatId("c102");
		cat.setCatName("category2");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("Category is saved");
		}
		else
		{
			System.out.println("Category is not saved");
		}
		
		cat=catDao.getCategory("c102");
		if(catDao.delete(cat)==true)
		{
			System.out.println("Category deleted");
		}
		else
		{
			System.out.println("Category not deleted");
		}
		
		cat=catDao.getCategory("c101");
		if(cat==null)
		{
			System.out.println("Category not found");
		}
		else
		{
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}
			
	List<Category> catlist=catDao.list();
	for(Category c:catlist)
	{
		System.out.println(c.getCatId());
		System.out.println(c.getCatName());
	}
  }
}
	

