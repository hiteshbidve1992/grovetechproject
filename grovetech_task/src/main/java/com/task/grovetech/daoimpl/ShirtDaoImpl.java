package com.task.grovetech.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.grovetech.dao.ShirtDao;
import com.task.grovetech.entity.Product;
import com.task.grovetech.exceptionhandler.DataNotFoundException;
import com.task.grovetech.exceptionhandler.ResourseAlreadyExistsException;

@Repository
public class ShirtDaoImpl implements ShirtDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Product addShirt(Product product) 
	{
		Session session = null;
		Product dbProduct = null;
		try 
		{
			session = sessionFactory.openSession();	
			dbProduct = session.get(Product.class, product.getShirtId());
			if(dbProduct != product && product != null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
			}
		} 
		catch (Exception exception) 
		{
			throw new ResourseAlreadyExistsException("The Content is already present in database.....");
		}
		
		finally 
		{
			session.close();
		}
	
			return product;
		
	}

	@Override
	public List<Product> getAllShirts()
	{
		Session session = null;
		List<Product> listOfShirt = null;
		try 
		{
				session = sessionFactory.openSession();
				Criteria criteriaOfShirt = session.createCriteria(Product.class);
				listOfShirt = criteriaOfShirt.list();
			
		}

		finally 
		{
		 session.close();	
		}
		if(!listOfShirt.isEmpty())
		{
			return listOfShirt;
		}
		else
		{
			throw new DataNotFoundException("Data not found in database....");
		}
	}
	

}
