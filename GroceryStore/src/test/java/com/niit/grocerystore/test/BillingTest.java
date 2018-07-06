package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.BillingDao;
import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.model.Billing;

import com.niit.grocerystore.model.User;


public class BillingTest {
	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
     
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao= (BillingDao)ctx.getBean("billingDao");
		
		User user=(User)ctx.getBean("user");
		UserDao udao= (UserDao)ctx.getBean("userDao");
		
		
		bill.setBillId("b501");
		bill.setBillHouseno("50");	
		bill.setBillCity("Bangalore");
		bill.setBillPincode("560005");
		bill.setBillEmailid("dahnu");	
		bill.setBillPhnno("1234567893");
		
		user=udao.getUser("u401");
		bill.setUser(user);
	    

		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Billing is saved");
		}
		else
		{
			System.out.println("Billing is not saved");
		}

		bill.setBillId("b502");
		bill.setBillHouseno("55");	
		bill.setBillCity("Bangalore");
		bill.setBillPincode("560005");
		bill.setBillEmailid("shree");	
		bill.setBillPhnno("3274874192");

		if(billDao.saveorupdate(bill)==true)
		{
			System.out.println("Billing is saved");
		}
		else
		{
			System.out.println("Billing is not saved");
		}

		bill=billDao.getBilling("b502");
		if(billDao.delete(bill)==true)
		{
			System.out.println("Billing deleted");
		}
		else
		{
			System.out.println("Billing is not deleted");
		}
		
		bill=billDao.getBilling("b502");
		if(bill==null)
		{
			System.out.println("Billing not found");
		}
		else
		{
			System.out.println(bill.getBillId());
			System.out.println(bill.getBillHouseno());
			System.out.println(bill.getBillCity());
			System.out.println(bill.getBillPincode());
			System.out.println(bill.getBillEmailid());
			System.out.println(bill.getBillPhnno());
		}
		
	
	List<Billing> billlist=billDao.list();
	for(Billing b:billlist)
	{
		System.out.println(b.getBillId());
		System.out.println(b.getBillHouseno());
		System.out.println(b.getBillCity());
		System.out.println(b.getBillPincode());
		System.out.println(b.getBillEmailid());
		System.out.println(b.getBillPhnno());	
	}
}		
}
