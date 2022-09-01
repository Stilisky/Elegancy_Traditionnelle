package com.elegancy.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private double quantity;
}