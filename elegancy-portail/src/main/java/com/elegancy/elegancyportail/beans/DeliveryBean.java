package com.elegancy.elegancyportail.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class DeliveryBean {
    private  Long id;
    private Date deliveryDate;
    private String clientName;
    private DeliveryStatus deliveryStatus;
}
