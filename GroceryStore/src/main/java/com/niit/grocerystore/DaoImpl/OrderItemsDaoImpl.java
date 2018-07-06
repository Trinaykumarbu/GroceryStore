package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.OrderItemsDao;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.OrderItems;

@Repository("orderItemsDao")
@Transactional

public class OrderItemsDaoImpl implements OrderItemsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(OrderItems ordItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(ordItems);	
		return true;
	}

	@Override
	public boolean delete(OrderItems ordItems) {
		sessionFactory.getCurrentSession().delete(ordItems);
		return true;
	}

	@Override
	public OrderItems getOrderItems(String orditemsId) {
		String s="from OrderItems where orditemsId='"+orditemsId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<OrderItems> lorditems= (List<OrderItems>)q.list();
		if(lorditems==null||lorditems.isEmpty())
		{
			System.out.println("OrderItems list not found");
			return null;
		}
		else
		{
			System.out.println("OrderItems list:");
			return lorditems.get(0);
		}
	}
    
	@Override
	public List<OrderItems> list() {
		List<OrderItems> ordersitems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return ordersitems;
	}
}
