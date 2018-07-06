package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.OrderItemsDao;
import com.niit.grocerystore.model.OrderItems;

public class OrderItemsTest {
      
	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		OrderItems orditems=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao orditemsDao= (OrderItemsDao)ctx.getBean("orderItemsDao");
		
		orditems.setOrditemsId("od901");
		orditems.setOrditemsproductId("90");	
				
		if(orditemsDao.saveorupdate(orditems)==true)
		{
			System.out.println("OrderItems is saved");
		}
		else
		{
			System.out.println("OrderItems is not saved");
		}
		
		orditems.setOrditemsId("od902");
		orditems.setOrditemsproductId("95");		
		if(orditemsDao.saveorupdate(orditems)==true)
		{
			System.out.println("OrderItems is saved");
		}
		else
		{
			System.out.println("OrderItems is not saved");
		}
		
		orditems=orditemsDao.getOrderItems("od902");
		if(orditemsDao.delete(orditems)==true)
		{
			System.out.println("OrderItems deleted");
		}
		else
		{
			System.out.println("OrderItems is not deleted");
		}
		
		orditems=orditemsDao.getOrderItems("od901");
		if(orditems==null)
		{
			System.out.println("OrderItems not found");
		}
		else
		{
			System.out.println(orditems.getOrditemsId());
			System.out.println(orditems.getOrditemsproductId());
		}
		
		List<OrderItems> ordItemslist=orditemsDao.list();
		for(OrderItems ordItems:ordItemslist)
		{
			System.out.println(orditems.getOrditemsId());
			System.out.println(orditems.getOrditemsproductId());

		}
		
		}
}
