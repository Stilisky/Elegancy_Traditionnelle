package com.elegancy.paymentservice.exceptions;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String messages){
        super(messages);
    }
}
