package com.elegancy.paymentservice.dto;

import com.elegancy.paymentservice.entities.PaymentEtat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PaymentRequestDto {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "amont")
    private double amont;
    @JsonProperty(value = "etat")
    private PaymentEtat etat;
}
