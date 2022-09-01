package com.elegancy.paymentservice.mappers;

import com.elegancy.paymentservice.dto.PaymentRequestDto;
import com.elegancy.paymentservice.dto.PaymentResponseDto;
import com.elegancy.paymentservice.entities.Payment;
import com.elegancy.paymentservice.repositories.PaymentRepository;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class PaymentMapper {

    public static PaymentResponseDto paymentToPaymentResponseDto(Payment payment){
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setId(payment.getId());
        responseDto.setAmont(payment.getAmont());
        responseDto.setEtat(payment.getEtat());
        return responseDto;
    }
    public static Payment paymentResponseDtoToPayment(PaymentRequestDto requestDto){
        Payment payment = new Payment();
        payment.setId(requestDto.getId());
        payment.setAmont(requestDto.getAmont());
        payment.setEtat(requestDto.getEtat());
        return payment;
    }
}
