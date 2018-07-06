package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.CartDao;

import com.niit.grocerystore.model.Cart;

public class CartTest {
	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Cart ct=(Cart)ctx.getBean("cart");
		CartDao ctDao= (CartDao)ctx.getBean("cartDao");
	
		ct.setCtId("ct701");
		ct.setCtGrandtotal(0.0);	
		ct.setCtTotalitem(0);
				
		if(ctDao.saveorupdate(ct)==true)
		{
			System.out.println("Cart is saved");
		}
		else
		{
			System.out.println("Cart is not saved");
		}
		
		ct.setCtId("ct702");
		ct.setCtGrandtotal(0.0);
		ct.setCtTotalitem(0);
		if(ctDao.saveorupdate(ct)==true)
		{
			System.out.println("Cart is saved");
		}
		else
		{
			System.out.println("Cart is not saved");
		}

		ct=ctDao.getCart("ct702");
		if(ctDao.delete(ct)==true)
		{
			System.out.println("Cart deleted");
		}
		else
		{
			System.out.println("Cart is not deleted");
		}
		
		ct=ctDao.getCart("ct701");
		if(ct==null)
		{
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println(ct.getCtId());
			System.out.println(ct.getCtGrandtotal());
			System.out.println(ct.getCtTotalitem());
		}
		
		List<Cart> ctlist=ctDao.list();
		for(Cart ct1:ctlist)
		{
			System.out.println(ct1.getCtId());
			System.out.println(ct1.getCtGrandtotal());
			System.out.println(ct1.getCtTotalitem());

		}
		
	}

		
		
		}

