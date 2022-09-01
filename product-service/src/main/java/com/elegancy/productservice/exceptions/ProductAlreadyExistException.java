package com.elegancy.productservice.exceptions;

public class ProductAlreadyExistException extends RuntimeException{
    public ProductAlreadyExistException(String message){
        super(message);
    }
}
