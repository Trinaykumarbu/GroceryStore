package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.PayDao;
import com.niit.grocerystore.model.Cart;
import com.niit.grocerystore.model.Category;
import com.niit.grocerystore.model.Pay;

@Repository("payDao")
@Transactional

public class PayDaoImpl implements PayDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Override
	public boolean delete(Pay pay) {
		sessionFactory.getCurrentSession().delete(pay);		
		return true;
	}

	@Override
	public Pay getPay(String payId) {
		String s="from Pay where payId='"+payId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Pay> lpay= (List<Pay>)q.list();
		if(lpay==null||lpay.isEmpty())
		{
			System.out.println("Pay list not found");
			return null;
		}
		else
		{
			System.out.println("Pay list:");
			return lpay.get(0);
		}
	}

	@Override
	public List<Pay> list() {
		List<Pay> pays=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pays;
	}

}
