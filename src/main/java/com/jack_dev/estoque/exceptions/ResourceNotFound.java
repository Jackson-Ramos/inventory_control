package com.jack_dev.estoque.exceptions;

public class ResourceNotFound extends RuntimeException{
	
	public ResourceNotFound(String message){
		super(message);
	}
	
	public ResourceNotFound(){
		super("Resource not found!");
	}
}
