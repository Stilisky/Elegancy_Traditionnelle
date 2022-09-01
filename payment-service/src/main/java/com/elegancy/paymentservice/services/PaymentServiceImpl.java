package com.elegancy.paymentservice.services;

import com.elegancy.paymentservice.dto.PaymentRequestDto;
import com.elegancy.paymentservice.dto.PaymentResponseDto;
import com.elegancy.paymentservice.entities.Payment;
import com.elegancy.paymentservice.exceptions.PaymentNotFoundException;
import com.elegancy.paymentservice.mappers.PaymentMapper;
import com.elegancy.paymentservice.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Override
    public List<PaymentResponseDto> allPayments() {
        List<Payment> payments = repository.findAll();
        List<PaymentResponseDto> responseDtos = new ArrayList<>();
        payments.forEach(payment ->
                responseDtos.add(PaymentMapper.paymentToPaymentResponseDto(payment)));
        return responseDtos;
    }

    @Override
    public PaymentResponseDto getPaymentById(Long id) {
        Payment payresp;
        try {
            payresp = repository.findById(id).get();
        }catch (Exception e){
            throw new PaymentNotFoundException("Ce paiement est introuvable!");
        }
        return PaymentMapper.paymentToPaymentResponseDto(payresp);
    }

    @Override
    public PaymentResponseDto savePayment(PaymentRequestDto requestDto) {
        Payment paysave = repository.save(PaymentMapper.paymentResponseDtoToPayment(requestDto));
        return PaymentMapper.paymentToPaymentResponseDto(paysave);
    }

    @Override
    public PaymentResponseDto updatePayment(Long id,PaymentRequestDto requestDto) {
        Payment payup = repository.findById(id).get();
        if(payup.getAmont() != requestDto.getAmont()) {
            payup.setAmont(requestDto.getAmont());
        }
        if(payup.getEtat() != requestDto.getEtat()){
            payup.setEtat(requestDto.getEtat());
        }
        return PaymentMapper.paymentToPaymentResponseDto(payup);
    }

    @Override
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}
