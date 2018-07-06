package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.OrderDao;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.Order;

@Repository("orderDao")
@Transactional

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	@Override
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean delete(Order order) {
		sessionFactory.getCurrentSession().delete(order);	
		return true;
	}

	@Override
	public Order getCartItems(String ordId) {
		String s="from Order where ordId='"+ordId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Order> lorder= (List<Order>)q.list();
		if(lorder==null||lorder.isEmpty())
		{
			System.out.println("Order list not found");
			return null;
		}
		else
		{
			System.out.println("Order list:");
			return lorder.get(0);
		}
		
	}

	@Override
	public List<Order> list() {
		List<Order> orders=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orders;
	}
}
