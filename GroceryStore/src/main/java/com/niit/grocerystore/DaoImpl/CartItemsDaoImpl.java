package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.CartItemsDao;

import com.niit.grocerystore.model.CartItems;

@Repository("CartItems")
@Transactional

public class CartItemsDaoImpl implements CartItemsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	public boolean saveorupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}


	
	public CartItems getCartItems(String ctItemsId) {
		String s="from CartItems where ctItemsId='"+ctItemsId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems> lctItems= (List<CartItems>)q.list();
		if(lctItems==null||lctItems.isEmpty())
		{
			System.out.println("CartItems list not found");
			return null;
		}
		else
		{
			System.out.println("CartItems list:");
			return lctItems.get(0);
		}
	}
	
	
	public List<CartItems> getlist(String ctId){
		String s="from CartItems where ctId='"+ ctId +"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems> lctItems=(List<CartItems>)q1.list();
		if(lctItems==null||lctItems.isEmpty())
		{
			System.out.println("CartItems list not found");
			return null;
		}
		else
		{
		  return lctItems;	
		}
	}

	public List<CartItems> list() {
		List<CartItems> cartitems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cartitems;
	}

	
	public CartItems getlistall(String ctItemsId,String productId) {
		String s="from CartItems where ctId='"+ctItemsId+"'and productId='"+productId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<CartItems> lctItems= (List<CartItems>)q.list();
		if(lctItems==null||lctItems.isEmpty())
		{
			System.out.println("CartItems list not found");
			return null;
		}
		else
		{
			System.out.println("CartItems list:");
			return lctItems.get(0);
		}
	}


	public List<CartItems> getlistbyproductId(String productId){
		String c1="from CartItems where productId='"+productId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
		  return list;	
		}
	}

	
	public boolean delete(String ctItemsId) {
		CartItems c=new CartItems();
		c.setCtItemsId(ctItemsId);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}
}	

	