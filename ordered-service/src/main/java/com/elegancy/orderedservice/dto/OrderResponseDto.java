package com.elegancy.orderedservice.dto;

import com.elegancy.orderedservice.entities.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderResponseDto {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "orderedDate")
    private Date orderedDate;
    @JsonProperty(value = "destination")
    private String destination;
    @JsonProperty(value = "orderstatus")
    private OrderStatus orderStatus;
}
