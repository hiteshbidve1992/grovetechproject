package com.task.grovetech.dao;

import java.util.List;

import com.task.grovetech.entity.Product;

public interface ShirtDao 
{
	public Product addShirt(Product product);
	public List<Product> getAllShirts();	
}
