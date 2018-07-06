package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.CartDao;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.Category;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	@Override
	public boolean saveorupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String ctId) {
		String s="from Cart where ctId='"+ctId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Cart> lcart= (List<Cart>)q.list();
		if(lcart==null||lcart.isEmpty())
		{
			System.out.println("Cart list not found");
			return null;
		}
		else
		{
			System.out.println("Cart list:");
			return lcart.get(0);
		}
	}

	@Override
	public List<Cart> list() {
		List<Cart> carts=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return carts;
	}


}
