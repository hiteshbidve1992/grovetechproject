package com.task.grovetech.exceptionhandler;

public class ResourseAlreadyExistsException extends RuntimeException
{
	public ResourseAlreadyExistsException(String msg) 
	{
		super(msg);
	}
}
