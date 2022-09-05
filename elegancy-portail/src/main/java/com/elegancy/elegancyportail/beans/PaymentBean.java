package com.elegancy.elegancyportail.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBean {
    private Long id;
    private double amont;
    private PaymentEtat etat;
}
