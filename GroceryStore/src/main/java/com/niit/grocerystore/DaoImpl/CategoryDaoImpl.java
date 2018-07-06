package com.niit.grocerystore.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.grocerystore.Dao.CategoryDao;
import com.niit.grocerystore.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	@Override
	public boolean saveorupdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	@Override
	public boolean delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	@Override
	public Category getCategory(String catId) {
		String s="from Category where catId='"+catId+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(s);
		List<Category> lcat= (List<Category>)q.list();
		if(lcat==null||lcat.isEmpty())
		{
			System.out.println("Category list not found");
			return null;
		}
		else
		{
			System.out.println("Category list:");
			return lcat.get(0);
		}
	}

	@Override
	public List<Category> list() {
		List<Category> categories=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return categories;
	}

}
