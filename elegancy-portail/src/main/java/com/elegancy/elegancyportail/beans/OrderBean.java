package com.elegancy.elegancyportail.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderBean {
    private Long id;
    private Date orderedDate;
    private String destination;
    private OrderStatus orderStatus;
}
