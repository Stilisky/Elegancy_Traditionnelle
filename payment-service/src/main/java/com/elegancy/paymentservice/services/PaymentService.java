package com.elegancy.paymentservice.services;

import com.elegancy.paymentservice.dto.PaymentRequestDto;
import com.elegancy.paymentservice.dto.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    public List<PaymentResponseDto> allPayments();
    public PaymentResponseDto getPaymentById(Long id);
    public PaymentResponseDto savePayment(PaymentRequestDto requestDto);
    public PaymentResponseDto updatePayment(Long id,PaymentRequestDto requestDto);
    public void deletePayment(Long id);
}
