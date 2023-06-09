package com.task.grovetech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.grovetech.entity.Product;
import com.task.grovetech.service.ShirtService;

@RestController
@RequestMapping(value = "/shirt")
public class ShirtController 
{

	@Autowired
	private ShirtService shirtService;

	@PostMapping(value = "/addShirts")
	public ResponseEntity<Product> addShirt(@Valid @RequestBody Product product)
	{
		Product addProduct = shirtService.addShirt(product);
		
		return new ResponseEntity<>(addProduct, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllShirts")
	public ResponseEntity<List<Product>> listOfShirt()
	{
		List<Product> allShirts = shirtService.getAllShirts();
		
		return new ResponseEntity<>(allShirts, HttpStatus.OK);
		
		
	}
}
