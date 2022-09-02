package com.elegancy.deliveryservice.dto;

import com.elegancy.deliveryservice.entities.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class DeliveryRequestDto {
    @JsonProperty(value = "id")
    private  Long id;
    @JsonProperty(value = "deliverydate")
    private Date deliveryDate;
    @JsonProperty(value = "clientname")
    private String clientName;
    @JsonProperty(value = "deliverystatus")
    private DeliveryStatus deliveryStatus;
}
