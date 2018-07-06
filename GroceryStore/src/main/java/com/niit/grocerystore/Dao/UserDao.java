package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.User;

public interface UserDao {
		public boolean saveorupdate(User user);
		public boolean delete(User user);
		public User getUser(String userId);
		public List<User> list();	
		public User isvalid(String userEmailid,String userPassword);
		public User getEmail(String currusername);
}

