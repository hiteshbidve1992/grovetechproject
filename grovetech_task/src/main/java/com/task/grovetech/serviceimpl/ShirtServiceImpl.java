package com.task.grovetech.serviceimpl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.grovetech.dao.ShirtDao;
import com.task.grovetech.entity.Product;
import com.task.grovetech.service.ShirtService;

@Service
public class ShirtServiceImpl implements ShirtService 
{

	@Autowired
	private ShirtDao shirtDao;
	
	@Override
	public Product addShirt(Product product) 
	{
		String uniqueShirtId = product.getShirtName() + String.valueOf(System.currentTimeMillis());
		product.setShirtId(uniqueShirtId);
		product.setCreated_at(new Date());
		
		return shirtDao.addShirt(product);
		
	}

	@Override
	public List<Product> getAllShirts()
	{
		return shirtDao.getAllShirts();
	}

}
