package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.SupplierDao;
import com.niit.grocerystore.model.Pay;
import com.niit.grocerystore.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getSupplier(String supplierId) {
		String s="from Supplier where supplierId='"+supplierId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier> lsupplier= (List<Supplier>)q.list();
		if(lsupplier==null||lsupplier.isEmpty())
		{
			System.out.println("Supplier list not found");
			return null;
		}
		else
		{
			System.out.println("Supplier list:");
			return lsupplier.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		List<Supplier> suppliers=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return suppliers;
	}

}
