    package com.niit.grocerystore.DaoImpl;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import org.springframework.transaction.annotation.Transactional;


	import com.niit.grocerystore.Dao.AuthenticationDao;
	import com.niit.grocerystore.model.Authentication;


	@Repository("authenticationDao")
	@EnableTransactionManagement
	@Transactional
	public class AuthenticationDaoImpl implements AuthenticationDao {
		@Autowired
		SessionFactory sessionFactory;
		
		public AuthenticationDaoImpl(SessionFactory sessionFactory) {
			       this.sessionFactory=sessionFactory;
		}
		
		@Override
		public boolean saveorupdate(Authentication auth) {
			sessionFactory.getCurrentSession().saveOrUpdate(auth);
			return true;
		}

		
		
		
		public boolean delete(Authentication auth) {
			sessionFactory.getCurrentSession().delete(auth);
			return true;
		}


		
		public List<Authentication> list() {
			List<Authentication> authentication =(List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return authentication;
		}
		
		
		public Authentication get(String id) {
			String q1="from Authentication where role_id='"+id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);
			List<Authentication> list=(List<Authentication>) w.list();
			if(list ==null || list.isEmpty())
			{
				return null;
				
			}
			  return list.get(0);
		}

}

