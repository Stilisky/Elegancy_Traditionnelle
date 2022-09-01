package com.elegancy.categoryservice.exceptions;

public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String messages){
        super(messages);
    }
}
