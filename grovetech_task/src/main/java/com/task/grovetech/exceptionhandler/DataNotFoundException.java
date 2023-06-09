package com.task.grovetech.exceptionhandler;

public class DataNotFoundException extends RuntimeException
{
	public DataNotFoundException(String msg) 
	{
		super(msg);
		
	}
}
