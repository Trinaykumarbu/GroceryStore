package com.niit.grocerystore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.grocerystore.Dao.AuthenticationDao;
import com.niit.grocerystore.model.Authentication;

public class AuthenticationTest {

	
		public static void main(String[] args) {
			
			AnnotationConfigApplicationContext Context= new AnnotationConfigApplicationContext();
			
			Context.scan("com.niit.**");
			Context.refresh();
			
			Authentication authentication=(Authentication)Context.getBean("authentication");
			AuthenticationDao authenticationDao =(AuthenticationDao)Context.getBean("authenticationDao");
			
			
		    authentication.setRoleId("a101");
		    authentication.setRoleName("megana");
		    authentication.setUserName("1383");
			if(authenticationDao.saveorupdate(authentication)==true)
				
			{
				System.out.println(" Done");
			}
			else
		    {
				System.out.println("Not  Done");
			}
			
			    authentication.setRoleId("a102");
			    authentication.setRoleName("sowmya");
			    authentication.setUserName("1384");
				if(authenticationDao.saveorupdate(authentication)==true)
					
				{
					System.out.println(" Done");
				}
				else
			    {
					System.out.println("Not  Done");
				}
				
				authentication =authenticationDao.get("a102");
				if(authenticationDao.delete(authentication)==true)
				{
					System.out.println("Deleted");
				}
				else
				{
					System.out.println("Not deleted");
				}
				
				
			}	

	}




