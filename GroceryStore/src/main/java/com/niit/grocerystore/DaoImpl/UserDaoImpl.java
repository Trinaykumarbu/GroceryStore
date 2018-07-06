package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.model.Authentication;
import com.niit.grocerystore.model.Billing;
import com.niit.grocerystore.model.User;

@Repository("userDao")
@Transactional

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(User user) {
		Authentication auth=new Authentication();
		auth.setUserName(user.getUserEmailid());
		Billing billing=new Billing();
		billing.setBillCity(user.getUserAddress());
		billing.setBillPhnno(user.getUserPhnno());
		user.getBilling().setUser(user);
		user.getBilling().setBillPhnno(user.getUserPhnno());
		user.getBilling().setBillEmailid(user.getUserEmailid());
		user.getBilling().setBillCity(user.getUserAddress());
		user.getBilling().setBillHouseno(user.getUserHouseno());
	    user.getBilling().setBillPincode(user.getUserPincode());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		return true;
	}

	@Override
	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(String userId) {
		String s="from User where userId='"+userId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<User> luser= (List<User>)q.list();
		if(luser==null||luser.isEmpty())
		{
			System.out.println("User list not found");
			return null;
		}
		else
		{
			System.out.println("User list:");
			return luser.get(0);
		}
	}

	@Override
	public List<User> list() {
		List<User> users=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}
	
	@Transactional
	public User isvalid(String userEmailid,String userPassword) {
		String q1="from User where userEmailid='"+userEmailid+"' and userPassword='"+userPassword+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<User> list=(List<User>) w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public User getUseremail(String userEmailid) {
		String q1="from User where userEmailid='"+userEmailid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		return list.get(0);	
	}
	
	@Override
	public User getEmail(String currusername) {
		String u1="from User where userEmailid='"+currusername+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
		    return list.get(0); 	
		}
	}
}
