package com.niit.grocerystore.Dao;

import java.util.List;

import com.niit.grocerystore.model.Authentication;

public interface AuthenticationDao {
   boolean saveorupdate (Authentication auth);
   boolean delete(Authentication auth);
   Authentication get(String roleid);
   List<Authentication> list();
}
