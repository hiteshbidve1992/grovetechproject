package com.task.grovetech.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="product",  uniqueConstraints={
		   @UniqueConstraint(columnNames={"shirtId", "shirtName"})
		})
public class Product 
{
	@Id
	@Column(unique = true, nullable = false)
	private String shirtId;
	
	@Column(unique = true, nullable = false)
	@NotBlank(message = "Please Enter the name of Shirt")
	private String shirtname;
	
	@Column(nullable = false)
	@NotBlank(message = "Please Enter Description")
	private String description;
	
	@Column(nullable = false)
	@NotBlank(message = "Plaese Enter Brand of Shirt")
	private String brand;
	
	@Column(nullable = false)
	private String[] tags;
	
	@Column(nullable = false)
	@NotBlank(message = "Please Enter the category of Shirt")
	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	public Product() 
	{
		
	}

	public Product(String shirtId, String shirtname, String description, String brand, String[] tags, String category,
			Date created_at) 
	{
		super();
		this.shirtId = shirtId;
		this.shirtname = shirtname;
		this.description = description;
		this.brand = brand;
		this.tags = tags;
		this.category = category;
		this.created_at = created_at;
	}

	public String getShirtId() 
	{
		return shirtId;
	}
	

	public void setShirtId(String shirtId)
	{
		this.shirtId = shirtId;
	}

	public String getShirtName() 
	{
		return shirtname;
	}
	

	public void setShirtName(String shirtName)
	{
		this.shirtname = shirtName;
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getBrand() 
	{
		return brand;
	}

	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public String[] getTags() 
	{
		return tags;
	}

	public void setTags(String[] tags) 
	{
		this.tags = tags;
	}

	public String getCategory() 
	{
		
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public Date getCreated_at() 
	{
		return created_at;
	}

	public void setCreated_at(Date created_at) 
	{
		this.created_at = created_at;
	}

	@Override
	public String toString() 
	{
		return "Product [shirtId=" + shirtId + ", shirtname=" + shirtname + ", description=" + description + ", brand="
				+ brand + ", tags=" + Arrays.toString(tags) + ", category=" + category + ", created_at=" + created_at
				+ "]";
	}

	
}
