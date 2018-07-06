package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.ShippingDao;
import com.niit.grocerystore.Dao.UserDao;

import com.niit.grocerystore.model.Shipping;
import com.niit.grocerystore.model.User;

public class ShippingTest {
   
	public static void main(String args[])
    {
   	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao= (ShippingDao)ctx.getBean("shippingDao");
		
		User user=(User)ctx.getBean("user");
		UserDao udao= (UserDao)ctx.getBean("userDao");
		
		ship.setShipId("s211");
		ship.setShipFname("Dhanu");
		ship.setShipLname("shree");
		ship.setShipHouseno("25");
		ship.setShipCountry("India");
		ship.setShipCity("Bangalore");
		ship.setShipPincode("560001");
		ship.setShipEmailid("dhanu");
		ship.setShipMobno("9000000010");
		
		user=udao.getUser("u401");
		ship.setUser(user);
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Shipping is saved");
		}
		else
		{
			System.out.println("Shipping is not saved");
		}
		
		ship.setShipId("s212");
		ship.setShipFname("Thanu");
		ship.setShipLname("shree");
		ship.setShipHouseno("50");
		ship.setShipCountry("India");
		ship.setShipCity("Bangalore");
		ship.setShipPincode("560002");
		ship.setShipEmailid("thanu");
		ship.setShipMobno("9000000009");
		
		if(shipDao.saveorupdate(ship)==true)
		{
			System.out.println("Shipping is saved");
		}
		else
		{
			System.out.println("Shipping is not saved");
		}
		
		ship=shipDao.getShipping("s212");
		if(shipDao.delete(ship)==true)
		{
			System.out.println("Ship is deleted");
		}
		else
		{
			System.out.println("Ship is not deleted");
		}
		
		ship=shipDao.getShipping("s211");
		if(ship==null)
		{
			System.out.println("Ship not found");
		}
		else
		{
			System.out.println(ship.getShipId());
			System.out.println(ship.getShipFname());
			System.out.println(ship.getShipLname());
			System.out.println(ship.getShipHouseno());
			System.out.println(ship.getShipCountry());
			System.out.println(ship.getShipCity());
			System.out.println(ship.getShipPincode());
			System.out.println(ship.getShipEmailid());
			System.out.println(ship.getShipMobno());
		}
		
		List<Shipping> shiplist=shipDao.list();
		for(Shipping ship1:shiplist)
		{
			System.out.println(ship1.getShipId());
			System.out.println(ship1.getShipFname());
			System.out.println(ship1.getShipLname());
			System.out.println(ship1.getShipHouseno());
			System.out.println(ship1.getShipCountry());
			System.out.println(ship1.getShipCity());
			System.out.println(ship1.getShipPincode());
			System.out.println(ship1.getShipEmailid());
			System.out.println(ship1.getShipMobno());
		}

		}
}
