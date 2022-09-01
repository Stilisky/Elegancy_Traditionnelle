package com.elegancy.categoryservice.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String messages){
        super(messages);
    }
}
