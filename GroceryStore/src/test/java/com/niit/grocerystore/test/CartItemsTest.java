package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.CartDao;
import com.niit.grocerystore.Dao.CartItemsDao;
import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.CartItems;
import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Product;

public class CartItemsTest {
     public static void main(String args[])
     {
    	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
 		ctx.scan("com.niit.*");
 		ctx.refresh();
 		
 		CartItems ctItems=(CartItems)ctx.getBean("cartItems");
 		CartItemsDao ctItemsDao= (CartItemsDao)ctx.getBean("CartItems");
 		
 		Cart ct=(Cart)ctx.getBean("cart");
		CartDao ctdao= (CartDao)ctx.getBean("cartDao");
		
		Product product=(Product)ctx.getBean("product");
		ProductDao pdao= (ProductDao)ctx.getBean("productDao");
 		
 		ctItems.setCtItemsId("ct601");
		ctItems.setCtItemsPrice((float) 67);
		
		ct=ctdao.getCart("ct701");
        ctItems.setCart(ct);
		
        product=pdao.getProduct("p201");
        ctItems.setProduct(product);
		
		
		
		if(ctItemsDao.saveorupdate(ctItems)==true)
		{
			System.out.println("CartItems is saved");
		}
		else
		{
			System.out.println("CartItems is not saved");
		}
		
 		ctItems.setCtItemsId("ct602");
 		ctItems.setCtItemsPrice((float) 68);
 		if(ctItemsDao.saveorupdate(ctItems)==true)
		{
			System.out.println("CartItems is saved");
		}
		else
		{
			System.out.println("CartItems is not saved");
		}

 	//	ctItems=ctItemsDao.getCartItems("ct602");
	//	if(ctItemsDao.delete(ctItems)==true)
	//	{
	//		System.out.println("CartItems deleted");
	//	}
	//	else
	//	{
	//		System.out.println("CartItems is not deleted");
	//	}
		
		ctItems=ctItemsDao.getCartItems("ct601");
		if(ctItems==null)
		{
			System.out.println("CartItems not found");
		}
		else
		{
			System.out.println(ctItems.getCtItemsId());
			System.out.println(ctItems.getCtItemsPrice());
		}
		
		List<CartItems> ctItemslist=ctItemsDao.list();
		for(CartItems ctItem:ctItemslist)
		{
			System.out.println(ctItem.getCtItemsId());
			System.out.println(ctItem.getCtItemsPrice());
		}
		
	}
}




