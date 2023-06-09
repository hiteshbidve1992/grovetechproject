package com.task.grovetech.service;

import java.util.List;

import com.task.grovetech.entity.Product;

public interface ShirtService 
{
	public Product addShirt(Product product);
	public List<Product> getAllShirts();	
}
