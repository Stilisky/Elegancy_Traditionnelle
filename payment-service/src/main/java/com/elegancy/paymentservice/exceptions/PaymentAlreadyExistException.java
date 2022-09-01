package com.elegancy.paymentservice.exceptions;

public class PaymentAlreadyExistException extends RuntimeException{
    public PaymentAlreadyExistException(String message){
        super(message);
    }
}
