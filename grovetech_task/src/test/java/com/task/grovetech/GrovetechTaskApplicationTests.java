package com.task.grovetech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.task.grovetech.controller.ShirtController;
import com.task.grovetech.entity.Product;

@SpringBootTest
class GrovetechTaskApplicationTests 
{
	
	@Test
	public void getAllProducts() throws URISyntaxException
	{
		System.out.println("Testing of Get All Products Begins");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/shirt/getAllShirts";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println("Testing of Get All Products Ends");
	}
	
	@Test
	public void addShirt() throws URISyntaxException
	{
		System.out.println("Testing of Add Product Begins");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/shirt/addShirts";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.postForEntity(uri, new Product(), String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println("Testing of Add Product Ends");
		
	}
	
	

}
