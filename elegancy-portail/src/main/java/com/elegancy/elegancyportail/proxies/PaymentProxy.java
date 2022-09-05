package com.elegancy.elegancyportail.proxies;

import com.elegancy.elegancyportail.beans.PaymentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ZUUL-SERVER")
public interface PaymentProxy {
    @GetMapping(path = "/payment-service/api/payments")
    public List<PaymentBean> allPayments();
    @GetMapping(path = "/payment-service/api/payments/{id}")
    public PaymentBean getPaymentById(@PathVariable Long id);
    @PostMapping(path = "/payment-service/api/payments")
    public PaymentBean savePayment(@RequestBody PaymentBean requestDto);
    @PutMapping(path = "/payment-service/api/payments/{id}")
    public PaymentBean updatePayment(@PathVariable Long id,@RequestBody PaymentBean requestDto);
    @DeleteMapping(path = "/payment-service/api/payments/{id}")
    public void deletePayment(@PathVariable Long id);
}
