package com.elegancy.paymentservice.web;

import com.elegancy.paymentservice.dto.PaymentRequestDto;
import com.elegancy.paymentservice.dto.PaymentResponseDto;
import com.elegancy.paymentservice.services.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PaymentAPI {
    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping(path = "/payments")
    public List<PaymentResponseDto> allPayments(){
        return paymentService.allPayments();
    }

    @GetMapping(path = "/payments/{id}")
    public PaymentResponseDto getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping(path = "/payments")
    public PaymentResponseDto savePayment(@RequestBody PaymentRequestDto requestDto){
        return paymentService.savePayment(requestDto);
    }

    @PutMapping(path = "/payments/{id}")
    public PaymentResponseDto updatePayment(@PathVariable Long id,@RequestBody PaymentRequestDto requestDto){
        return paymentService.updatePayment(id, requestDto);
    }
    @DeleteMapping(path = "/payments/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> paymentException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
