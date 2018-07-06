package com.niit.grocerystore.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.UserDao;

import com.niit.grocerystore.model.User;

public class UserTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		User user=(User)ctx.getBean("user");
		UserDao userDao= (UserDao)ctx.getBean("userDao");
		
		user.setUserId("u401");
		user.setUserName("user1");
		user.setUserAddress("bangalore");
		user.setUserPhnno("12345");
		user.setUserPassword("234");
		user.setUserEmailid("67");
		
		
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("User is saved");
		}
		else
		{
			System.out.println("User is not saved");
		}
		
		user.setUserId("u402");
		user.setUserName("user2");
		user.setUserAddress("mysore");
		user.setUserPhnno("67890");
		user.setUserPassword("789");
		user.setUserEmailid("77");		
		if(userDao.saveorupdate(user)==true)
		{
			System.out.println("User is saved");
		}
		else
		{
			System.out.println("User is not saved");
		}
		
		user=userDao.getUser("u402");
		if(userDao.delete(user)==true)
		{
			System.out.println("User deleted");
		}
		else
		{
			System.out.println("User not deleted");
		}
		
		user=userDao.getUser("u401");
		if(user==null)
		{
			System.out.println("User not found");
		}
		else
		{
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserPhnno());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserEmailid());
		}
		
		List<User> usrlist=userDao.list();
		for(User usr:usrlist)
		{
			System.out.println(usr.getUserId());
			System.out.println(usr.getUserName());
			System.out.println(usr.getUserAddress());
			System.out.println(usr.getUserPhnno());
			System.out.println(usr.getUserPassword());
			System.out.println(usr.getUserEmailid());

		}

     }
	
}
	

