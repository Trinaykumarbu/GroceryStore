package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.ShippingDao;

import com.niit.grocerystore.model.Shipping;

@Repository("shippingDao")
@Transactional

public class ShippingDaoImpl implements ShippingDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Shipping shipping) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean delete(Shipping shipping) {
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}


	@Override
	public Shipping getShipping(String shipId) {
		String s="from Shipping where shipId='"+shipId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> lship= (List<Shipping>)q.list();
		if(lship==null||lship.isEmpty())
		{
			System.out.println("Shipping list not found");
			return null;
		}
		else
		{
			System.out.println("Shipping list:");
			return lship.get(0);
		}
	}
       
	@Override
	public List<Shipping> list() {
		List<Shipping> ships=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return ships;
	}

	@Override
	public List<Shipping> getaddbyuser(String userId) {
		String s="from Shipping where userId='"+userId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> list=(List<Shipping>)q.list();
		if(list==null||list.isEmpty()){
			return null;
		}
		return list;
	}	
		
	}


