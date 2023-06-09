package com.task.grovetech.exceptionhandler;

import java.util.Date;


public class ErrorResponse 
{
	private String errorMessage;
	private Date date;
	
	public ErrorResponse() 
	{
	
	}

	public ErrorResponse(String errorMessage, Date date) 
	{
		super();
		this.errorMessage = errorMessage;
		this.date = date;
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	@Override
	public String toString() 
	{
		return "ErrorResponse [errorMessage=" + errorMessage + ", date=" + date + "]";
	}
	
}
