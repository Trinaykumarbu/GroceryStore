package com.niit.grocerystore.test;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.grocerystore.Dao.PayDao;

import com.niit.grocerystore.model.Pay;

public class PayTest {
	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Pay pay=(Pay)ctx.getBean("pay");
		PayDao payDao= (PayDao)ctx.getBean("payDao");
		
		pay.setPayId("p111");
		pay.setPaymentMethod("cash");
		pay.setPayStatus("good");
		
				
		
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Pay is saved");
		}
		else
		{
			System.out.println("Pay is not saved");
		}
		
		pay.setPayId("p112");
		pay.setPaymentMethod("cash");
		pay.setPayStatus("good");

		
		if(payDao.saveorupdate(pay)==true)
		{
			System.out.println("Pay is saved");
		}
		else
		{
			System.out.println("Pay is not saved");
		}
		
		pay=payDao.getPay("p112");
		if(payDao.delete(pay)==true)
		{
			System.out.println("Pay is deleted");
		}
		else
		{
			System.out.println("Pay is not deleted");
		}
		
		pay=payDao.getPay("p111");
		if(pay==null)
		{
			System.out.println("Pay not found");
		}
		else
		{
			System.out.println(pay.getPayId());
			System.out.println(pay.getPaymentMethod());
			System.out.println(pay.getPayStatus());
		}
		
		List<Pay> paylist=payDao.list();
		for(Pay p:paylist)
		{
			System.out.println(p.getPayId());
			System.out.println(p.getPaymentMethod());
			System.out.println(p.getPayStatus());
		}
		
		}
}
