package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.BillingDao;
import com.niit.grocerystore.Dao.OrderDao;
import com.niit.grocerystore.Dao.PayDao;
import com.niit.grocerystore.Dao.ShippingDao;
import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.model.Billing;
import com.niit.grocerystore.model.Order;
import com.niit.grocerystore.model.Pay;
import com.niit.grocerystore.model.Shipping;
import com.niit.grocerystore.model.User;

public class OrderTest {

	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Order ord=(Order)ctx.getBean("order");
		OrderDao ordDao= (OrderDao)ctx.getBean("orderDao");
		
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao pydao= (PayDao)ctx.getBean("payDao");
		
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao bdao= (BillingDao)ctx.getBean("billingDao");
		
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shdao= (ShippingDao)ctx.getBean("shippingDao");
		
		User user=(User)ctx.getBean("user");
		UserDao udao= (UserDao)ctx.getBean("userDao");
		
		ord.setOrdId("o801");
		ord.setOrdGrandtotal(0.0);	
		ord.setOrdDate("25");
		ord.setOrdTime("2");
		
		pay=pydao.getPay("p111");
		ord.setPay(pay);
		
		bill=bdao.getBilling("b502");
		ord.setBilling(bill);
        
		ship=shdao.getShipping("s211");
		ord.setShipping(ship);
		
		user=udao.getUser("u401");
		ord.setUser(user);
		
		if(ordDao.saveorupdate(ord)==true)
		{
			System.out.println("Order is saved");
		}
		else
		{
			System.out.println("Order is not saved");
		}
		
		ord.setOrdId("o802");
		ord.setOrdGrandtotal(0.0);	
		ord.setOrdDate("26");
		ord.setOrdTime("4");
		if(ordDao.saveorupdate(ord)==true)
		{
			System.out.println("Order is saved");
		}
		else
		{
			System.out.println("Order is not saved");
		}
		
		ord=ordDao.getCartItems("o802");
		if(ordDao.delete(ord)==true)
		{
			System.out.println("Order deleted");
		}
		else
		{
			System.out.println("Order is not deleted");
		}
		
		ord=ordDao.getCartItems("o801");
		if(ord==null)
		{
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println(ord.getOrdId());
			System.out.println(ord.getOrdGrandtotal());
			System.out.println(ord.getOrdDate());
			System.out.println(ord.getOrdTime());
		}
		
		List<Order> ordlist=ordDao.list();
		for(Order ord1:ordlist)
		{
			System.out.println(ord1.getOrdId());
			System.out.println(ord1.getOrdGrandtotal());
			System.out.println(ord1.getOrdDate());
			System.out.println(ord1.getOrdTime());
		}		
		
		}
}
