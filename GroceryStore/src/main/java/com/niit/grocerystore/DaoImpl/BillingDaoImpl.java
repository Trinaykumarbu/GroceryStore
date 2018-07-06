package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.BillingDao;
import com.niit.grocerystore.model.Billing;
import com.niit.grocerystore.model.Category;

@Repository("billingDao")
@Transactional

public class BillingDaoImpl implements BillingDao  {
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	@Override
	public boolean saveorupdate(Billing billing) {
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean delete(Billing billing) {
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBilling(String userId) {
		String s="from Billing where userId='"+userId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Billing> lbill= (List<Billing>)q.list();
		if(lbill==null||lbill.isEmpty())
		{
			System.out.println("Billing list not found");
			return null;
		}
		else
		{
			System.out.println("Billing list:");
			return lbill.get(0);
		}
	}

	@Override
	public List<Billing> list() {
		List<Billing> bills=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return bills;
	}

}
