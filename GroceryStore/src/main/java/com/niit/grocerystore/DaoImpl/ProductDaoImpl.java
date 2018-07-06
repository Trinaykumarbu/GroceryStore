package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.ProductDao;
import com.niit.grocerystore.model.Category;

import com.niit.grocerystore.model.Product;

@Repository("productDao")
@Transactional


public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getProduct(String productId) {
		String s="from Product where productId='"+productId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Product> lproduct= (List<Product>)q.list();
		if(lproduct==null||lproduct.isEmpty())
		{
			System.out.println("Product list not found");
			return null;
		}
		else
		{
			System.out.println("Product list:");
			return lproduct.get(0);
		}
	}

	@Override
	public List<Product> list() {
		List<Product> products=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return products;
	}
	
	@Override
	public List<Product> getProductByCategory(Category category)
	{
		String category1=category.getCatId();
		String c1="from Product where catId='"+category1+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null||list.isEmpty())
        {
        	return null;
	    }
        else
        {
        	return list;
        }
	}
	
    @Override
	public List<Product> getProductBySupplier(String supplierId)
	{
		
		String c1="from Product where supplierId='"+supplierId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null||list.isEmpty())
        {
        	return null;
	    }
        else
        {
        	return list;
        }
	}

}
