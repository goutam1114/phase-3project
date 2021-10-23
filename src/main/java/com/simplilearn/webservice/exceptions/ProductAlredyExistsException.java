package com.simplilearn.webservice.exceptions;

public class ProductAlredyExistsException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
    String message;
   public ProductAlredyExistsException(String message){
    	super(message);
    }
    
}
